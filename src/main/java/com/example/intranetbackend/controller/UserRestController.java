package com.example.intranetbackend.controller;

import com.example.intranetbackend.dto.UserRequest;
import com.example.intranetbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",
        maxAge = 3600)
@RestController
@RequestMapping(name = "/intranet-unjfsc/add")
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> setUser(@RequestBody UserRequest userRequest) {
        userService.setUser(userRequest);
        return ResponseEntity.ok().build();
    }

}
