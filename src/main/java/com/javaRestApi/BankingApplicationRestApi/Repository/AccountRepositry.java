package com.javaRestApi.BankingApplicationRestApi.Repository;

import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositry extends JpaRepository<Account,Long> {

    Account findByAccountNumber(String id);


    Account deleteByAccountNumber(String accountNumber);
}
