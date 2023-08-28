package com.example.SpringDemo.controller;

import com.example.SpringDemo.model.User;
import com.example.SpringDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users/me")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
    @PostMapping("/users")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

}
