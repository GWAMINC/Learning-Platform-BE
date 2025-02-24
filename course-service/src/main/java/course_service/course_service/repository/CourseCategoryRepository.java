package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CourseCategoryRepository
{
    private final JdbcTemplate jdbcTemplate;

    public CourseCategoryRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createCourseCategory(int courseId, int categoryId)
    {
        String sql = "INSERT INTO CourseCategories (course_id, category_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, courseId, categoryId) > 0;
    }

    public List<Map<String, Object>> findCourseCategoriesByCourse(int courseId) {
        String sql = "SELECT * FROM CourseCategories WHERE course_id = ?";
        return jdbcTemplate.queryForList(sql, courseId);
    }

    public List<Map<String, Object>> findCourseCategoriesByCategory(int categoryId) {
        String sql = "SELECT * FROM CourseCategories WHERE category_id = ?";
        return jdbcTemplate.queryForList(sql, categoryId);
    }

    public Optional<Map<String, Object>> findCourseCategoryById(int id) {
        String sql = "SELECT * FROM CourseCategories WHERE id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForMap(sql, id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Map<String, Object>> updateCourseCategory(int id, int courseId, int categoryId) {
        String sql = "UPDATE CourseCategories SET course_id = ?, category_id = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, courseId, categoryId, id);
            return findCourseCategoryById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public boolean deleteCourseCategory(int id) {
        String sql = "DELETE FROM CourseCategories WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
