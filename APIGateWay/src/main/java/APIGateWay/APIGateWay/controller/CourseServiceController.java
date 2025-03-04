package APIGateWay.APIGateWay.controller;

import APIGateWay.APIGateWay.service.LoggingService;
import APIGateWay.APIGateWay.utils.JwtUtil;
import com.example.gatewaycategory.GateWayCategoryRpcProto.*;
import com.example.gatewaycategory.CategoryServiceGrpc;
import com.example.gatewaycoupon.CouponServiceGrpc;
import com.example.gatewaycoupon.GateWayCouponRpcProto.*;
import com.example.gatewaycourse.GateWayCourseRpcProto;
import com.example.gatewaycourse.CourseServiceGrpc;
import com.example.gatewaycourse.GateWayCourseRpcProto.*;
import com.example.gatewaycoursecategory.CourseCategoryServiceGrpc;
import com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.*;
import com.example.gatewaylesson.GateWayLessonRpcProto.*;
import com.example.gatewaylesson.LessonServiceGrpc;
import com.example.gatewayunit.UnitServiceGrpc;
import com.example.gatewayunit.GateWayUnitRpcProto.*;
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
    private final UnitServiceGrpc.UnitServiceBlockingStub unitServiceStub;
    private final LessonServiceGrpc.LessonServiceBlockingStub lessonServiceStub;
    private final CourseCategoryServiceGrpc.CourseCategoryServiceBlockingStub courseCategoryServiceStub;
    private final CouponServiceGrpc.CouponServiceBlockingStub couponServiceStub;

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
        this.unitServiceStub = UnitServiceGrpc.newBlockingStub(courseServiceChannel);
        this.lessonServiceStub = LessonServiceGrpc.newBlockingStub(courseServiceChannel);
        this.courseCategoryServiceStub = CourseCategoryServiceGrpc.newBlockingStub(courseServiceChannel);
        this.couponServiceStub = CouponServiceGrpc.newBlockingStub(courseServiceChannel);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCourse(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        try {
            // Kiểm tra xem người dùng có quyền teacher không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("teacher")) {
                return ResponseEntity.status(401).body("{\"error\":\"You do not have permission to create course\"}");
            }

            String title = (String) requestBody.get("title");
            String description = (String) requestBody.get("description");

            CreateCourseRequest createCourseRequest = CreateCourseRequest.newBuilder()
                    .setTitle(title)
                    .setDescription(description)
                    .build();

            CreateCourseResponse response = courseServiceStub.createCourse(createCourseRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "createCourse", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. title and description must be strings.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to create course\"}");
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCourse(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        try {
            // Kiểm tra xem người dùng có quyền teacher không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("teacher")) {
                return ResponseEntity.status(401).body("{\"error\":\"You do not have permission to update course\"}");
            }

            int id = (int) requestBody.get("id");
            String title = (String) requestBody.get("title");
            String description = (String) requestBody.get("description");

            UpdateCourseRequest updateCourseRequest = UpdateCourseRequest.newBuilder()
                    .setId(id)
                    .setTitle(title)
                    .setDescription(description)
                    .build();

            UpdateCourseResponse response = courseServiceStub.updateCourse(updateCourseRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "updateCourse", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. id must be integer, title and description must be strings.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to update course\"}");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCourse(@RequestHeader("Authorization") String token, @RequestParam int id) {
        try {
            // Kiểm tra xem người dùng có quyền teacher không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("teacher")) {
                return ResponseEntity.status(401).body("{\"error\":\"You do not have permission to delete course\"}");
            }

            DeleteCourseRequest deleteCourseRequest = DeleteCourseRequest.newBuilder()
                    .setId(id)
                    .build();

            DeleteCourseResponse response = courseServiceStub.deleteCourse(deleteCourseRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "deleteCourse", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to delete course\"}");
        }
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
    @GetMapping("/categories_courses")
    public ResponseEntity<String> getCoursesByCategories(@RequestParam List<Integer> categoryIds) {
        try {
            GetCoursesByCategoriesRequest request = GetCoursesByCategoriesRequest.newBuilder()
                    .addAllCategoryId(categoryIds)
                    .build();

            GetCoursesByCategoriesResponse response = courseServiceStub.getCoursesByCategories(request);

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
    @PostMapping("course_category/create")
    public ResponseEntity<?> createCourseCategories(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        try {
            // Kiểm tra xem người dùng có quyền teacher không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("teacher")) {
                return ResponseEntity.status(401).body("{\"error\":\"You do not have permission to create unit\"}");
            }

            int courseId = (int) requestBody.get("courseId");
            List<Integer> categoryIds = null;
            if (requestBody.get("categoriesId") instanceof List<?>) {
                categoryIds = ((List<?>) requestBody.get("categoriesId"))
                        .stream()
                        .filter(item -> item instanceof Integer) // Đảm bảo chỉ lấy số nguyên
                        .map(item -> (Integer) item)
                        .toList();
            }

            CreateCourseCategoriesRequest.Builder request = CreateCourseCategoriesRequest.newBuilder()
                    .addAllCategoryId(categoryIds)
                    .setCourseId(courseId);
            CreateCourseCategoriesResponse response = courseCategoryServiceStub.createCourseCategories(request.build());
            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(500).body("{\"error\":\"Failed to create course categories\"}");
        }
    }
    @DeleteMapping("course_category/delete")
    public ResponseEntity<?> deleteCourseCategory(@RequestHeader("Authorization") String token, @RequestParam int id) {
        try {
            // Kiểm tra xem người dùng có quyền teacher không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("teacher")) {
                return ResponseEntity.status(401).body("{\"error\":\"You do not have permission to delete course category\"}");
            }

            DeleteCourseCategoryRequest request = DeleteCourseCategoryRequest.newBuilder()
                    .setId(id)
                    .build();

            DeleteCourseCategoryResponse response = courseCategoryServiceStub.deleteCourseCategory(request);
            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to delete course category\"}");
        }
    }

    @PostMapping("/unit/create")
    public ResponseEntity<?> createUnit(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        try {
            // Kiểm tra xem người dùng có quyền teacher không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("teacher")) {
                return ResponseEntity.status(401).body("{\"error\":\"You do not have permission to create unit\"}");
            }

            String name = (String) requestBody.get("name");
            int courseId = (int) requestBody.get("courseId");

            CreateUnitRequest createUnitRequest = CreateUnitRequest.newBuilder()
                    .setName(name)
                    .setCourseId(courseId)
                    .build();

            CreateUnitResponse response = unitServiceStub.createUnit(createUnitRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "createUnit", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. name must be string, courseId must be integer.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to create unit\"}");
        }
    }

    @GetMapping("/unit/all")
    public ResponseEntity<String> getUnitsByCourse(@RequestParam int courseId) {
        try {
            GetUnitsByCourseRequest request = GetUnitsByCourseRequest.newBuilder()
                    .setCourseId(courseId)
                    .build();

            GetUnitsByCourseResponse response = unitServiceStub.getUnitsByCourse(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch units\"}");
        }
    }

    @PostMapping("/unit/update")
    public ResponseEntity<?> updateUnit(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        try {
            // Kiểm tra xem người dùng có quyền teacher không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("teacher")) {
                return ResponseEntity.status(401).body("{\"error\":\"You do not have permission to update unit\"}");
            }

            int id = (int) requestBody.get("id");
            String name = (String) requestBody.get("name");
            int courseId = (int) requestBody.get("courseId");

            UpdateUnitRequest updateUnitRequest = UpdateUnitRequest.newBuilder()
                    .setId(id)
                    .setName(name)
                    .setCourseId(courseId)
                    .build();

            UpdateUnitResponse response = unitServiceStub.updateUnit(updateUnitRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "updateUnit", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. id must be integer, name must be string, courseId must be integer.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to update unit\"}");
        }
    }

    @DeleteMapping("/unit/delete")
    public ResponseEntity<?> deleteUnit(@RequestHeader("Authorization") String token, @RequestParam int id) {
        try {
            // Kiểm tra xem người dùng có quyền teacher không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("teacher")) {
                return ResponseEntity.status(401).body("{\"error\":\"You do not have permission to delete unit\"}");
            }

            DeleteUnitRequest deleteUnitRequest = DeleteUnitRequest.newBuilder()
                    .setId(id)
                    .build();

            DeleteUnitResponse response = unitServiceStub.deleteUnit(deleteUnitRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "deleteUnit", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to delete unit\"}");
        }
    }

    @PostMapping("/lesson/create")
    public ResponseEntity<?> createLesson(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        try {
            // Kiểm tra xem người dùng có quyền teacher không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("teacher")) {
                return ResponseEntity.status(401).body("{\"error\":\"You do not have permission to create lesson\"}");
            }

            String name = (String) requestBody.get("name");
            String content = (String) requestBody.get("content");
            int unitId = (int) requestBody.get("unitId");

            CreateLessonRequest createLessonRequest = CreateLessonRequest.newBuilder()
                    .setName(name)
                    .setContent(content)
                    .setCourseUnitId(unitId)
                    .build();

            CreateLessonResponse response = lessonServiceStub.createLesson(createLessonRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "createLesson", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. name and description must be strings, unitId must be integer.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to create lesson\"}");
        }
    }

    @GetMapping("/lesson/{id}")
    public ResponseEntity<String> getLessonById(@PathVariable int id) {
        try {
            GetLessonRequest request = GetLessonRequest.newBuilder()
                    .setId(id)
                    .build();

            GetLessonResponse response = lessonServiceStub.getLesson(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch lesson\"}");
        }
    }

    @GetMapping("/lesson/all")
    public ResponseEntity<String> getAllLessonsByUnit(@RequestParam int unitId) {
        try {
            GetAllLessonsByUnitRequest request = GetAllLessonsByUnitRequest.newBuilder()
                    .setCourseUnitId(unitId)
                    .build();

            GetAllLessonsByUnitResponse response = lessonServiceStub.getAllLessonsByUnit(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            if (e.getMessage().equals("Lesson not found")) {
                return ResponseEntity.status(404).body("{\"error\":\"Lesson not found\"}");
            }
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch lesson\"}");
        }
    }

    @PostMapping("/lesson/update")
    public ResponseEntity<?> updateLesson(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        try {
            // Kiểm tra xem người dùng có quyền teacher không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("teacher")) {
                return ResponseEntity.status(401).body("{\"error\":\"You do not have permission to update lesson\"}");
            }
            int id = (int) requestBody.get("id");
            String name = (String) requestBody.get("name");
            String content = (String) requestBody.get("content");
            int unitId = (int) requestBody.get("unitId");
            int orderNumber = (int) requestBody.get("orderNumber");

            UpdateLessonRequest updateLessonRequest = UpdateLessonRequest.newBuilder()
                    .setId(id)
                    .setName(name)
                    .setContent(content)
                    .setCourseUnitId(unitId)
                    .setOrderNumber(orderNumber)
                    .build();

            UpdateLessonResponse response = lessonServiceStub.updateLesson(updateLessonRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "updateLesson", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. id must be integer, name and content must be strings, unitId must be integer.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to update lesson\"}");
        }
    }

    @DeleteMapping("/lesson/delete")
    public ResponseEntity<?> deleteLesson(@RequestHeader("Authorization") String token, @RequestParam int id) {
        try {
            // Kiểm tra xem người dùng có quyền teacher không
            if (!jwtUtil.extractRoles(token.substring(7)).equals("teacher")) {
                return ResponseEntity.status(401).body("{\"error\":\"You do not have permission to delete lesson\"}");
            }

            DeleteLessonRequest deleteLessonRequest = DeleteLessonRequest.newBuilder()
                    .setId(id)
                    .build();

            DeleteLessonResponse response = lessonServiceStub.deleteLesson(deleteLessonRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "deleteLesson", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to delete lesson\"}");
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
    @PostMapping("/unenroll")
    public ResponseEntity<?> UnenrollCourse(@RequestBody Map<String, Object> requestBody) {
        try {
            // Lấy dữ liệu từ request body và ép kiểu
            int userId = (int) requestBody.get("userId");
            int courseId = (int) requestBody.get("courseId");

            // Tạo request gRPC
            GateWayCourseRpcProto.UnEnrollRequest unenrollRequest = GateWayCourseRpcProto.UnEnrollRequest.newBuilder()
                    .setUserId(userId)
                    .setCourseId(courseId)
                    .build();

            // Gửi request đến enroll-service
            UnEnrollResponse response = courseServiceStub.unEnrollCourse(unenrollRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "enrollCourse", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. userId and courseId must be integers.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to unenroll course\"}");
        }
    }

    @PostMapping("/viewteacher")
    public ResponseEntity<?> viewTeacherCourse(@RequestBody Map<String, Object> requestBody) {
        try {
            Object teacher_id = requestBody.get("teacher_id");
            if (teacher_id == null) {
                return ResponseEntity.badRequest().body("{\"error\":\"Missing userId\"}");
            }
            int teacherId = (teacher_id instanceof Number) ? ((Number) teacher_id).intValue() : Integer.parseInt(teacher_id.toString());
            System.out.println("Request Body: " + teacher_id);
            // Gửi request với thông tin
            ViewTeacherRequest request = ViewTeacherRequest.newBuilder()
                    .setTeacherId(teacherId)
                    .build();

            ViewTeacherResponse response = courseServiceStub.viewTeacherCourse(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch courses\"}");
        }
    }
    @PostMapping("/coupon/create")
    public ResponseEntity<?> createCoupon(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        try {
            if (!jwtUtil.extractRoles(token.substring(7)).equals("admin")) {
                return ResponseEntity.status(403).body("{\"error\":\"You do not have permission to create coupon\"}");
            }

            String code = (String) requestBody.get("code");
            Double discount = (Double) requestBody.get("discount");
            String expirationDate = (String) requestBody.get("expirationDate");
            int createdBy = (int) requestBody.get("createdBy");

            CreateCouponRequest createCouponRequest = CreateCouponRequest.newBuilder()
                    .setCode(code)
                    .setDiscountPercentage(discount)
                    .setExpirationDate(expirationDate)
                    .setCreatedBy(createdBy)
                    .build();

            CreateCouponResponse response = couponServiceStub.createCoupon(createCouponRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "createCoupon", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. code must be string, discount must be float, expirationDate must be string.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to create coupon\"}");
        }
    }

    @GetMapping("/coupon/{id}")
    public ResponseEntity<String> getCouponById(@PathVariable int id) {
        try {
            GetCouponRequest request = GetCouponRequest.newBuilder()
                    .setId(id)
                    .build();

            GetCouponResponse response = couponServiceStub.getCoupon(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch coupon\"}");
        }
    }

    @GetMapping("/coupon/code")
    public ResponseEntity<String> getCouponByCode(@RequestParam String code) {
        try {
            GetCouponByCodeRequest request = GetCouponByCodeRequest.newBuilder()
                    .setCode(code)
                    .build();

            GetCouponByCodeResponse response = couponServiceStub.getCouponByCode(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch coupon\"}");
        }
    }

    @GetMapping("/coupon/all")
    public ResponseEntity<String> getAllCoupons() {
        try {
            GetAllCouponsRequest request = GetAllCouponsRequest.newBuilder().build();
            GetAllCouponsResponse response = couponServiceStub.getAllCoupons(request);

            String json = JsonFormat.printer().print(response);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/json")
                    .body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to fetch coupons\"}");
        }
    }

    @PostMapping("/coupon/update")
    public ResponseEntity<?> updateCoupon(@RequestHeader("Authorization") String token, @RequestBody Map<String, Object> requestBody) {
        try {
            if (!jwtUtil.extractRoles(token.substring(7)).equals("admin")) {
                return ResponseEntity.status(403).body("{\"error\":\"You do not have permission to update coupon\"}");
            }

            int id = (int) requestBody.get("id");
            String code = (String) requestBody.get("code");
            double discount = (double) requestBody.get("discount");
            String expirationDate = (String) requestBody.get("expirationDate");
            int createdBy = (int) requestBody.get("createdBy");

            UpdateCouponRequest updateCouponRequest = UpdateCouponRequest.newBuilder()
                    .setId(id)
                    .setCode(code)
                    .setDiscountPercentage(discount)
                    .setExpirationDate(expirationDate)
                    .setCreatedBy(createdBy)
                    .build();

            UpdateCouponResponse response = couponServiceStub.updateCoupon(updateCouponRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "updateCoupon", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (ClassCastException e) {
            return ResponseEntity.status(400).body("{\"error\":\"Invalid data format. id must be integer, code must be string, discount must be float, expirationDate must be string.\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to update coupon\"}");
        }
    }

    @DeleteMapping("/coupon/delete")
    public ResponseEntity<?> deleteCoupon(@RequestHeader("Authorization") String token, @RequestParam int id) {
        try {
            if (!jwtUtil.extractRoles(token.substring(7)).equals("admin")) {
                return ResponseEntity.status(403).body("{\"error\":\"You do not have permission to delete coupon\"}");
            }

            DeleteCouponRequest deleteCouponRequest = DeleteCouponRequest.newBuilder()
                    .setId(id)
                    .build();

            DeleteCouponResponse response = couponServiceStub.deleteCoupon(deleteCouponRequest);
            String json = JsonFormat.printer().print(response);

            loggingService.logAPIActivity(200, "deleteCoupon", response.toString());
            return ResponseEntity.ok().header("Content-Type", "application/json").body(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("{\"error\":\"Failed to delete coupon\"}");
        }
    }

    @PreDestroy
    public void shutdown() {
        // Đóng kết nối khi ứng dụng dừng
        courseServiceChannel.shutdown();
    }
}