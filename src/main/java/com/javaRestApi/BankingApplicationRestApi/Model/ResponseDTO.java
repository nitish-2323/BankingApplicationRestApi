package com.javaRestApi.BankingApplicationRestApi.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
public class ResponseDTO {
    private int statusCode;
    private boolean error;
    private String msg;
    private List<CustomerDTO> mydtos;




}
