package com.javaRestApi.BankingApplicationRestApi.Controller.Transfer;

import com.javaRestApi.BankingApplicationRestApi.Model.TransferAmount.TransferRequestDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.TransferAmount.TransferResponseDTO;
import com.javaRestApi.BankingApplicationRestApi.service.TransferService.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    @Autowired
    private TransferService service;
    @Autowired
    private TransferResponseDTO responseDTO;
    @PostMapping("/transfer")
    public ResponseEntity<TransferResponseDTO> transfer(@RequestBody TransferRequestDTO requestDTO){
        TransferRequestDTO dto =service.transfer(requestDTO);
        responseDTO.setFromAccountNumber(dto.getFromAccountNumber());
        responseDTO.setToAccountNumber(dto.getToAccountNumber());
        responseDTO.setAmount(dto.getAmount());
        responseDTO.setStatusCode(201);
        responseDTO.setError(false);
        responseDTO.setMsg("Sucessfully transfer the amount");
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
