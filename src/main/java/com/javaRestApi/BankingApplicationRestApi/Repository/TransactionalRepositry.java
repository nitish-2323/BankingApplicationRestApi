package com.javaRestApi.BankingApplicationRestApi.Repository;

import com.javaRestApi.BankingApplicationRestApi.Model.TransferAmount.TransferDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

@Repository
public interface TransactionalRepositry extends JpaRepository<TransferDTO,Long> {
}
