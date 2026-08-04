package com.javaRestApi.BankingApplicationRestApi.Controller.Deposit;

import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.Account;
import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.AccountResponseDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.DepositDTO.DepositDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.DepositDTO.ResponseDepositDTO;
import com.javaRestApi.BankingApplicationRestApi.service.DepositService.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepositController {
    @Autowired
    private DepositService service;
    @Autowired
    private ResponseDepositDTO responseDepositDTO;
    @PostMapping("/depositAmount/{accountNumber}")
    public ResponseEntity<ResponseDepositDTO>deposit(@PathVariable String accountNumber,
                                                     @RequestBody DepositDTO depositDTO){
        Account obj= service.deposit(accountNumber,depositDTO);
        responseDepositDTO.setError(false);
        responseDepositDTO.setMsg("Your balance is sucessfully deposit:"+obj.getBalance());
        responseDepositDTO.setStatusCode(201);
        List<Account> list = new ArrayList<>();
        list.add(obj);
        responseDepositDTO.setMydtos(list);
        return new ResponseEntity<>(responseDepositDTO, HttpStatus.CREATED);
    }
}
