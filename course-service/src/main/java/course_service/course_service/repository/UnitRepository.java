package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UnitRepository {
    private final JdbcTemplate jdbcTemplate;

    public UnitRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createUnit(String name, int course_id) {
        String sql = "INSERT INTO CourseUnits (name, course_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, name, course_id) > 0;
    }

    public boolean updateUnit(int id, String name, int course_id) {
        String sql = "UPDATE CourseUnits SET name = ? ,course_id = ? WHERE id = ?";
        return jdbcTemplate.update(sql, name, course_id, id) > 0;
    }

    public List<Map<String,Object>> findAllUnitCourses(int course_id) {
        String sql = "SELECT * FROM CourseUnits WHERE course_id = ?";
        return jdbcTemplate.queryForList(sql, course_id);
    }

    public boolean deleteUnit(int id) {
        String sql = "DELETE FROM CourseUnits WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}

