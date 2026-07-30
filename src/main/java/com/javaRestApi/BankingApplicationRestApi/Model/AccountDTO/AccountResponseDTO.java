package com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO;

import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO.CustomerDto;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
 @Data
public class AccountResponseDTO {
    private int statusCode;
    private boolean error;
    private String msg;
    private List<Account> mydtos;
}
