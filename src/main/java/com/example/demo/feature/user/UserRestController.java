package com.example.demo.feature.user;

import com.example.demo.feature.user.dto.UserRequest;
import com.example.demo.feature.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRestController {

    private final UserService userService;

    @GetMapping("")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("")
    public UserResponse register(UserRequest userRequest){
        return userService.register(userRequest);
    }
}
