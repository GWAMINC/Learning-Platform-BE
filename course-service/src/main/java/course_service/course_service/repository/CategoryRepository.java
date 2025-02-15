package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    public CategoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createCategory(String name, String description) {
        String sql = "INSERT INTO Categories (name, description) VALUES (?, ?)";
        return jdbcTemplate.update(sql, name, description) > 0;
    }

    public Optional<Map<String, Object>> findCategoryById(int id) {
        String sql = "SELECT * FROM Categories WHERE id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForMap(sql, id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Map<String, Object>> findAllCategories() {
        String sql = "SELECT * FROM Categories";
        return jdbcTemplate.queryForList(sql);
    }

    public Optional<Map<String, Object>> updateCategory(int id, String name, String description) {
        String sql = "UPDATE Categories SET name = ?, description = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, name, description, id);
            return findCategoryById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public boolean deleteCategory(int id) {
        String sql = "DELETE FROM Categories WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
