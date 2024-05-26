package com.example.demo.mapper;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.feature.user.dto.UserRequest;
import com.example.demo.feature.user.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toUser(UserRequest userRequest);

    default Set<String> toRoles(Set<Role> roles){
        return roles.stream().map(Role::getName).collect(Collectors.toSet());
    }

    @Mapping(target = "roles",expression = "java(toRoles(user.getRoles()))")
    UserResponse toUserResponse(User user);
}
