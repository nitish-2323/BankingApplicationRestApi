package com.javaRestApi.BankingApplicationRestApi.service.MiniStatement;

import com.javaRestApi.BankingApplicationRestApi.Execption.UserNotFound;
import com.javaRestApi.BankingApplicationRestApi.Model.MiniStatement.MiniStatementDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.TransactionDTO.Transaction;
import com.javaRestApi.BankingApplicationRestApi.Repository.TransactionalRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MiniStatementService {
     @Autowired
     private TransactionalRepositry repositry;
    public List<MiniStatementDTO> getMiniStatement(String accountNumber) {
        List<Transaction> transactions =repositry.findByAccountNumberOrderByTransactionDateDesc(accountNumber);
        if(transactions.isEmpty()){
            throw new UserNotFound("Account number does not exsist .Plz chech Account Number ");
        }
        List<MiniStatementDTO> miniStatements = new ArrayList<>();

        for (Transaction transaction : transactions) {

            MiniStatementDTO dto = new MiniStatementDTO();

            dto.setTransactionId(transaction.getTransactionId());
            dto.setAccountNumber(transaction.getAccountNumber());
            dto.setTransactionType(transaction.getTransactionType());
            dto.setAmount(transaction.getAmount());
            dto.setBalanceAfterTransaction(transaction.getBalanceAfterTransaction());
            dto.setStatus(transaction.getStatus());
            dto.setTransactionDate(transaction.getTransactionDate());

            miniStatements.add(dto);
        }

        return miniStatements;
    }
}
