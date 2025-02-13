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

    // Kiểm tra xem người dùng đã đăng ký khóa học chưa
    public boolean isUserEnrolled(int userId, int courseId) {
        String sql = "SELECT COUNT(*) FROM CourseStudent WHERE student_id = ? AND course_id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, userId, courseId);
        return count != null && count > 0;
    }

    // Tiến hành lưu thông tin đăng ký vào DB
    public boolean enrollUser(int userId, int courseId) {
        String sql = "INSERT INTO CourseStudent (student_id, course_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, userId, courseId) > 0;
    }
}
