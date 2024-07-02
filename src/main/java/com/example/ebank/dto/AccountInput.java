package com.example.ebank.dto;

import com.example.ebank.enums.AccountStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountInput {
    private String rib;
    private Long clientId;
    private BigDecimal balance;
    private AccountStatus status;
}