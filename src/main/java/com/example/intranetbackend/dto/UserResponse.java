package com.example.intranetbackend.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private String username;
    private String password;
    private LocalDate fecha;

    public UserResponse(String username, String password, LocalDate fecha) {
        this.username = username;
        this.password = password;
        this.fecha = fecha;
    }
}
