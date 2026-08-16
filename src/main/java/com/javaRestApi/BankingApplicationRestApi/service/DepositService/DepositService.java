package com.javaRestApi.BankingApplicationRestApi.service.DepositService;

import com.javaRestApi.BankingApplicationRestApi.Execption.UserNotFound;
import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.Account;
import com.javaRestApi.BankingApplicationRestApi.Model.DepositDTO.Deposit;
import com.javaRestApi.BankingApplicationRestApi.Model.DepositDTO.DepositDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.TransactionDTO.Transaction;
import com.javaRestApi.BankingApplicationRestApi.Repository.AccountRepositry;
import com.javaRestApi.BankingApplicationRestApi.Repository.DepositRepositry;
import com.javaRestApi.BankingApplicationRestApi.Repository.TransactionalRepositry;
import com.javaRestApi.BankingApplicationRestApi.Repository.TransferRepositry;
import com.javaRestApi.BankingApplicationRestApi.service.Account.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class DepositService {
    @Autowired
    private AccountRepositry accountRepositry;
    @Autowired
    private AccountService service;
    @Autowired
    private DepositRepositry repositry;
    @Autowired
    private TransactionalRepositry transactionalRepositry;
    public Account deposit(String accountNumber, DepositDTO depositDTO) {
             Account obj =   accountRepositry.findByAccountNumber(accountNumber);
             if(obj == null){
                 throw new UserNotFound("Please check the Account Number,and Try Again");
             }
             double balance =depositDTO.getBalance();
             if(balance <=0){
                 throw new UserNotFound("Balance is unsufficent please check balance");
             }
            double totalBalance = obj.getBalance();
             totalBalance +=balance;
             obj.setBalance(totalBalance);
        Deposit deposit = new Deposit();

        deposit.setTransactionId(UUID.randomUUID().toString());
        deposit.setAccountNumber(obj.getAccountNumber());
        deposit.setAmount(depositDTO.getBalance());
        deposit.setBalanceAfterDeposit(totalBalance);
        deposit.setStatus("SUCCESS");
        deposit.setMessage("Amount deposited successfully.");
        deposit.setTransactionDateTime(LocalDateTime.now());

        Transaction transaction = new Transaction();

        transaction.setAccountNumber(obj.getAccountNumber());
        transaction.setTransactionType("DEPOSIT");
        transaction.setAmount(balance);
        transaction.setBalanceAfterTransaction(obj.getBalance());
        transaction.setReferenceAccount(null);
        transaction.setStatus("SUCCESS");
        transaction.setDescription("Cash Deposit");
        transaction.setTransactionDate(LocalDateTime.now());

        transactionalRepositry.save(transaction);
         repositry.save(deposit);
        accountRepositry.save(obj);
             return obj;
    }
}
