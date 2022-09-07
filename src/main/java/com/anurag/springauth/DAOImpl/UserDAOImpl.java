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
        String sql = "INSERT INTO User(username, password) VALUES (?, ?)";
        int create = jdbcTemplate.update(sql, user.getUsername(), user.getPassword());
        return create;
    }

    @Override
    public int delete(String username) {
        String sql = "DELETE FROM User WHERE username = ?";
        int delete = jdbcTemplate.update(sql, username);
        return delete;
    }

    @Override
    public User read(String username) {
        String sql = "SELECT * FROM User WHERE username = ?";
        BeanPropertyRowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, username);
        return user;
    }
    
}
