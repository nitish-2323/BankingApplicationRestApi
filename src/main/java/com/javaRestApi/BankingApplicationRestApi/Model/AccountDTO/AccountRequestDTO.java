package com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO;

import lombok.Data;

@Data
public class AccountRequestDTO {

    private Long customerId;

    private String accountType;

    private Double openingBalance;
}