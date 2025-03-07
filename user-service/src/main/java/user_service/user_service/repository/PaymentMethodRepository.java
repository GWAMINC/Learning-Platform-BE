package user_service.user_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PaymentMethodRepository {

    private final JdbcTemplate jdbcTemplate;

    public PaymentMethodRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findByUserId(int userId) {
        String sql = "SELECT * FROM PaymentMethods WHERE user_id = ?";
        return jdbcTemplate.queryForList(sql, userId);
    }
}
