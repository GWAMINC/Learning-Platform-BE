package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class LessonRepository {
    private final JdbcTemplate jdbcTemplate;

    public LessonRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    public boolean createLesson(String name, String content, int unitId, int orderNumber) {
//        String sql = "INSERT INTO Lessons (name, content, course_unit_id, order_number) VALUES (?, ?, ?, ?)";
//        return jdbcTemplate.update(sql, name, content, unitId, orderNumber) > 0;
//    }
public int createLesson(String name, String content, int unitId, int orderNumber) {
    String sql = "INSERT INTO Lessons (name, content, course_unit_id, order_number) VALUES (?, ?, ?, ?)";

    KeyHolder keyHolder = new GeneratedKeyHolder();

    jdbcTemplate.update(connection -> {
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, name);
        ps.setString(2, content);
        ps.setInt(3, unitId);
        ps.setInt(4, orderNumber);
        return ps;
    }, keyHolder);

    // Lấy ID vừa chèn vào (nếu có)
    return keyHolder.getKey() != null ? keyHolder.getKey().intValue() : -1;
}


    public Optional<Map<String, Object>> findLessonById(int id) {
        String sql = "SELECT * FROM Lessons WHERE id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForMap(sql, id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Map<String, Object>> findLessonsByUnitId(int unitId) {
        String sql = "SELECT * FROM Lessons WHERE course_unit_id = ? ORDER BY order_number";
        return jdbcTemplate.queryForList(sql, unitId);
    }

    public boolean updateLesson(int id, String name, String content, int unitId, int orderNumber) {
        String sql = "UPDATE Lessons SET name = ?, content = ?, course_unit_id = ?, order_number = ? WHERE id = ?";
        return jdbcTemplate.update(sql, name, content, unitId,orderNumber, id) > 0;
    }

    public boolean deleteLesson(int id) {
        String sql = "DELETE FROM Lessons WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    public boolean deleteLessonsByUnitId(int unitId) {
        String sql = "DELETE FROM Lessons WHERE course_unit_id = ?";
        return jdbcTemplate.update(sql, unitId) > 0;
    }

    public int getLessonOrderNumber(int unitId) {
        String sql = "SELECT COALESCE(MAX(order_number),0) + 1 FROM Lessons WHERE course_unit_id = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, unitId);
    }
}
