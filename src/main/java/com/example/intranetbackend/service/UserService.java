package com.example.intranetbackend.service;

import com.example.intranetbackend.domain.User;
import com.example.intranetbackend.dto.UserRequest;
import com.example.intranetbackend.dto.UserResponse;
import com.example.intranetbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*@Service*/
public class UserService {

   /* private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
*/
    /* @Transactional(rollbackFor = {
             Exception.class,
             RuntimeException.class})*/
  /*  public User setUser(UserRequest userRequest) {
        final User user = new User(0L, userRequest.getUsername(), userRequest.getPassword(), LocalDate.now());
        return userRepository.save(user);
    }

    @Transactional(rollbackFor = {
            Exception.class,
            RuntimeException.class},
            readOnly = true)
    public List<UserResponse> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = new UserResponse(user.getUsername(), user.getPassword(), user.getFecha());
            userResponses.add(userResponse);
        }
        return userResponses;
    }*/
}
