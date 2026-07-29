package com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExecptionDTO {
    private int status;
    private String msg;
    private LocalDateTime dateTime;
    private String path;
}
