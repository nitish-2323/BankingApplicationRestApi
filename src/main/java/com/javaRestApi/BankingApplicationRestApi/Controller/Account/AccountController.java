package com.javaRestApi.BankingApplicationRestApi.Controller.Account;

import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.Account;
import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.AccountResponseDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO.CustomerDto;
import com.javaRestApi.BankingApplicationRestApi.service.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class AccountController {
    @Autowired
    private AccountService service;
    @Autowired
    private AccountResponseDTO accountResponseDTO;

    @PostMapping("/createAccount")
    public ResponseEntity<AccountResponseDTO> createAccount(@RequestBody Account account) {
        Account serviceAccount = service.createAccount(account);
        accountResponseDTO.setError(false);
        accountResponseDTO.setMsg("Account created sucessfully ");
        accountResponseDTO.setStatusCode(201);
        List<Account> list = new ArrayList<>();
        list.add(serviceAccount);
        accountResponseDTO.setMydtos(list);
        return new ResponseEntity<>(accountResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/info/{accountNumber}")
    public ResponseEntity<AccountResponseDTO> infoDetails(@PathVariable String accountNumber) {
        Account account = service.getInfo(accountNumber);
        accountResponseDTO.setStatusCode(200);
        accountResponseDTO.setError(false);
        accountResponseDTO.setMsg("Account is found sucessfully ");
        List<Account> list = new ArrayList<>();
        list.add(account);
        accountResponseDTO.setMydtos(list);
        return new ResponseEntity<>(accountResponseDTO, HttpStatus.OK);
    }

       @DeleteMapping("/deleteAccount/{accountNumber}")
    public ResponseEntity<AccountResponseDTO> deleteAccount(@PathVariable String accountNumber ){
        Account account = service.deleteAccount(accountNumber);
           accountResponseDTO.setStatusCode(200);
           accountResponseDTO.setError(false);
           accountResponseDTO.setMsg("Account is deleted sucessfully ");
           List<Account> list = new ArrayList<>();
           list.add(account);
           accountResponseDTO.setMydtos(list);
           return new ResponseEntity<>(accountResponseDTO, HttpStatus.OK);
       }
      @PutMapping("/updateAccount/{accountNumber}")
    public ResponseEntity<AccountResponseDTO> updateAccount(@PathVariable String accountNumber,@RequestBody Account obj){
        Account account =service.updateAccount(accountNumber,obj);
          accountResponseDTO.setStatusCode(200);
          accountResponseDTO.setError(false);
          accountResponseDTO.setMsg("Account is updated sucessfully ");
          List<Account> list = new ArrayList<>();
          list.add(account);
          accountResponseDTO.setMydtos(list);
          return new ResponseEntity<>(accountResponseDTO, HttpStatus.OK);
      }
    }

