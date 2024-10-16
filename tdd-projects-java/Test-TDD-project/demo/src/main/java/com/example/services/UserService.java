package com.example.services;

import com.example.User;

public class UserService {
    public User createUser(String username) {
        return new User(username);
    }
}