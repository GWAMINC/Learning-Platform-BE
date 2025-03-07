package enroll_service.enroll_service.repository;

import enroll_service.enroll_service.model.CoursePayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoursePaymentRepository extends JpaRepository<CoursePayment, Long> {
    Optional<CoursePayment> findByOrderId(Long orderId);
}
