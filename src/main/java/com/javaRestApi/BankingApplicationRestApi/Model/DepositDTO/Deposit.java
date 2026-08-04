package com.javaRestApi.BankingApplicationRestApi.Model.DepositDTO;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table
@Entity
@Data
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mainID;

    @Column(unique = true, nullable = false)
    private String transactionId;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Double balanceAfterDeposit;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime transactionDateTime;
}
