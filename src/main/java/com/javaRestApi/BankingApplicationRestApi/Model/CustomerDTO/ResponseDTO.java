package com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
public class ResponseDTO {
    private int statusCode;
    private boolean error;
    private String msg;
    private List<CustomerDto> mydtos;




}
