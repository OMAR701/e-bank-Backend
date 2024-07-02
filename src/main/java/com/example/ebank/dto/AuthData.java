package com.example.ebank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

// dtos/AuthData.java
@Data
@AllArgsConstructor
public class AuthData {
    private final String jwt;
}
