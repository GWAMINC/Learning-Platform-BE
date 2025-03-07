package enroll_service.enroll_service.controller;

import enroll_service.enroll_service.dto.OrderRequest;
import enroll_service.enroll_service.model.CoursePayment;
import enroll_service.enroll_service.repository.CoursePaymentRepository;
import enroll_service.enroll_service.service.OrderService;
import enroll_service.enroll_service.service.PaymentService;
import enroll_service.enroll_service.service.PaypalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class OrderController {
    private final CoursePaymentRepository coursePaymentRepository;
    private final PaypalClient paypalClient;
    private final OrderService orderService;
    private final PaymentService paymentService;

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        var order = orderService.createOrder(orderRequest);

        if (orderRequest.getPaymentMethodId() == 2) { // PayPal
            var checkoutLink = paymentService.processPaypalPayment(orderRequest, order.getId());
            System.out.println(checkoutLink);
            return ResponseEntity.ok(checkoutLink);
        } else { // Cash payment
            paymentService.processCashPayment(orderRequest, order.getId());
            return ResponseEntity.ok("Order created successfully!");
        }
    }

    @GetMapping("/success")
    public ResponseEntity<?> handlePaymentSuccess(
            @RequestParam("orderId") Long orderId,
            @RequestParam("token") String token,
            @RequestParam("PayerID") String payerId) {

        try {
            // 1️⃣ Xác nhận thanh toán với PayPal
            String captureUrl = "https://api-m.sandbox.paypal.com/v2/checkout/orders/" + token + "/capture";

            var accessToken = paypalClient.getPaypalAccessToken();

            var request = HttpRequest.newBuilder()
                    .uri(URI.create(captureUrl))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + accessToken)
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            var response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 201) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Thanh toán thất bại: " + response.body());
            }

            // 2️⃣ Cập nhật trạng thái đơn hàng
            var payment = coursePaymentRepository.findByOrderId(orderId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng"));

            payment.setStatus("COMPLETED");
            payment.setPaypalStatus("APPROVED");
            coursePaymentRepository.save(payment);

            URI redirectUri = URI.create("http://localhost:5173/payment/success?orderId=" + orderId);
            return ResponseEntity.status(HttpStatus.FOUND).location(redirectUri).build();

//            return ResponseEntity.ok("Thanh toán thành công! Đơn hàng: " + payment.getOrderId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi xử lý thanh toán: " + e.getMessage());
        }
    }
    @GetMapping("/cancel")
    public ResponseEntity<?> handlePaymentCancel(@RequestParam("orderId") Long orderId) {
        try {
            CoursePayment payment = coursePaymentRepository.findByOrderId(orderId)
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng"));

            payment.setStatus("CANCELED");
            payment.setPaypalStatus("CANCELED");
            coursePaymentRepository.save(payment);

            URI redirectUri = URI.create("http://localhost:5173/payment/cancel?orderId=" + orderId);
            return ResponseEntity.status(HttpStatus.FOUND).location(redirectUri).build();

//            return ResponseEntity.ok("Đơn hàng đã bị hủy.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi hủy thanh toán: " + e.getMessage());
        }
    }
}
