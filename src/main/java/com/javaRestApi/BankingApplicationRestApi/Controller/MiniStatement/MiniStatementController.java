package com.javaRestApi.BankingApplicationRestApi.Controller.MiniStatement;

import com.javaRestApi.BankingApplicationRestApi.Model.MiniStatement.MiniStatementDTO;
import com.javaRestApi.BankingApplicationRestApi.service.MiniStatement.MiniStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MiniStatementController {
    @Autowired
    private MiniStatementService service;
    @GetMapping("MiniStatement/{accountNumber}")
    public List<MiniStatementDTO> miniStatement(@PathVariable String accountNumber){
        List<MiniStatementDTO> obj = service.getMiniStatement(accountNumber);
        return obj;
    }
}
