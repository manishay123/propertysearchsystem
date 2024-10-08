package com.propertysearchsystem.dto;


import com.propertysearchsystem.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private UserResponseDTO user;
    private String jwtAuthToken;

    private long serverCurrentTime;

    private long tokenExpirationTime;
}
