package com.javaRestApi.BankingApplicationRestApi.Repository;

import com.javaRestApi.BankingApplicationRestApi.Model.TransactionDTO.Transaction;
import com.javaRestApi.BankingApplicationRestApi.Model.TransactionDTO.TransactionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionalRepositry  extends JpaRepository<Transaction,Long> {

    List<Transaction> findByAccountNumberOrderByTransactionDateDesc(String accountNumber);
}
