package enroll_service.enroll_service.controller;

import enroll_service.enroll_service.dto.OrderRequest;
import enroll_service.enroll_service.dto.PaypalRequest;
import enroll_service.enroll_service.dto.PaypalResponse;
import enroll_service.enroll_service.model.CoursePayment;
import enroll_service.enroll_service.model.Order;
import enroll_service.enroll_service.repository.CoursePaymentRepository;
import enroll_service.enroll_service.repository.OrderRepository;
import enroll_service.enroll_service.service.PaypalClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final CoursePaymentRepository coursePaymentRepository;
    private final PaypalClient paypalClient;

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest orderRequest) {
        try {
            // 1️⃣ Tạo đơn hàng trong DB
            Order order = new Order();
            order.setUserId(orderRequest.getUserId());
            order.setTotalAmount(orderRequest.getTotalAmount());
            order.setShippingAddress(orderRequest.getShippingAddress());
            order.setNotes(orderRequest.getNotes());
            order.setStatus("PENDING");

            order = orderRepository.save(order);

            // 2️⃣ Tạo yêu cầu PayPal
            PaypalRequest paypalRequest = new PaypalRequest(
                    "CAPTURE",
                    List.of(new PaypalRequest.PurchaseUnit(
                            new PaypalRequest.PurchaseUnit.Money("USD", order.getTotalAmount().toString())
                    )),
                    new PaypalRequest.PayPalAppContext()
                            .setBrandName("Learning Platform")
                            .setReturnUrl("http://localhost:8080/api/payment/success?orderId=" + order.getId())
                            .setCancelUrl("http://localhost:8080/api/payment/cancel?orderId=" + order.getId())
            );

            // 3️⃣ Gọi PayPal API để tạo đơn hàng
            PaypalResponse paypalResponse = paypalClient.createPaypalTransaction(paypalRequest);

            // 4️⃣ Lưu thông tin thanh toán vào CoursePayments
            CoursePayment payment = new CoursePayment();
            payment.setOrderId(order.getId());
            payment.setUserId(orderRequest.getUserId());
            payment.setCourseId(orderRequest.getCourseId());
            payment.setPaymentMethodId(orderRequest.getPaymentMethodId()); // Thêm phương thức thanh toán
            payment.setAmount(orderRequest.getAmount());                   // Giá gốc
            payment.setTotalAmount(orderRequest.getTotalAmount());         // Tổng tiền (đã giảm, thuế)
            payment.setStatus("PENDING");
            payment.setPaypalOrderId(paypalResponse.getId());
            payment.setPaypalStatus(paypalResponse.getStatus());

            // Lấy link thanh toán PayPal
            paypalResponse.getLinks().stream()
                    .filter(link -> "approve".equals(link.getRel()))
                    .findFirst()
                    .ifPresent(link -> payment.setPaypalCheckoutLink(link.getHref()));

            coursePaymentRepository.save(payment);

            return ResponseEntity.ok(payment.getPaypalCheckoutLink());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Lỗi khi tạo đơn hàng: " + e.getMessage());
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
