package com.javaRestApi.BankingApplicationRestApi.Controller.Transactional;

import com.javaRestApi.BankingApplicationRestApi.Model.TransactionDTO.TransactionResponse;

import com.javaRestApi.BankingApplicationRestApi.service.TransactionalService.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TransactionalController {
    @Autowired
    private TransactionalService service;
        @GetMapping("/TransactionalHistroy/{accountNumber}")
     public List<TransactionResponse> histroy(@PathVariable String accountNumber){
             List<TransactionResponse> obj =service.getAllTransactions(accountNumber);
             return obj;
        }
}
