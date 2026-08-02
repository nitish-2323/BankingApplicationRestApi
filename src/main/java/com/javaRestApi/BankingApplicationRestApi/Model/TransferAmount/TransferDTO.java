package com.javaRestApi.BankingApplicationRestApi.Model.TransferAmount;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Table
@Entity
@Data
public class TransferDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mainID;
    @Column(unique = true,nullable = false)
    private String transactionId;
    private String fromAccountNumber;
    private String toAccountNumber;
    private Double amount;
    private Double senderBalance;
    private Double receiverBalance;
    private String status;
    private String message;
    private LocalDateTime transactionDateTime;
}
