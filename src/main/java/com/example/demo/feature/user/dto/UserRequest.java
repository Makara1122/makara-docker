package com.example.demo.feature.user.dto;

import lombok.Builder;

import java.util.Set;
@Builder
public record UserRequest(
        String username,
        String password,
        String email,
        Set<String> roles
) {
}
