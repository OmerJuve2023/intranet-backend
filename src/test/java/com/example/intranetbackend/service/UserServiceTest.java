package com.example.intranetbackend.service;

import com.example.intranetbackend.domain.User;
import com.example.intranetbackend.dto.UserRequest;
import com.example.intranetbackend.dto.UserResponse;
import com.example.intranetbackend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void testSetUser() {
        // Arrange
        UserRequest userRequest = new UserRequest("tester", "password");
        // Mocking the repository save method
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(new User());
        // Act
        User savedUser = userService.setUser(userRequest);
        // Assert
        assertNotNull(savedUser);

    }


    @Test
    void testGetUsers() {
        // Arrange
        UserResponse userResponse = new UserResponse("tester", "password", null);
        List<UserResponse> userResponses = Arrays.asList(userResponse);
        // Mocking the repository method call
        Mockito.when(userRepository.findUsernameAndPasswordAndFecha()).thenReturn(userResponses);

        // Act
        List<UserResponse> result = userService.getUsers();

        // Assert
        assertEquals(1, result.size());
        assertEquals("tester", result.get(0).getUsername());
        assertEquals("password", result.get(0).getPassword());
    }
}
