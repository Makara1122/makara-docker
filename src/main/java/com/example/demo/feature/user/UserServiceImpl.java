package com.example.demo.feature.user;

import com.example.demo.domain.Role;
import com.example.demo.feature.user.dto.UserRequest;
import com.example.demo.feature.user.dto.UserResponse;
import com.example.demo.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toUserResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse register(UserRequest userRequest) {
        Set<Role> roles = new HashSet<>();
        userRequest.roles().stream().map(role ->{
            var r = new Role();
            r.setName(role);
            roles.add(r);
            return null;
        }).collect(Collectors.toSet());
        var user = userMapper.toUser(userRequest);
        user.setRoles(roles);
        return userMapper.toUserResponse(userRepository.save(user));
    }
}
