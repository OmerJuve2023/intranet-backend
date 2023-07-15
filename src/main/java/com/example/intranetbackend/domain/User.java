package com.example.intranetbackend.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private LocalDate fecha;
}
