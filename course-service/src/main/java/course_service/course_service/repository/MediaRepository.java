package course_service.course_service.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class MediaRepository {
    private final JdbcTemplate jdbcTemplate;

    public MediaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean createMedia(String file_name, String type, String path, String public_id) {
        String sql = "INSERT INTO Media (filename, type, path, public_id) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,file_name,type,path,public_id) > 0;
    }

    public Optional<Map<String,Object>> findMedia(String public_id) {
        String sql = "SELECT * FROM Media WHERE public_id = ?";
        try {
            return Optional.of(jdbcTemplate.queryForMap(sql, public_id));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
