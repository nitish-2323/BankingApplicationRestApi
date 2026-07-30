package com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO;

import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO.CustomerDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(unique = true)
    private String accountNumber;

    private String accountType;

    private Double balance;

    private String status;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private CustomerDto customer;
}
