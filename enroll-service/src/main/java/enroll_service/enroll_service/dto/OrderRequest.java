package enroll_service.enroll_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {
    private Integer userId;
    private Integer courseId;
    private Integer paymentMethodId;     // Thêm paymentMethodId
    private Integer orderId;
    private BigDecimal amount;        // Giá gốc khóa học
    private BigDecimal totalAmount;   // Tổng tiền (đã giảm, thuế, phí)
    private String shippingAddress;
    private String notes;
    private String couponCode;
}
