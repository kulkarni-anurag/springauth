package com.anurag.springauth.DAO;

import com.anurag.springauth.model.User;

public interface UserDAO {
    int create(User user);
    int delete(String username);
    User read(String username);
}
