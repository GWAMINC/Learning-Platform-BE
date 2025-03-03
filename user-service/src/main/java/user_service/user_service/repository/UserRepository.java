package user_service.user_service.repository;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, Object> findUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try {
            return jdbcTemplate.queryForMap(sql, id);
        } catch (EmptyResultDataAccessException e) {
            return Collections.emptyMap(); // Trả về một Map rỗng nếu không có user
        }
    }
    public void updateUser(int id, String username, String email,String password, String role) {
        String sql = "UPDATE users SET username = ?, email = ?, password = ?, role = ? WHERE id = ?";
        jdbcTemplate.update(sql, username, email, password, role, id);
    }


    public List<Map<String, Object>> findAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.queryForList(sql);
    }
    public Optional<Map<String, Object>> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            return Optional.of(jdbcTemplate.queryForMap(sql, email));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
    public Optional<Map<String, Object>> findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            return Optional.of(jdbcTemplate.queryForMap(sql, username));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
    public void addUser(String username, String email, String password, String role) {
        String sql = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, username, email, password, role);
    }
    public void updatePassword(String email, String password) {
        String sql = "UPDATE users SET password = ? WHERE email = ?";
        jdbcTemplate.update(sql, password, email);
    }
    public Map<String, Object> getBio(int id) {
        String sql = "SELECT * FROM bio WHERE user_id = ?";
        return jdbcTemplate.queryForMap(sql, id);
    }
    public void addBio(int id, String firstName, String lastName, String address, String phone, String gender, String birthDate, String bio, String avatar) {
        String sql = "INSERT INTO bio (user_id, first_name, last_name, address, phone, gender, birth_date, bio, avatar) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, id, firstName, lastName, address, phone, gender, birthDate, bio, avatar);
    }
    public void updateBio(int id, String firstName, String lastName, String address, String phone, String gender, String birthDate, String bio, String avatar) {
        String sql = "UPDATE bio SET first_name = ?, last_name = ?, address = ?, phone = ?, gender = ?, birth_date = ?, bio = ?, avatar = ? WHERE user_id = ?";
        jdbcTemplate.update(sql, firstName, lastName, address, phone, gender, birthDate, bio, avatar, id);
    }
}
