package com.javaRestApi.BankingApplicationRestApi.Model.MiniStatement;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MiniStatementDTO {
    private Long transactionId;

    private String accountNumber;

    private String transactionType;

    private double amount;

    private double balanceAfterTransaction;

    private String status;

    private LocalDateTime transactionDate;
}
