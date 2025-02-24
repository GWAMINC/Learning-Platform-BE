package course_service.course_service.service;

import com.example.gatewaylesson.GateWayLessonRpcProto.*;
import com.example.gatewaylesson.LessonServiceGrpc;
import course_service.course_service.repository.LessonRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService extends LessonServiceGrpc.LessonServiceImplBase {
    private final LessonRepository lessonRepository;

    @Autowired
    private LoggingService loggingService;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void createLesson(CreateLessonRequest request, StreamObserver<CreateLessonResponse> responseObserver) {
        try {
            int orderNumber = lessonRepository.getLessonOrderNumber(request.getCourseUnitId());
            lessonRepository.createLesson(request.getName(), request.getContent(), request.getCourseUnitId(), orderNumber);

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
