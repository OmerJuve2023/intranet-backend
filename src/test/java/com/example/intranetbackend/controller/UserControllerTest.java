package com.example.intranetbackend.controller;

import com.example.intranetbackend.domain.User;
import com.example.intranetbackend.dto.UserRequest;
import com.example.intranetbackend.dto.UserResponse;
import com.example.intranetbackend.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetUser() throws Exception {
        // Arrange
        UserResponse userResponse = new UserResponse("tester", "password", null);
        when(userService.getUsers()).thenReturn(Collections.singletonList(userResponse));

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/api/user/findAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].username").value("tester"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].password").value("password"));
    }

    @Test
    void testSetUser() throws Exception {
        // Arrange
        UserRequest userRequest = new UserRequest("tester", "password");

        // Mocking the service method call
        when(userService.setUser(any(UserRequest.class))).thenReturn(new User());

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/api/user/add")
                        .content(asJsonString(userRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

