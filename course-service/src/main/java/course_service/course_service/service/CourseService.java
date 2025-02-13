package course_service.course_service.service;

import com.example.gatewaycourse.GateWayCourseRpcProto;
import com.example.gatewaycourse.CourseServiceGrpc;
import com.example.gatewaycourse.GateWayCourseRpcProto.*;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import course_service.course_service.repository.CourseRepository;

import java.util.List;
import java.util.Map;


@Service
public class CourseService extends CourseServiceGrpc.CourseServiceImplBase {
    private final CourseRepository courseRepository;

    @Autowired
    private LoggingService loggingService;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void getCourse(GateWayCourseRpcProto.GetCourseRequest request, StreamObserver<GateWayCourseRpcProto.GetCourseResponse> responseObserver) {
        // Lấy dữ liệu từ database
        try {


            Map<String, Object> result = courseRepository.findCourseById(request.getId());
            if (result == null || result.isEmpty()) {
                responseObserver.onError(new RuntimeException("Course not found"));
                loggingService.logError(new RuntimeException("Course not found"), "getCourse");
                return;
            }

            // Map dữ liệu vào Protobuf từ Map<String, Object>
            GateWayCourseRpcProto.Course course = GateWayCourseRpcProto.Course.newBuilder()
                    .setId((Integer) result.get("id"))
                    .setTitle((String) result.get("title"))
                    .setDescription((String) result.get("description"))
                    .setCreatedAt(result.get("created_at").toString())
                    .setUpdatedAt(result.get("updated_at").toString())
                    .build();

            // Tạo response
            GetCourseResponse response = GetCourseResponse.newBuilder().setCourse(course).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logCourseActivity(200, "getCourse", response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void getAllCourses(GetAllCoursesRequest request, StreamObserver<GetAllCoursesResponse> responseObserver) {
        int page = request.getPage();  // Nhận tham số trang từ request
        int size = request.getSize();  // Nhận số lượng phần tử mỗi trang từ request
        int offset = (page - 1) * size;

        // Lấy danh sách từ database với phân trang
        List<Map<String, Object>> results = courseRepository.findAllCourses(size, offset);
        int totalCourses = courseRepository.countTotalCourses();
        int totalPages = (int) Math.ceil((double) totalCourses / size);

        // Map danh sách vào Protobuf từ List<Map<String, Object>>
        List<GateWayCourseRpcProto.Course> courses = results.stream().map(row -> GateWayCourseRpcProto.Course.newBuilder()
                .setId((Integer) row.get("id"))
                .setTitle((String) row.get("title"))
                .setDescription((String) row.get("description"))
                .setCreatedAt(row.get("created_at").toString())
                .setUpdatedAt(row.get("updated_at").toString())
                .build()).toList();

        // Tạo response có thêm totalPages và totalCourses
        GetAllCoursesResponse response = GetAllCoursesResponse.newBuilder()
                .addAllCourses(courses)
                .setTotalPages(totalPages)
                .setTotalCourses(totalCourses)
                .setCurrentPage(page)
                .setPageSize(size)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void enrollCourse(EnrollRequest request, StreamObserver<EnrollResponse> responseObserver) {
        int userId = request.getUserId();
        int courseId = request.getCourseId();

        // Kiểm tra xem người dùng đã đăng ký khóa học chưa
        boolean isEnrolled = courseRepository.isUserEnrolled(userId, courseId);
        if (isEnrolled) {
            // Nếu đã đăng ký, trả về thông báo lỗi
            EnrollResponse response = EnrollResponse.newBuilder()
                    .setSuccess(false)
                    .setMessage("Bạn đã đăng ký khóa học này rồi!")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            return;
        }

        // Nếu chưa đăng ký, tiến hành lưu vào DB
        boolean success = courseRepository.enrollUser(userId, courseId);
        String message = success ? "Đăng ký khóa học thành công!" : "Đăng ký thất bại!";

        EnrollResponse response = EnrollResponse.newBuilder()
                .setSuccess(success)
                .setMessage(message)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
