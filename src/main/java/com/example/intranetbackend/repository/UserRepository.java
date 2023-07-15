package com.example.intranetbackend.repository;

import com.example.intranetbackend.domain.User;
import com.example.intranetbackend.dto.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   /* @Query("SELECT new com.example.intranetbackend.dto.UserResponse(u.username,u.password,u.fecha) from User u")
    List<UserResponse> findUsernameAndPasswordAndFecha();*/
}
