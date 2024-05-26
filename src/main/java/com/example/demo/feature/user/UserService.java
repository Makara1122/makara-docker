package com.example.demo.feature.user;

import com.example.demo.feature.user.dto.UserRequest;
import com.example.demo.feature.user.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();
    UserResponse register(UserRequest userRequest);
}
