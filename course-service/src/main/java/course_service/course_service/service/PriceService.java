package course_service.course_service.service;

import com.example.gatewayprice.PriceServiceGrpc;
import course_service.course_service.repository.PriceRepository;
import com.example.gatewayprice.GateWayPriceRpcProto.*;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PriceService extends PriceServiceGrpc.PriceServiceImplBase {
    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void createPrice(CreatePriceRequest request, StreamObserver<CreatePriceResponse> responseObserver) {
        try {
            priceRepository.createPrice(request.getCourseId(), request.getPrice(), request.getDiscountPrice(), request.getCurrency());
            CreatePriceResponse response = CreatePriceResponse.newBuilder()
                    .setStatus("true")
                    .setMessage( "Create price successfully")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void getPriceByCourse (GetPriceByCourseRequest request, StreamObserver<GetPriceByCourseResponse> responseObserver) {
        try {
            int courseId = request.getCourseId();
            var price = priceRepository.findPriceByCourseId(courseId);
            if (price.isPresent()) {
                Price price_response = Price.newBuilder()
                        .setCourseId((int) price.get().get("course_id"))
                        .setPrice(((BigDecimal) price.get().get("price")).doubleValue())
                        .setDiscountPrice(((BigDecimal) price.get().get("discount_price")).doubleValue())
                        .setCurrency((String) price.get().get("currency"))
                        .build();
                GetPriceByCourseResponse response = GetPriceByCourseResponse.newBuilder()
                        .setPrice(price_response)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                GetPriceByCourseResponse response = GetPriceByCourseResponse.newBuilder()
                        .setPrice(Price.newBuilder().build())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        } catch (Exception e) {
            responseObserver.onError(e);
            System.err.println(e.getMessage());
        }
    }
}
