package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CourseTeacherRepository {

    private final JdbcTemplate jdbcTemplate;

    public CourseTeacherRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Map<String, Object>> viewTeacherCourse(int id_teacher) {
        String sql = "SELECT Courses.* from Courses Inner join CourseTeacher on Courses.id = CourseTeacher.course_id where CourseTeacher.teacher_id = ?";
        return jdbcTemplate.queryForList(sql, id_teacher);
    }
}