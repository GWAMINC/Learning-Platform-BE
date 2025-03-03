package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CouponRepository {
    private final JdbcTemplate jdbcTemplate;

    public CouponRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createCoupon(String code, double discount_percentage,String expiration_date ,int createdBy) {
        String sql = "INSERT INTO Coupons (code, discount_percentage, expiration_date, created_by) VALUES (?, ?, ? ,?)";
        return jdbcTemplate.update(sql, code, discount_percentage, expiration_date, createdBy) > 0;
    }

    public boolean updateCoupon(int id, String code, double discount_percentage,String expiration_date ,int createdBy) {
        String sql = "UPDATE Coupons SET code = ?, discount_percentage = ?, expiration_date = ?, created_by = ? WHERE id = ?";
        return jdbcTemplate.update(sql, code, discount_percentage, expiration_date, createdBy, id) > 0;
    }

    public boolean deleteCoupon(int id) {
        String sql = "DELETE FROM Coupons WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    public Optional<Map<String, Object>> findCouponById(int id) {
        String sql = "SELECT * FROM Coupons WHERE id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForMap(sql, id));
        } catch (Exception e) {
            return Optional.empty();
        }    }

    public Optional<Map<String, Object>> findCouponByCode(String code) {
        String sql = "SELECT * FROM Coupons WHERE code = ?";
        try {
            return Optional.of(jdbcTemplate.queryForMap(sql, code));
        } catch (Exception e) {
            return Optional.empty();
        }    }

    public List<Map<String, Object>> findAllCoupons() {
        String sql = "SELECT * FROM Coupons";
        return jdbcTemplate.queryForList(sql);
    }
}
