package com.javaRestApi.BankingApplicationRestApi.Repository;

import com.javaRestApi.BankingApplicationRestApi.Model.DepositDTO.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositRepositry extends JpaRepository<Deposit,Long> {
}
