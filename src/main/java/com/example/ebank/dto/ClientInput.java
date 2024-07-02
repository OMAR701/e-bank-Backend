package com.example.ebank.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientInput {
    private String firstName;
    private String lastName;
    private String identityNumber;
    private LocalDate birthDate;
    private String email;
    private String postalAddress;
    private Long userId;
}