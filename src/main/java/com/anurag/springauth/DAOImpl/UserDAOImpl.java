package com.anurag.springauth.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.anurag.springauth.DAO.UserDAO;
import com.anurag.springauth.model.User;

@Component("userDao")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(User user) {
        String sql = "INSERT INTO Users(username, password, enabled) VALUES (?, ?, ?)";
        int create = jdbcTemplate.update(sql, user.getUsername(), "{bcrypt}" + user.getPassword(), true);

        String sql2 = "INSERT INTO Authorities(username, authority) VALUES (?, ?)";
        jdbcTemplate.update(sql2, user.getUsername(), "ROLE_USER");

        return create;
    }

    @Override
    public int delete(String username) {
        String sql = "DELETE FROM Users WHERE username = ?";
        int delete = jdbcTemplate.update(sql, username);
        return delete;
    }

    @Override
    public User read(String username) {
        String sql = "SELECT * FROM Users WHERE username = ?";
        BeanPropertyRowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, username);
        return user;
    }
    
}
