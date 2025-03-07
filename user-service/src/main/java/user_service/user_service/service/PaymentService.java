package user_service.user_service.service;

import com.example.payment.PaymentRpcProto.*;
import com.example.payment.PaymentServiceGrpc;
import user_service.user_service.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService extends PaymentServiceGrpc.PaymentServiceImplBase {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentService(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public void getPaymentMethods(GetPaymentMethodsRequest request, StreamObserver<GetPaymentMethodsResponse> responseObserver) {
        var methods = paymentMethodRepository.findByUserId(request.getUserId());

        List<PaymentMethod> paymentMethods = methods.stream()
                .map(method -> PaymentMethod.newBuilder()
                        .setId(((Number) method.get("id")).intValue())
                        .setUserId(((Number) method.get("user_id")).intValue())
                        .setType((String) method.get("type"))
                        .setProvider(method.get("provider") != null ? (String) method.get("provider") : "")
                        .setAccountNumber((String) method.get("account_number"))
                        .setExpirationDate(method.get("expiration_date") != null ? method.get("expiration_date").toString() : "")
                        .setCreatedAt(method.get("created_at").toString())
                        .build())
                .collect(Collectors.toList());

        GetPaymentMethodsResponse response = GetPaymentMethodsResponse.newBuilder()
                .addAllMethods(paymentMethods)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
