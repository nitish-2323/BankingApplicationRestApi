package com.javaRestApi.BankingApplicationRestApi.Model.TransferAmount;

import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO.CustomerDto;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class TransferResponseDTO {
    private String fromAccountNumber;
    private String toAccountNumber;
    private Double amount;
    private int statusCode;
    private boolean error;
    private String msg;

}
