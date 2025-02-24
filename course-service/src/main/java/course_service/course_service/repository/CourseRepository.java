package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CourseRepository {

    private final JdbcTemplate jdbcTemplate;

    public CourseRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createCourse(String title, String description) {
        String sql = "INSERT INTO Courses (title, description) VALUES (?, ?)";
        return jdbcTemplate.update(sql, title, description) > 0;
    }

    public boolean updateCourse(int id, String title, String description) {
        String sql = "UPDATE Courses SET title = ?, description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, title, description, id) > 0;
    }

    public boolean deleteCourse(int id) {
        String sql = "DELETE FROM Courses WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    public Map<String, Object> findCourseById(int id) {
        String sql = "SELECT * FROM Courses WHERE id = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    public List<Map<String, Object>> findAllCourses(int limit, int offset) {
        String sql = "SELECT * FROM Courses LIMIT ? OFFSET ?";
        return jdbcTemplate.queryForList(sql, limit, offset);
    }

    public int countTotalCourses() {
        String sql = "SELECT COUNT(*) FROM Courses";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

}
