package com.example.demo.feature.user.dto;

import lombok.Builder;

import java.util.Set;

@Builder
public record UserResponse(
        String id,
        String username,
        String email,
        Set<String> roles
) {
}
