package com.example.intranetbackend.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    private String username;
    private String password;
}
