package enroll_service.enroll_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class CoursePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer courseId;

    @Column(nullable = false)
    private Integer userId;

//    @Column(nullable = false)
//    private Integer orderId;

    @Column(nullable = false)
    private Integer paymentMethodId;   // Thêm phương thức thanh toán

    @Column(nullable = false)
    private BigDecimal amount;      // Giá gốc khóa học

    @Column(nullable = false)
    private BigDecimal totalAmount; // Tổng tiền sau giảm giá / thuế

    @Column(nullable = false)
    private String status = "pending"; // Trạng thái thanh toán

    @Column(updatable = false)
    private LocalDateTime paymentDate = LocalDateTime.now(); // Ngày thanh toán

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime updatedAt = LocalDateTime.now();

    // PayPal-specific fields
    private Integer orderId;
    private String paypalOrderId;
    private String paypalStatus;
    private String paypalCheckoutLink;
}
