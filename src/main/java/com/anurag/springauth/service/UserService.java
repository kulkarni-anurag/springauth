package com.anurag.springauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.anurag.springauth.DAO.UserDAO;
import com.anurag.springauth.model.User;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void signup(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String newPassword = encoder.encode(user.getPassword());
        user.setPassword(newPassword);
        userDAO.create(user);
    }

    public void deleteAccount(String username){
        userDAO.delete(username);
    }
}
