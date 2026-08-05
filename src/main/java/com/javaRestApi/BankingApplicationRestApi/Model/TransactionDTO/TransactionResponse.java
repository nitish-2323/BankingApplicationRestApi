package com.javaRestApi.BankingApplicationRestApi.Model.TransactionDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionResponse {

    private String accountNumber;

    private String transactionType;

    private double amount;

    private double balanceAfterTransaction;

    private String referenceAccount;

    private String description;

    private LocalDateTime transactionDate;
}