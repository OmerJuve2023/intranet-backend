package com.example.intranetbackend.controller;

import com.example.intranetbackend.dto.UserResponse;
import com.example.intranetbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin(origins = "*",
        maxAge = 3600)
@Controller
@RequestMapping(name = "/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/get")
    public List<UserResponse> getUser() {
        return userService.getUsers();
    }
}
