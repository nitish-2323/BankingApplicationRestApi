package com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class CustomerDto {
    @Id
    private Long customerId;
    private String fullName;
    private String password;
    private String email;
    private String phoneNumber;
    private String address;
    @Column(unique = true)
    private String aadhaarNumber;
    @Column(unique = true)
    private String panNumber;
}
