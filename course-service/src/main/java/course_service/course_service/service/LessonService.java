package course_service.course_service.service;

import com.example.gatewaylesson.GateWayLessonRpcProto.*;
import com.example.gatewaylesson.LessonServiceGrpc;
import com.fasterxml.jackson.databind.ObjectMapper;
import course_service.course_service.repository.CourseRepository;
import course_service.course_service.repository.LessonRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LessonService extends LessonServiceGrpc.LessonServiceImplBase {
    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;
    @Autowired
    private LoggingService loggingService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public LessonService(LessonRepository lessonRepository, CourseRepository courseRepository) {
        this.lessonRepository = lessonRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void createLesson(CreateLessonRequest request, StreamObserver<CreateLessonResponse> responseObserver) {
        try {
            // Xác định thứ tự bài học trong CourseUnit
            int orderNumber = lessonRepository.getLessonOrderNumber(request.getCourseUnitId());
            int lessonId = lessonRepository.createLesson(request.getName(), request.getContent(), request.getCourseUnitId(), orderNumber);

            // Lấy thông tin khóa học và học phần
            String courseName = courseRepository.getCourseNameByCourseUnitId(request.getCourseUnitId());  // Lấy tên khóa học
            String courseUnitName = courseRepository.getCourseUnitNameById(request.getCourseUnitId()); // Lấy tên học phần

            // Lấy danh sách user đã đăng ký khóa học
            List<Long> userIds = courseRepository.getEnrolledUsers(request.getCourseUnitId());

            // Tạo thông báo gửi RabbitMQ
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> message = new HashMap<>();
            message.put("type", "lesson"); // Loại thông báo
            message.put("refId", lessonId); // ID của bài học mới
            message.put("content", "Bài học mới: " + request.getName() +
                    " trong học phần " + courseUnitName +
                    " của khóa học " + courseName); // Nội dung chi tiết
            message.put("userIds", userIds); // Danh sách người nhận

            // Ghi log trước khi gửi
            System.out.println("📢 Sending Notification: " + message);

            // Chuyển sang JSON và gửi qua RabbitMQ
            String jsonMessage = objectMapper.writeValueAsString(message);
            rabbitTemplate.convertAndSend("notificationExchange", "notificationRoutingKey", jsonMessage);

            // Phản hồi thành công
            CreateLessonResponse response = CreateLessonResponse.newBuilder()
                    .setStatus("true")
                    .setMessage("Create lesson successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logLessonActivity(200, "createLesson", response.toString());

        } catch (Exception e) {
            CreateLessonResponse response = CreateLessonResponse.newBuilder()
                    .setStatus("false")
                    .setMessage(e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logLessonActivity(400, "createLesson", response.toString());
        }
    }

    @Override
    public void getLesson(GetLessonRequest request, StreamObserver<GetLessonResponse> responseObserver) {
        try {
            var lesson = lessonRepository.findLessonById(request.getId());

            if (lesson.isPresent()) {
                Lesson lesson_response = Lesson.newBuilder()
                        .setId((int) lesson.get().get("id"))
                        .setName((String) lesson.get().get("name"))
                        .setContent((String) lesson.get().get("content"))
                        .setCourseUnitId((int) lesson.get().get("course_unit_id"))
                        .setOrderNumber((int) lesson.get().get("order_number"))
                        .build();
                GetLessonResponse response = GetLessonResponse.newBuilder()
                        .setLesson(lesson_response)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                loggingService.logLessonActivity(200, "getLesson", response.toString());
            } else {
                GetLessonResponse.Builder response = GetLessonResponse.newBuilder();
                responseObserver.onNext(response.build());
                responseObserver.onCompleted();
            }
        } catch (Exception e) {
            responseObserver.onError(e);
            loggingService.logLessonActivity(400, "getLesson", e.getMessage());
        }
    }

    @Override
    public void getAllLessonsByUnit(GetAllLessonsByUnitRequest request, StreamObserver<GetAllLessonsByUnitResponse> responseObserver) {
        try {
            var lessons = lessonRepository.findLessonsByUnitId(request.getCourseUnitId());
            GetAllLessonsByUnitResponse.Builder response = GetAllLessonsByUnitResponse.newBuilder();
            for (var lesson : lessons) {
                Lesson lesson_response = Lesson.newBuilder()
                        .setId((int) lesson.get("id"))
                        .setName((String) lesson.get("name"))
                        .setContent((String) lesson.get("content"))
                        .setCourseUnitId((int) lesson.get("course_unit_id"))
                        .setOrderNumber((int) lesson.get("order_number"))
                        .build();
                response.addLessons(lesson_response);
            }

            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            loggingService.logLessonActivity(200, "getAllLessonsByUnitId", response.toString());
        } catch (Exception e) {
            responseObserver.onError(e);
            loggingService.logLessonActivity(400, "getAllLessonsByUnitId", e.getMessage());
        }
    }

    @Override
    public void updateLesson(UpdateLessonRequest request, StreamObserver<UpdateLessonResponse> responseObserver) {
        try {
            lessonRepository.updateLesson(request.getId(), request.getName(), request.getContent(), request.getCourseUnitId(), request.getOrderNumber());

            Lesson lesson_updated = Lesson.newBuilder()
                    .setId(request.getId())
                    .setName(request.getName())
                    .setContent(request.getContent())
                    .setCourseUnitId(request.getCourseUnitId())
                    .setOrderNumber(request.getOrderNumber())
                    .build();

            UpdateLessonResponse response = UpdateLessonResponse.newBuilder()
                    .setLesson(lesson_updated)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logLessonActivity(200, "updateLesson", response.toString());
        } catch (Exception e) {
            responseObserver.onError(e);
            loggingService.logLessonActivity(400, "updateLesson", e.getMessage());
        }
    }

    @Override
    public void deleteLesson(DeleteLessonRequest request, StreamObserver<DeleteLessonResponse> responseObserver) {
        try {
            lessonRepository.deleteLesson(request.getId());

            DeleteLessonResponse response = DeleteLessonResponse.newBuilder()
                    .setStatus("true")
                    .setMessage("Delete lesson successfully")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logLessonActivity(200, "deleteLesson", response.toString());
        } catch (Exception e) {
            DeleteLessonResponse response = DeleteLessonResponse.newBuilder()
                    .setStatus("false")
                    .setMessage(e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logLessonActivity(400, "deleteLesson", response.toString());
        }
    }

}
