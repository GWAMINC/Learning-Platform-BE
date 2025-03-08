package course_service.course_service.service;

import com.example.gatewaycategory.CategoryServiceGrpc;
import com.example.gatewaycategory.GateWayCategoryRpcProto.*;
import course_service.course_service.repository.CategoryRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryService extends CategoryServiceGrpc.CategoryServiceImplBase {
    private final CategoryRepository categoryRepository;

    @Autowired
    private LoggingService loggingService;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void createCategory(CreateCategoryRequest request, StreamObserver<CreateCategoryResponse> responseObserver) {
        try {
            categoryRepository.createCategory(request.getName(), request.getDescription());

            CreateCategoryResponse response = CreateCategoryResponse.newBuilder()
                    .setStatus("true")
                    .setMessage("Create category successfully")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logCategoryActivity(200, "createCategory", response.toString());
        } catch (Exception e) {
            String message = "Error while creating category";
            if (e instanceof DuplicateKeyException) {
                message = "Category name already exists";
            }
            CreateCategoryResponse response = CreateCategoryResponse.newBuilder()
                    .setStatus("false")
                    .setMessage(message)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logCategoryActivity(400, "createCategory", response.toString());
        }
    }

    @Override
    public void getCategory(GetCategoryRequest request, StreamObserver<GetCategoryResponse> responseObserver) {
        try {
            int id = request.getId();
            var category = categoryRepository.findCategoryById(id);
            if (category.isPresent()) {
                Category category_response = Category.newBuilder()
                        .setId((int) category.get().get("id"))
                        .setName((String) category.get().get("name"))
                        .setDescription((String) category.get().get("description"))
                        .build();
                GetCategoryResponse response = GetCategoryResponse.newBuilder()
                        .setCategory(category_response)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                loggingService.logCategoryActivity(200, "getCategory", response.toString());
            } else {
                GetCategoryResponse.Builder response = GetCategoryResponse.newBuilder();
                responseObserver.onNext(response.build());
                responseObserver.onCompleted();
            }
        } catch (Exception e) {
            responseObserver.onError(e);
            loggingService.logCategoryActivity(500, "getCategory", e.getMessage());
        }
    }

    @Override
    public void getAllCategories(GetAllCategoriesRequest request, StreamObserver<GetAllCategoriesResponse> responseObserver) {
        try {
            var categories = categoryRepository.findAllCategories();
            GetAllCategoriesResponse.Builder response = GetAllCategoriesResponse.newBuilder();
            for (var category : categories) {
                Category category_response = Category.newBuilder()
                        .setId((int) category.get("id"))
                        .setName((String) category.get("name"))
                        .setDescription((String) category.get("description"))
                        .build();
                response.addCategories(category_response);
            }
            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
            loggingService.logCategoryActivity(200, "getAllCategories", response.toString());
        } catch (Exception e) {
            responseObserver.onError(e);
            loggingService.logCategoryActivity(500, "getAllCategories", e.getMessage());
        }
    }

    @Override
    public void updateCategory(UpdateCategoryRequest request, StreamObserver<UpdateCategoryResponse> responseObserver) {
        try {
            int id = request.getId();
            String name = request.getName();
            String description = request.getDescription();
            var updated = categoryRepository.updateCategory(id, name, description);
            if (updated.isPresent()) {
                Category category_response = Category.newBuilder()
                        .setId((int) updated.get().get("id"))
                        .setName((String) updated.get().get("name"))
                        .setDescription((String) updated.get().get("description"))
                        .setUpdatedAt(LocalDateTime.now().toString())
                        .build();
                UpdateCategoryResponse response = UpdateCategoryResponse.newBuilder()
                        .setCategory(category_response)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                loggingService.logCategoryActivity(200, "updateCategory", response.toString());
            } else {
                responseObserver.onError(new Exception("Error while updating category"));
                loggingService.logCategoryActivity(500, "updateCategory", "Error while updating category");
            }
        } catch (Exception e) {
            responseObserver.onError(e);
            loggingService.logCategoryActivity(500, "updateCategory", e.getMessage());
        }
    }

    @Override
    public void deleteCategory(DeleteCategoryRequest request, StreamObserver<DeleteCategoryResponse> responseObserver) {
        try {
            int id = request.getId();
            categoryRepository.deleteCategory(id);
            DeleteCategoryResponse response = DeleteCategoryResponse.newBuilder()
                    .setStatus("true")
                    .setMessage("Delete category successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
            loggingService.logCategoryActivity(200, "deleteCategory", response.toString());
        } catch (Exception e) {
            responseObserver.onError(e);
            loggingService.logCategoryActivity(500, "deleteCategory", e.getMessage());
        }
    }
}
