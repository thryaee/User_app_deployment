package com.user.user_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.user.user_app.services.UserService;
import com.user.user_app.models.User;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {
    
    @Autowired
    UserService service;

    @GetMapping("/users")    
    public List<User> getAllUser(){
        return service.getAllUsers();
    } 

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return service.addUser(user);
    }
    
}