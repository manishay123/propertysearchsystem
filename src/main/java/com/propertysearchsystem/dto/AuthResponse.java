package com.propertysearchsystem.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String username;
    private String jwtAuthToken;

    private long serverCurrentTime;

    private long tokenExpirationTime;
}
