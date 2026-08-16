package com.javaRestApi.BankingApplicationRestApi.service.Account;

import com.javaRestApi.BankingApplicationRestApi.Execption.UserNotFound;
import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.Account;
import com.javaRestApi.BankingApplicationRestApi.Repository.AccountRepositry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepositry repositry;
    public Account createAccount(Account account) {
        String id = account.getAccountNumber();
        Account account1 = repositry.findByAccountNumber(id);
        if(account1 != null){
           throw new UserNotFound("Please check the Account No,It must be unique: ");
        }else {
            return repositry.save(account);
        }
    }

    public Account getInfo(String accountNumber) {
        Account account =repositry.findByAccountNumber(accountNumber);
        if(account == null){
            throw new UserNotFound("User not found check account number");
        }
        return account;
    }

    public Account deleteAccount(String accountNumber) {
        Account account =repositry.findByAccountNumber(accountNumber);
        if(account == null){
            throw new UserNotFound("User is not found to delete Check Account Number");
        }
         repositry.delete(account);
        return account;
    }

    public Account updateAccount(String accountNumber,Account accountObj) {
        Account account = repositry.findByAccountNumber(accountNumber);
        if(account == null){
            throw new UserNotFound("NO Account Number Found Plz try again");
        }

        account.setAccountType(accountObj.getAccountType());
        account.setBalance(accountObj.getBalance());
        account.setStatus(accountObj.getStatus());
        return repositry.save(account);

    }
}
