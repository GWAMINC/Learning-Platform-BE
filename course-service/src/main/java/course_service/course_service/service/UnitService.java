package course_service.course_service.service;

import com.example.gatewayunit.GateWayUnitRpcProto.*;
import com.example.gatewayunit.UnitServiceGrpc;
import course_service.course_service.repository.LessonRepository;
import course_service.course_service.repository.UnitRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitService extends UnitServiceGrpc.UnitServiceImplBase {
    private final UnitRepository unitRepository;
    private final LessonRepository lessonRepository;

    @Autowired
    private LoggingService loggingService;

    public UnitService (UnitRepository unitRepository,LessonRepository lessonRepository) {
        this.unitRepository = unitRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void createUnit (CreateUnitRequest request, StreamObserver<CreateUnitResponse> responseObserver) {
        try {
            unitRepository.createUnit(request.getName(), request.getCourseId());

            CreateUnitResponse response = CreateUnitResponse.newBuilder()
                    .setStatus("true")
                    .setMessage("Create unit successfully")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logUnitActivity(200, "createUnit", response.toString());
        } catch (Exception e) {
            CreateUnitResponse response = CreateUnitResponse.newBuilder()
                    .setStatus("false")
                    .setMessage(e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logUnitActivity(400, "createUnit", response.toString());
        }
    }

    @Override
    public void updateUnit(UpdateUnitRequest request, StreamObserver<UpdateUnitResponse> responseObserver) {
        try {
            unitRepository.updateUnit(request.getId(), request.getName(), request.getCourseId());

            Unit unit_updated = Unit.newBuilder()
                    .setId(request.getId())
                    .setName(request.getName())
                    .setCourseId(request.getCourseId())
                    .build();

            UpdateUnitResponse response = UpdateUnitResponse.newBuilder()
                    .setUnit(unit_updated)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logUnitActivity(200, "updateUnit", response.toString());
        } catch (Exception e) {
            responseObserver.onError(e);
            loggingService.logUnitActivity(400, "updateUnit", e.getMessage());
        }
    }

    @Override
    public void getUnitsByCourse(GetUnitsByCourseRequest request, StreamObserver<GetUnitsByCourseResponse> responseObserver) {
        try {
            var units = unitRepository.findAllUnitCourses(request.getCourseId());
            GetUnitsByCourseResponse.Builder response = GetUnitsByCourseResponse.newBuilder();
            for (var unit : units) {
                Unit unit_response = Unit.newBuilder()
                        .setId((int) unit.get("id"))
                        .setName((String) unit.get("name"))
                        .setCourseId((int) unit.get("course_id"))
                        .build();
                response.addUnits(unit_response);
            }
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            loggingService.logUnitActivity(200, "getUnitsByCourse", response.toString());
        } catch (Exception e) {
            responseObserver.onError(e);
            loggingService.logUnitActivity(400, "getUnitsByCourse", e.getMessage());
        }
    }

    @Override
    public void deleteUnit(DeleteUnitRequest request, StreamObserver<DeleteUnitResponse> responseObserver) {
        try {
            unitRepository.deleteUnit(request.getId());
            lessonRepository.deleteLessonsByUnitId(request.getId());

            DeleteUnitResponse response = DeleteUnitResponse.newBuilder()
                    .setStatus("true")
                    .setMessage("Delete unit successfully")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logUnitActivity(200, "deleteUnit", response.toString());
        } catch (Exception e) {
            DeleteUnitResponse response = DeleteUnitResponse.newBuilder()
                    .setStatus("false")
                    .setMessage(e.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logUnitActivity(400, "deleteUnit", response.toString());
        }
    }
}
