package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CourseCategoryRepository
{
    private final JdbcTemplate jdbcTemplate;

    public CourseCategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createCourseCategory(int courseId, int categoryId) {
        String sql = "INSERT INTO CourseCategories(course_id, category_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, courseId, categoryId);
    }

    public Map<String, Object> getCourseCategoryById(int id) {
        String sql = "SELECT * FROM CourseCategories WHERE id = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }

    public List<Map<String, Object>> getCourseCategoriesByCourseId(int courseId) {
        String sql = "SELECT * FROM CourseCategories WHERE course_id = ?";
        return jdbcTemplate.queryForList(sql, courseId);
    }

    public int updateCourseCategory(int id, int courseId, int categoryId) {
        String sql = "UPDATE CourseCategories SET course_id = ?, category_id = ? WHERE id = ?";
        return jdbcTemplate.update(sql, courseId, categoryId, id);
    }

    public int deleteCourseCategory(int id) {
        String sql = "DELETE FROM CourseCategories WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
