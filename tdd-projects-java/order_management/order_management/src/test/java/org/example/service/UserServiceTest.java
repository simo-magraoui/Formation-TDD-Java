package org.example.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.example.repository.UserRepository;
import org.example.model.User;

class UserServiceTest {
    @Test
    void testGetUser() {
        UserRepository mockRepository = mock(UserRepository.class);
        when(mockRepository.findUser("john")).thenReturn(new User("john", "John Doe"));

        UserService userService = new UserService(mockRepository);
        User user = userService.getUser("john");

        assertEquals("John Doe", user.getName());
    }
}