package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class PriceRepository {
    private final JdbcTemplate jdbcTemplate;

    public PriceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createPrice(int course_id, double price, double discount_price, String currency) {
        String sql = "INSERT INTO Price (course_id, price, discount_price, currency) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, course_id, price, discount_price, currency) > 0;
    }

    public boolean updatePrice(int course_id, double price, double discount_price, String currency) {
        String sql = "UPDATE Price SET price = ?, discount_price = ?, currency = ? WHERE course_id = ?";
        return jdbcTemplate.update(sql, price, discount_price, currency, course_id) > 0;
    }

    public Optional<Map<String,Object>> findPriceByCourseId (int course_id) {
        String sql = "SELECT * FROM Price WHERE course_id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForMap(sql, course_id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }


}
