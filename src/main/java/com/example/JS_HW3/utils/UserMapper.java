package com.example.JS_HW3.utils;

import com.example.JS_HW3.model.User;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Маппер сущности пользователя, для преобразования данных и БД в сущность
 */

@SuppressWarnings("ALL")
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.getFirstName();
        user.getLastName();
        return user;
    }
}
