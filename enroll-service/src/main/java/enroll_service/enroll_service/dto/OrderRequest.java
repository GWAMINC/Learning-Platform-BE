package enroll_service.enroll_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequest {
    private Long userId;
    private Long courseId;
    private Long paymentMethodId;     // Thêm paymentMethodId
    private BigDecimal amount;        // Giá gốc khóa học
    private BigDecimal totalAmount;   // Tổng tiền (đã giảm, thuế, phí)
    private String shippingAddress;
    private String notes;
}
