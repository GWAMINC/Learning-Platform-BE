package course_service.course_service.service;

import com.example.gatewayreview.ReviewServiceGrpc;
import com.example.gatewayreview.GateWayReviewRpcProto.*;
import course_service.course_service.repository.ReviewRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends ReviewServiceGrpc.ReviewServiceImplBase {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void getReviewByCourse(GetReviewByCourseRequest request, StreamObserver<GetReviewByCourseResponse> responseObserver) {
        try {
            int courseId = request.getCourseId();
            var reviews = reviewRepository.findReviewByCourseId(courseId);
            GetReviewByCourseResponse.Builder responseBuilder = GetReviewByCourseResponse.newBuilder();
            for (var review : reviews) {
                Review review_response = Review.newBuilder()
                        .setCourseId((int) review.get("course_id"))
                        .setUserId((int) review.get("user_id"))
                        .setRating((int) review.get("rating"))
                        .setComment((String) review.get("comment"))
                        .build();
                responseBuilder.addReviews(review_response);
            }
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
            System.err.println(e.getMessage());
        }
    }

}
