package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CourseStudentRepository {

    private final JdbcTemplate jdbcTemplate;

    public CourseStudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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

    public List<Map<String, Object>> viewEnrollCourse(int userId) {
        String sql = "SELECT Courses.* From Courses Inner join CourseStudent on Courses.id = CourseStudent.course_id where student_id = ?";
        return jdbcTemplate.queryForList(sql, userId);
    }

    public boolean UnenrollCourse(int userId, int courseId) {
        String sql = "DELETE FROM CourseStudent WHERE student_id = ? AND course_id = ?";
        return jdbcTemplate.update(sql, userId, courseId) > 0;
    }
}
