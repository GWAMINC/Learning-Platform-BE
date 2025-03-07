package enroll_service.enroll_service.repository;

import enroll_service.enroll_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
