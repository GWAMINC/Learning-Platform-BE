package APIGateWay.APIGateWay.controller;

import APIGateWay.APIGateWay.service.LoggingService;
import APIGateWay.APIGateWay.utils.JwtUtil;
import com.example.gatewaycategory.GateWayCategoryRpcProto.*;
import com.example.gatewaycategory.CategoryServiceGrpc;
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

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/course")
public class CourseServiceController {
    private final ManagedChannel courseServiceChannel;
    private final CourseServiceGrpc.CourseServiceBlockingStub courseServiceStub;
    private final CategoryServiceGrpc.CategoryServiceBlockingStub categoryServiceStub;

    @Autowired
    private LoggingService loggingService;

    @Autowired
    private JwtUtil jwtUtil;

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
        this.categoryServiceStub = CategoryServiceGrpc.newBlockingStub(courseServiceChannel);
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

    @PostMapping("/category/create")
    public ResponseEntity<?> createCategory(@RequestHeader("Authorization") String token,@RequestBody Map<String, Object> requestBody) {
        try {
            // Kiểm tra xem người dùng có quyền admin không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("admin")) {
                return ResponseEntity.status(403).body("{\"error\":\"You do not have permission to create category\"}");
            }

            String name = (String) requestBody.get("name");
            String description = (String) requestBody.get("description");

            CreateCategoryRequest createCategoryRequest = CreateCategoryRequest.newBuilder()
                    .setName(name)
                    .setDescription(description)
                    .build();

            CreateCategoryResponse response = categoryServiceStub.createCategory(createCategoryRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "createCategory", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. name and description must be strings.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to create category\"}");
        }
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<String> getCategoryById(@PathVariable int id) {
        try {
            GetCategoryRequest request = GetCategoryRequest.newBuilder()
                    .setId(id)
                    .build();

            GetCategoryResponse response = categoryServiceStub.getCategory(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\""+ "Failed to fetch category\"}" );
        }
    }

    @GetMapping("/category/all")
    public ResponseEntity<String> getAllCategories() {
        try {
            GetAllCategoriesRequest request = GetAllCategoriesRequest.newBuilder().build();
            GetAllCategoriesResponse response = categoryServiceStub.getAllCategories(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch categories\"}");
        }
    }

    @PostMapping("/category/update")
    public ResponseEntity<?> updateCategory(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        try {
            // Kiểm tra xem người dùng có quyền admin không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("admin")) {
                return ResponseEntity.status(403).body("{\"error\":\"You do not have permission to update category\"}");
            }

            int id = (int) requestBody.get("id");
            String name = (String) requestBody.get("name");
            String description = (String) requestBody.get("description");

            UpdateCategoryRequest updateCategoryRequest = UpdateCategoryRequest.newBuilder()
                    .setId(id)
                    .setName(name)
                    .setDescription(description)
                    .build();

            UpdateCategoryResponse response = categoryServiceStub.updateCategory(updateCategoryRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "updateCategory", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. id must be integer, name and description must be strings.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to update category\"}");
        }
    }

    @DeleteMapping("/category/delete")
    public ResponseEntity<?> deleteCategory(@RequestHeader("Authorization") String token, @RequestParam int id) {
        try {
            // Kiểm tra xem người dùng có quyền admin không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("admin")) {
                return ResponseEntity.status(403).body("{\"error\":\"You do not have permission to delete category\"}");
            }

            DeleteCategoryRequest deleteCategoryRequest = DeleteCategoryRequest.newBuilder()
                    .setId(id)
                    .build();

            DeleteCategoryResponse response = categoryServiceStub.deleteCategory(deleteCategoryRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "deleteCategory", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to delete category\"}");
        }
    }

    @PostMapping("/enrolled")
    public ResponseEntity<?> getViewEnrolledCourses(@RequestBody Map<String, Object> requestBody) {
        try {
            Object userIdObj = requestBody.get("userId");
            if (userIdObj == null) {
                return ResponseEntity.badRequest().body("{\"error\":\"Missing userId\"}");
            }
            int userId = (userIdObj instanceof Number) ? ((Number) userIdObj).intValue() : Integer.parseInt(userIdObj.toString());
            System.out.println("Request Body: " + userId);
            // Gửi request với thông tin
            GetViewEnrollCourseRequest request = GetViewEnrollCourseRequest.newBuilder()
                    .setId(userId)
                    .build();

            GetViewEnrollCourseResponse response = courseServiceStub.viewEnrollCourse(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch courses\"}");
        }
    }

    @PreDestroy
    public void shutdown() {
        // Đóng kết nối khi ứng dụng dừng
        courseServiceChannel.shutdown();
    }
}