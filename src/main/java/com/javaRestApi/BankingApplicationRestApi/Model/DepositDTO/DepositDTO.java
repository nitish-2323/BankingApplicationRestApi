package com.javaRestApi.BankingApplicationRestApi.Model.DepositDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
public class DepositDTO {
    private double balance;
}
