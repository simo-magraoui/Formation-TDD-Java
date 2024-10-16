package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.services.UserService;
import com.example.User;

class UserServiceTest {
    @Test
    void testCreateUser() {
        UserService userService = new UserService();
        User user = userService.createUser("john_doe");
        assertEquals("john_doe", user.getUsername());
    }
}