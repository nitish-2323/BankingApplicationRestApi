package com.javaRestApi.BankingApplicationRestApi.Controller.Withdrawal;

import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.Account;
import com.javaRestApi.BankingApplicationRestApi.Model.WithdrawalDTO.WithdrawalDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.WithdrawalDTO.WithdrawalResponseDTO;
import com.javaRestApi.BankingApplicationRestApi.service.WithdrawalService.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WithdrawalController {
    @Autowired
    private WithdrawalService service;
    @Autowired
    private WithdrawalResponseDTO withdrawal;
    @PostMapping("/withdrawal/{accountNumber}")
    public ResponseEntity<WithdrawalResponseDTO> withdraw(@PathVariable String accountNumber
            , @RequestParam double amount){
        Account obj =service.withdrawal(accountNumber,amount);
      withdrawal.setAccountNumber(obj.getAccountNumber());
      withdrawal.setMessage("Your are sucessfully withdrawal amount ");
      withdrawal.setWithdrawAmount(amount);
      withdrawal.setRemainingBalance(obj.getBalance());
      return new ResponseEntity<>(withdrawal,HttpStatus.OK);
    }
}
