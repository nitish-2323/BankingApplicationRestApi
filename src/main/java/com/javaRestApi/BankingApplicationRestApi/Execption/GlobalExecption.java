package com.javaRestApi.BankingApplicationRestApi.Execption;

import com.javaRestApi.BankingApplicationRestApi.Model.ExecptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExecption {
   @ExceptionHandler(Exception.class)
    public ResponseEntity<ExecptionDTO> genricExecption (Exception e , WebRequest request){
       ExecptionDTO obj = new ExecptionDTO();
       obj.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
       obj.setMsg(e.getMessage());
       obj.setDateTime(LocalDateTime.now());
       obj.setPath(request.getDescription(false));
       return new ResponseEntity<ExecptionDTO>(obj, HttpStatus.INTERNAL_SERVER_ERROR);
   }
   @ExceptionHandler(UserExecption.class)
    public ResponseEntity<ExecptionDTO> userExecption(Exception e ,WebRequest request){
       ExecptionDTO obj = new ExecptionDTO();
       obj.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
       obj.setPath(request.getDescription(false));
       obj.setMsg(e.getMessage());
       obj.setDateTime(LocalDateTime.now());
       return new ResponseEntity<>(obj ,HttpStatus.NOT_ACCEPTABLE);
   }

}
