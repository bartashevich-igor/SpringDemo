package com.example.SpringDemo.service;

import com.example.SpringDemo.model.User;

public interface UserService {
    User create(User user);
    User getCurrentUser();
}
