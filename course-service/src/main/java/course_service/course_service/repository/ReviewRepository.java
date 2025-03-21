package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ReviewRepository
{
    private final JdbcTemplate jdbcTemplate;

    public ReviewRepository(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createReview(int course_id, int user_id, String comment, int rating)
    {
        String sql = "INSERT INTO Reviews (course_id, user_id, comment, rating) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, course_id, user_id, comment, rating) > 0;
    }

    public boolean updateReview(int course_id,int user_id, String comment, int rating)
    {
        String sql = "UPDATE Reviews SET comment = ?, rating = ? WHERE course_id = ? AND user_id = ?";
        return jdbcTemplate.update(sql, comment, rating, course_id, user_id) > 0;
    }

    public List<Map<String,Object>> findReviewByCourseId (int course_id)
    {
        String sql = "SELECT * FROM Reviews WHERE course_id = ?";
        try
        {
            return jdbcTemplate.queryForList(sql, course_id);
        }
        catch (Exception e)
        {
            return List.of();
        }
    }

}
