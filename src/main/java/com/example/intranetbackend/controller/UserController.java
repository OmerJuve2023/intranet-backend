package com.example.intranetbackend.controller;

import com.example.intranetbackend.dto.UserResponse;
import com.example.intranetbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",
        maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public List<UserResponse> getUser() {
        return userService.getUsers();
    }
}
