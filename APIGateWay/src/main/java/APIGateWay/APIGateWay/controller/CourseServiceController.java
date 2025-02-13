package APIGateWay.APIGateWay.controller;

import APIGateWay.APIGateWay.service.LoggingService;
import com.example.gatewaycourse.CourseCategoryServiceGrpc;
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
    private final CourseCategoryServiceGrpc.CourseCategoryServiceBlockingStub courseCategoryServiceStub;

    @Autowired
    private LoggingService loggingService;

    public CourseServiceController() {
        // Kết nối tới course-service qua gRPC
        // Chạy Docker container với tên là "course-service"
        this.courseServiceChannel = ManagedChannelBuilder.forAddress("course-service", 50051)
                .usePlaintext()
                .build();
        // Chạy local
//        this.courseServiceChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
//                .usePlaintext()
//                .build();
        this.courseServiceStub = CourseServiceGrpc.newBlockingStub(courseServiceChannel);
        this.courseCategoryServiceStub = CourseCategoryServiceGrpc.newBlockingStub(courseServiceChannel);
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

    @PostMapping("/course_category/create")
    public ResponseEntity<String> createCourseCategory(@RequestBody Map<String, Object> requestBody) {
        try {
            int courseId = Integer.parseInt(requestBody.get("course_id").toString());
            int categoryId = Integer.parseInt(requestBody.get("category_id").toString());
            CreateCourseCategoryRequest request = CreateCourseCategoryRequest.newBuilder()
                    .setCourseId(courseId)
                    .setCategoryId(categoryId)
                    .build();

            CreateCourseCategoryResponse response = courseCategoryServiceStub.createCourseCategory(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to create course category\"}");
        }
    }

    @GetMapping("/course_category/{id}")
    public ResponseEntity<String> getCourseCategoryById(@PathVariable int id) {
        try {
            GetCourseCategoryRequest request = GetCourseCategoryRequest.newBuilder()
                    .setId(id)
                    .build();

            GetCourseCategoryResponse response = courseCategoryServiceStub.getCourseCategory(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch course category\"}");
        }
    }

    @GetMapping("/course_category/list")
    public ResponseEntity<String> getCourseCategoriesByCourseId(@RequestParam int course_id) {
        try {
            GetCourseCategoryByCourseIdRequest request = GetCourseCategoryByCourseIdRequest.newBuilder()
                    .setCourseId(course_id)
                    .build();

            GetCourseCategoryByCourseIdResponse response = courseCategoryServiceStub.getCourseCategoryByCourseId(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch course categories\"}");
        }
    }

    @PostMapping("/course_category/update")
    public ResponseEntity<String> updateCourseCategory(@RequestBody Map<String, Object> requestBody) {
        try {
            int id = Integer.parseInt(requestBody.get("id").toString());
            int courseId = Integer.parseInt(requestBody.get("course_id").toString());
            int categoryId = Integer.parseInt(requestBody.get("category_id").toString());
            UpdateCourseCategoryRequest request = UpdateCourseCategoryRequest.newBuilder()
                    .setId(id)
                    .setCourseId(courseId)
                    .setCategoryId(categoryId)
                    .build();

            UpdateCourseCategoryResponse response = courseCategoryServiceStub.updateCourseCategory(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to update course category\"}");
        }
    }

    @DeleteMapping("/course_category/delete/{id}")
    public ResponseEntity<String> deleteCourseCategory(@PathVariable int id) {
        try {
            DeleteCourseCategoryRequest request = DeleteCourseCategoryRequest.newBuilder()
                    .setId(id)
                    .build();

            DeleteCourseCategoryResponse response = courseCategoryServiceStub.deleteCourseCategory(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to delete course category\"}");
        }
    }
    @PreDestroy
    public void shutdown() {
        // Đóng kết nối khi ứng dụng dừng
        courseServiceChannel.shutdown();
    }
}