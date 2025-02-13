package APIGateWay.APIGateWay.controller;

import APIGateWay.APIGateWay.service.LoggingService;
import com.example.gatewaycourse.GateWayCourseRpcProto;
import com.example.gatewaycourse.CourseServiceGrpc;
import com.example.gatewaycourse.GateWayCourseRpcProto.*;
import com.google.protobuf.util.JsonFormat;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@RestController
@RequestMapping("/api/course")
public class CourseServiceController {
    private final ManagedChannel courseServiceChannel;
    private final CourseServiceGrpc.CourseServiceBlockingStub courseServiceStub;

    @Autowired
    private LoggingService loggingService;

    public CourseServiceController() {
        // Kết nối tới user-service qua gRPC
        // Chạy Docker container với tên là "user-service"
        this.courseServiceChannel = ManagedChannelBuilder.forAddress("course-service", 50051)
                .usePlaintext()
                .build();
        // Chạy local
//        this.courseServiceChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
//                .usePlaintext()
//                .build();
        this.courseServiceStub = CourseServiceGrpc.newBlockingStub(courseServiceChannel);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getCourseById(@PathVariable int id) {
        try {
            // Gửi request đến user-service qua gRPC
            GetCourseRequest request = GetCourseRequest.newBuilder()
                    .setId(id)
                    .build();

            GetCourseResponse response = courseServiceStub.getCourse(request);

            loggingService.logAPIActivity(200, "getCourseById", response.toString());

            // Chuyển đổi từ protobuf sang JSON
            String json = JsonFormat.printer().includingDefaultValueFields().print(response);

            // Trả về với Content-Type là application/json
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch course\"}");
        }
    }
    @GetMapping("/list")
    public ResponseEntity<String> getAllCourses(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            // Gửi request với thông tin phân trang
            GetAllCoursesRequest request = GetAllCoursesRequest.newBuilder()
                    .setPage(page)
                    .setSize(size)
                    .build();

            GetAllCoursesResponse response = courseServiceStub.getAllCourses(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch courses\"}");
        }
    }
    @PostMapping("/enroll")
    public ResponseEntity<?> enrollCourse(@RequestBody Map<String, Object> requestBody) {
        try {
            // Lấy dữ liệu từ request body và ép kiểu
            int userId = (int) requestBody.get("userId");
            int courseId = (int) requestBody.get("courseId");

            // Tạo request gRPC
            GateWayCourseRpcProto.EnrollRequest enrollRequest = GateWayCourseRpcProto.EnrollRequest.newBuilder()
                    .setUserId(userId)
                    .setCourseId(courseId)
                    .build();

            // Gửi request đến enroll-service
            EnrollResponse response = courseServiceStub.enrollCourse(enrollRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "enrollCourse", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. userId and courseId must be integers.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to enroll course\"}");
        }
    }

    @PreDestroy
    public void shutdown() {
        // Đóng kết nối khi ứng dụng dừng
        courseServiceChannel.shutdown();
    }
}