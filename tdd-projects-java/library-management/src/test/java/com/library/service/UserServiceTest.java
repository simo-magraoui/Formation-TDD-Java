package com.library.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    public void testGetUser() {
        UserRepository mockRepository = mock(UserRepository.class);
        when(mockRepository.findUser("john")).thenReturn(new User("john", "John Doe"));

        UserService userService = new UserService(mockRepository);
        User user = userService.getUser("john");

        assertEquals("John Doe", user.getName());
    }
}
class User {
    private String username;
    private String name;

    public User(String username, String name) {
        this.username = username;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface UserRepository {
    User findUser(String username);
}
class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String username) {
        return userRepository.findUser(username);
    }
}


