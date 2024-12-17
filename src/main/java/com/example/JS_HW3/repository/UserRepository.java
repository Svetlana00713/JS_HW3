package com.example.JS_HW3.repository;

import com.example.JS_HW3.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User findUserById(Integer id) {
        String sql = "SELECT * FROM userTable WHERE id=?";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        // Используем queryForObject для получения одного результата
        return jdbcTemplate.queryForObject(sql, userRowMapper, id);
    }

    //    Получение всех пользователей из БД
    public List<User> findAll(){
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbcTemplate.query(sql, userRowMapper);
    }

    //    добавление в БД
    public void save(User user) {
        String sql = "INSERT INTO userTable VALUES (NULL, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName());
    }

    //    удаление из БД
    public void deleteById (int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    /* Обновление пользователя в БД */
    public void update(User user){
        String sql = "UPDATE userTable SET firstName=?, lastName=? WHERE id=?";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }
}
