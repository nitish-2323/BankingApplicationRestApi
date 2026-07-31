package com.javaRestApi.BankingApplicationRestApi.service.WithdrawalService;

import com.javaRestApi.BankingApplicationRestApi.Execption.InsufficentAmount;
import com.javaRestApi.BankingApplicationRestApi.Execption.UserNotFound;
import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.Account;
import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.AccountResponseDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.WithdrawalDTO.WithdrawalDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.WithdrawalDTO.WithdrawalResponseDTO;
import com.javaRestApi.BankingApplicationRestApi.Repository.AccountRepositry;
import com.javaRestApi.BankingApplicationRestApi.service.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalService {
   @Autowired
    private AccountRepositry repositry;
    public Account withdrawal(String accountNumber, double amount) {
        Account account =repositry.findByAccountNumber(accountNumber);
          if(account == null){
              throw new UserNotFound("User is not found,Plz Check Account No");
          }
          if(amount<=0){
              throw new InsufficentAmount("Please Enter the valid Amount");
          }
          String status =account.getStatus();
        if (!"active".equalsIgnoreCase(account.getStatus())) {
            throw new UserNotFound("Your account is not Active, Plz check account");
        }

          double totalAmount =account.getBalance();
        if(amount >totalAmount){
            throw new InsufficentAmount("Your have unsufficent balance Plz check it");
        }
          if(totalAmount <=0){
              throw new InsufficentAmount("You dont have the sufficent amount to withdraw");
          }
          account.setBalance(totalAmount-amount);
          repositry.save(account);
          return account;
    }
}
