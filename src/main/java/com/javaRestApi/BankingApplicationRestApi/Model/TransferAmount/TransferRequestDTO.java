package com.javaRestApi.BankingApplicationRestApi.Model.TransferAmount;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TransferRequestDTO {
    private String fromAccountNumber;
    private String toAccountNumber;
    private Double amount;

}
