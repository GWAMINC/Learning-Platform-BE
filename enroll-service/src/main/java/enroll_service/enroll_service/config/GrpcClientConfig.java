package enroll_service.enroll_service.config;

import com.example.gatewaycoupon.CouponServiceGrpc;
import com.example.payment.PaymentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Bean
    public ManagedChannel courseChannel() {
        return ManagedChannelBuilder.forAddress("course-service", 50051)
                .usePlaintext()
                .build();
//        return ManagedChannelBuilder.forAddress("localhost", 50051)
//                .usePlaintext()
//                .build();
    }

    @Bean
    public ManagedChannel userChannel() {
        return ManagedChannelBuilder.forAddress("user-service", 50050)
                .usePlaintext()
                .build();
//        return ManagedChannelBuilder.forAddress("localhost", 50050)
//                .usePlaintext()
//                .build();
    }

    @Bean
    public CouponServiceGrpc.CouponServiceBlockingStub couponStub(ManagedChannel courseChannel) {
        return CouponServiceGrpc.newBlockingStub(courseChannel);
    }

    @Bean
    public PaymentServiceGrpc.PaymentServiceBlockingStub paymentStub(ManagedChannel userChannel) {
        return PaymentServiceGrpc.newBlockingStub(userChannel);
    }
}
