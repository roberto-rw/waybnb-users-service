package com.waybnb.users.dto;

public record UserDTO(
        String username,
        String email,
        String firstName,
        String lastName,
        String password
) {
}
