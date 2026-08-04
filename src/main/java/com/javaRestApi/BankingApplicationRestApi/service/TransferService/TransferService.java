package com.javaRestApi.BankingApplicationRestApi.service.TransferService;

import com.javaRestApi.BankingApplicationRestApi.Execption.InsufficentAmount;
import com.javaRestApi.BankingApplicationRestApi.Execption.UserNotFound;
import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.Account;
import com.javaRestApi.BankingApplicationRestApi.Model.TransferAmount.TransferDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.TransferAmount.TransferRequestDTO;
import com.javaRestApi.BankingApplicationRestApi.Repository.AccountRepositry;
import com.javaRestApi.BankingApplicationRestApi.Repository.TransferRepositry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Transactional
public class TransferService {
   Account account = new Account();
    @Autowired
    private AccountRepositry repositry;
    @Autowired
    private TransferRepositry transactionalRepositry;

    public TransferRequestDTO transfer(TransferRequestDTO requestDTO) {
        Account sender = repositry.findByAccountNumber(requestDTO.getFromAccountNumber());
        Account receiver = repositry.findByAccountNumber(requestDTO.getToAccountNumber());
        if (sender == null) {
            throw new UserNotFound("Sender Account is not exist");
        }
        if (receiver == null) {
            throw new UserNotFound("Recevier Account is not exist");
        }
        if (!"active".equalsIgnoreCase(sender.getStatus())) {
            throw new UserNotFound("Your Sender account is not Active, Plz check account");
        }
        if (!"active".equalsIgnoreCase(receiver.getStatus())) {
            throw new UserNotFound("Your Recevier account is not Active, Plz check account");
        }
        if (sender.getBalance() < requestDTO.getAmount()) {
            throw new InsufficentAmount("Your current balance is not sufficent to transfer the amount ");
        }
        sender.setBalance(sender.getBalance() - requestDTO.getAmount());
        repositry.save(sender);
        receiver.setBalance(receiver.getBalance() + requestDTO.getAmount());
        repositry.save(receiver);

        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setTransactionId(UUID.randomUUID().toString());
        transferDTO.setFromAccountNumber(sender.getAccountNumber());
        transferDTO.setToAccountNumber(receiver.getAccountNumber());
        transferDTO.setAmount(requestDTO.getAmount());
        transferDTO.setSenderBalance(sender.getBalance());
        transferDTO.setReceiverBalance(receiver.getBalance());
        transferDTO.setStatus("Sucess");
        transferDTO.setMessage("Money transferred successfully");
        transferDTO.setTransactionDateTime(LocalDateTime.now());
        transactionalRepositry.save(transferDTO);
        return requestDTO;


    }
}
