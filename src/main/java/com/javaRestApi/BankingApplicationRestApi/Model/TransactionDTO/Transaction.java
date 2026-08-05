package com.javaRestApi.BankingApplicationRestApi.Model.TransactionDTO;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String transactionType;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private double balanceAfterTransaction;

    private String referenceAccount;

    @Column(nullable = false)
    private String status;

    private String description;

    @Column(nullable = false)
    private LocalDateTime transactionDate;
}