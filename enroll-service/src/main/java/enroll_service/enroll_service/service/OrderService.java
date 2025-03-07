package enroll_service.enroll_service.service;

import com.example.gatewaycoupon.GateWayCouponRpcProto.GetCouponByCodeRequest;
import com.example.payment.PaymentRpcProto.GetPaymentMethodsRequest;
import enroll_service.enroll_service.dto.OrderRequest;
import enroll_service.enroll_service.model.Order;
import enroll_service.enroll_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final com.example.gatewaycoupon.CouponServiceGrpc.CouponServiceBlockingStub couponStub;
    private final com.example.payment.PaymentServiceGrpc.PaymentServiceBlockingStub paymentStub;

    public Order createOrder(OrderRequest orderRequest) {
        var couponResponse = couponStub.getCouponByCode(
                GetCouponByCodeRequest.newBuilder().setCode(orderRequest.getCouponCode()).build()
        );

        var paymentMethods = paymentStub.getPaymentMethods(
                GetPaymentMethodsRequest.newBuilder().setUserId(orderRequest.getUserId()).build()
        );

        if (paymentMethods.getMethodsList().isEmpty()) {
            throw new RuntimeException("User không có phương thức thanh toán nào!");
        }

        BigDecimal discount = orderRequest.getAmount()
                .multiply(BigDecimal.valueOf(couponResponse.getCoupon().getDiscountPercentage() / 100));
        BigDecimal totalAmount = orderRequest.getAmount().subtract(discount);

        Order order = new Order();
        order.setUserId(orderRequest.getUserId());
        order.setTotalAmount(totalAmount);
        order.setShippingAddress(orderRequest.getShippingAddress());
        order.setNotes(orderRequest.getNotes());
        order.setStatus("PENDING");

        return orderRepository.save(order);
    }
}
