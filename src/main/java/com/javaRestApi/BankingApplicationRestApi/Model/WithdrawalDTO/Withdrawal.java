package com.javaRestApi.BankingApplicationRestApi.Model.WithdrawalDTO;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "withdrawal_transactions")
@Entity
@Data
public class Withdrawal {
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
    private Double balanceAfterWithdrawal;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime transactionDateTime;

}
