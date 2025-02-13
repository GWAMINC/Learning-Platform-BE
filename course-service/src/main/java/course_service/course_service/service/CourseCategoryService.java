package course_service.course_service.service;

import com.example.gatewaycourse.CourseCategoryServiceGrpc;
import com.example.gatewaycourse.GateWayCourseRpcProto.*;
import course_service.course_service.repository.CourseCategoryRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CourseCategoryService extends CourseCategoryServiceGrpc.CourseCategoryServiceImplBase
{
    private final CourseCategoryRepository courseCategoryRepository;

    @Autowired
    public CourseCategoryService(CourseCategoryRepository courseCategoryRepository) {
        this.courseCategoryRepository = courseCategoryRepository;
    }

    @Override
    public void createCourseCategory(CreateCourseCategoryRequest request, StreamObserver<CreateCourseCategoryResponse> responseObserver) {
        try {
            int courseId = request.getCourseId();
            int categoryId = request.getCategoryId();
            int result = courseCategoryRepository.createCourseCategory(courseId, categoryId);
            CreateCourseCategoryResponse response = CreateCourseCategoryResponse.newBuilder().setSuccess(result > 0).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }

    @Override
    public void getCourseCategory(GetCourseCategoryRequest request, StreamObserver<GetCourseCategoryResponse> responseObserver) {
        try {
            Map<String, Object> result = courseCategoryRepository.getCourseCategoryById(request.getId());
            CourseCategory courseCategory = CourseCategory.newBuilder()
                    .setId((Integer) result.get("id"))
                    .setCourseId((Integer) result.get("course_id"))
                    .setCategoryId((Integer) result.get("category_id"))
                    .build();

            GetCourseCategoryResponse response = GetCourseCategoryResponse.newBuilder().setCourseCategory(courseCategory).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }

    @Override
    public void getCourseCategoryByCourseId(GetCourseCategoryByCourseIdRequest request, StreamObserver<GetCourseCategoryByCourseIdResponse> responseObserver) {
        try {
            int courseId = request.getCourseId();
            List<Map<String, Object>> results = courseCategoryRepository.getCourseCategoriesByCourseId(courseId);

            List<CourseCategory> courseCategories = results.stream().map(result -> CourseCategory.newBuilder()
                    .setId((Integer) result.get("id"))
                    .setCourseId((Integer) result.get("course_id"))
                    .setCategoryId((Integer) result.get("category_id"))
                    .build()).toList();

            GetCourseCategoryByCourseIdResponse response = GetCourseCategoryByCourseIdResponse.newBuilder().addAllCourseCategories(courseCategories).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }

    @Override
    public void updateCourseCategory(UpdateCourseCategoryRequest request, StreamObserver<UpdateCourseCategoryResponse> responseObserver) {
        try {
            int id = request.getId();
            int courseId = request.getCourseId();
            int categoryId = request.getCategoryId();

            courseCategoryRepository.updateCourseCategory(id, courseId, categoryId);
            CourseCategory courseCategory = CourseCategory.newBuilder()
                    .setId(id)
                    .setCourseId(courseId)
                    .setCategoryId(categoryId)
                    .build();

            UpdateCourseCategoryResponse response = UpdateCourseCategoryResponse.newBuilder().setCourseCategory(courseCategory).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }

    @Override
    public void deleteCourseCategory(DeleteCourseCategoryRequest request, StreamObserver<DeleteCourseCategoryResponse> responseObserver) {
        try {
            int id = request.getId();
            courseCategoryRepository.deleteCourseCategory(id);
            DeleteCourseCategoryResponse response = DeleteCourseCategoryResponse.newBuilder().setSuccess(true).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }
}
