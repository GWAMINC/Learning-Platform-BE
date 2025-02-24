package course_service.course_service.service;

import com.example.gatewaycoursecategory.CourseCategoryServiceGrpc;
import com.example.gatewaycoursecategory.GateWayCourseCategoryRpcProto.*;
import course_service.course_service.repository.CourseCategoryRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class CourseCategoryService extends CourseCategoryServiceGrpc.CourseCategoryServiceImplBase
{
    private final CourseCategoryRepository courseCategoryRepository;

    public CourseCategoryService(CourseCategoryRepository courseCategoryRepository)
    {
        this.courseCategoryRepository = courseCategoryRepository;
    }

    @Override
    public void createCourseCategories(CreateCourseCategoriesRequest request, StreamObserver<CreateCourseCategoriesResponse> responseObserver)
    {
        try
        {
            for(int index : request.getCategoryIdList())
            {
                System.out.println("Course ID: " + request.getCourseId() + " Category ID: " + index);
                courseCategoryRepository.createCourseCategory(request.getCourseId(), index);
            }
            CreateCourseCategoriesResponse response = CreateCourseCategoriesResponse.newBuilder()
                    .setStatus("true")
                    .setMessage("Create course categories successfully")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
            String message = "Error while creating course category";
            if (e instanceof DuplicateKeyException)
            {
                message = "Course category name already exists";
            }
            CreateCourseCategoriesResponse response = CreateCourseCategoriesResponse.newBuilder()
                    .setStatus("false")
                    .setMessage(message)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getCategoriesByCourse (GetCategoriesByCourseRequest request, StreamObserver<GetCategoriesByCourseResponse> responseObserver)
    {
        try
        {
            var categories = courseCategoryRepository.findCourseCategoriesByCourse(request.getCourseId());
            GetCategoriesByCourseResponse.Builder response = GetCategoriesByCourseResponse.newBuilder();
            for (var category : categories)
            {
                response.addCourseCategories(CourseCategory.newBuilder()
                        .setId((int) category.get("id"))
                        .setCourseId((int) category.get("course_id"))
                        .setCategoryId((int) category.get("category_id"))
                        .build());
            }
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {;
            responseObserver.onError(e);
        }
    }

    @Override
    public void updateCourseCategory (UpdateCourseCategoryRequest request, StreamObserver<UpdateCourseCategoryResponse> responseObserver)
    {
        try
        {
            courseCategoryRepository.updateCourseCategory(request.getId(), request.getCourseId(), request.getCategoryId());
            var category = courseCategoryRepository.findCourseCategoryById(request.getId());
            if (category.isPresent())
            {
                UpdateCourseCategoryResponse response = UpdateCourseCategoryResponse.newBuilder()
                        .setCourseCategory(CourseCategory.newBuilder()
                                .setId((int) category.get().get("id"))
                                .setCourseId((int) category.get().get("course_id"))
                                .setCategoryId((int) category.get().get("category_id"))
                                .build())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
            else
            {
                UpdateCourseCategoryResponse response = UpdateCourseCategoryResponse.newBuilder()
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        }
        catch (Exception e)
        {
            responseObserver.onError(e);
        }
    }

    @Override
    public void deleteCourseCategory (DeleteCourseCategoryRequest request, StreamObserver<DeleteCourseCategoryResponse> responseObserver)
    {
        try
        {
            courseCategoryRepository.deleteCourseCategory(request.getId());
            DeleteCourseCategoryResponse response = DeleteCourseCategoryResponse.newBuilder()
                    .setStatus("true")
                    .setMessage("Delete course category successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
        catch (Exception e)
        {
            DeleteCourseCategoryResponse response = DeleteCourseCategoryResponse.newBuilder()
                    .setStatus("false")
                    .setMessage("Error while deleting course category")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
