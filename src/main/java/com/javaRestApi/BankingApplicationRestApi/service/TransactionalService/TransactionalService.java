package com.javaRestApi.BankingApplicationRestApi.service.TransactionalService;

import com.javaRestApi.BankingApplicationRestApi.Execption.UserNotFound;
import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.Account;
import com.javaRestApi.BankingApplicationRestApi.Model.TransactionDTO.Transaction;
import com.javaRestApi.BankingApplicationRestApi.Model.TransactionDTO.TransactionResponse;
import com.javaRestApi.BankingApplicationRestApi.Repository.AccountRepositry;
import com.javaRestApi.BankingApplicationRestApi.Repository.TransactionalRepositry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TransactionalService {
    @Autowired
    private AccountRepositry account;
    @Autowired
    private TransactionalRepositry repositry;
    public List<TransactionResponse> getAllTransactions(String accountNumber) {
                Account obj = account.findByAccountNumber(accountNumber);
                if(obj == null){
                    throw new UserNotFound("Account Number is invalid Plz check it ");
                }
                List<Transaction> transactionalDTOList =repositry.findByAccountNumberOrderByTransactionDateDesc(accountNumber);
        List<TransactionResponse> responses = new ArrayList<>();

        for (Transaction transaction : transactionalDTOList) {

            TransactionResponse response = new TransactionResponse();

            response.setAccountNumber(transaction.getAccountNumber());
            response.setTransactionType(transaction.getTransactionType());
            response.setAmount(transaction.getAmount());
            response.setBalanceAfterTransaction(transaction.getBalanceAfterTransaction());
            response.setReferenceAccount(transaction.getReferenceAccount());
            response.setDescription(transaction.getDescription());
            response.setTransactionDate(transaction.getTransactionDate());

            responses.add(response);
        }

        return responses;
    }
}
