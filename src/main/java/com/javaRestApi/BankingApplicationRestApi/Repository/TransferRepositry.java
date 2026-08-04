package com.javaRestApi.BankingApplicationRestApi.Repository;

import com.javaRestApi.BankingApplicationRestApi.Model.TransferAmount.TransferDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepositry extends JpaRepository<TransferDTO,Long> {

}
