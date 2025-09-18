package com.user.user_app.services;


import com.user.user_app.models.User;
import com.user.user_app.repositaries.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    
    @Autowired
    UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User addUser(User user) {
    return repository.save(user);
}

}