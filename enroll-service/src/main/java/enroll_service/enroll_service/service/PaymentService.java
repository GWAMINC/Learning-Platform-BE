package enroll_service.enroll_service.service;

import enroll_service.enroll_service.dto.OrderRequest;
import enroll_service.enroll_service.dto.PaypalRequest;
import enroll_service.enroll_service.dto.PaypalResponse;
import enroll_service.enroll_service.model.CoursePayment;
import enroll_service.enroll_service.repository.CoursePaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final CoursePaymentRepository coursePaymentRepository;
    private final PaypalClient paypalClient;

    public void processCashPayment(OrderRequest orderRequest, Integer orderId) {
        CoursePayment payment = new CoursePayment();
        payment.setOrderId(orderId);
        payment.setCourseId(orderRequest.getCourseId());
        payment.setUserId(orderRequest.getUserId());
        payment.setPaymentMethodId(orderRequest.getPaymentMethodId());
        payment.setAmount(orderRequest.getAmount());
        payment.setTotalAmount(orderRequest.getTotalAmount());
        payment.setStatus("UNPAID");

        coursePaymentRepository.save(payment);
    }

    public String processPaypalPayment(OrderRequest orderRequest, Integer orderId) {
        try {
            var paypalRequest = new PaypalRequest(
                    "CAPTURE",
                    List.of(new PaypalRequest.PurchaseUnit(
                            new PaypalRequest.PurchaseUnit.Money("USD", orderRequest.getTotalAmount().toString())
                    )),
                    new PaypalRequest.PayPalAppContext()
                            .setBrandName("Learning Platform")
                            .setReturnUrl("http://localhost:8080/api/payment/success?orderId=" + orderId)
                            .setCancelUrl("http://localhost:8080/api/payment/cancel?orderId=" + orderId)
            );

            PaypalResponse paypalResponse = paypalClient.createPaypalTransaction(paypalRequest);

            CoursePayment payment = new CoursePayment();
            payment.setOrderId(orderId);
            payment.setCourseId(orderRequest.getCourseId());
            payment.setUserId(orderRequest.getUserId());
            payment.setPaymentMethodId(orderRequest.getPaymentMethodId());
            payment.setAmount(orderRequest.getAmount());
            payment.setTotalAmount(orderRequest.getTotalAmount());
            payment.setStatus("PENDING");
            payment.setPaypalOrderId(paypalResponse.getId());
            payment.setPaypalStatus(paypalResponse.getStatus());

            paypalResponse.getLinks().stream()
                    .filter(link -> "approve".equals(link.getRel()))
                    .findFirst()
                    .ifPresent(link -> payment.setPaypalCheckoutLink(link.getHref()));

            coursePaymentRepository.save(payment);
            return payment.getPaypalCheckoutLink();

        } catch (Exception e) {
            throw new RuntimeException("Failed to create PayPal transaction: " + e.getMessage());
        }
    }
}
