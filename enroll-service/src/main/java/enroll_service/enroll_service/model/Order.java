package enroll_service.enroll_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private BigDecimal totalAmount;
    private String shippingAddress;
    private String notes;
    private String status;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
