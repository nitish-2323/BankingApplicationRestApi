package com.javaRestApi.BankingApplicationRestApi.Execption;

public class InsufficentAmount extends RuntimeException {
    public InsufficentAmount(String message) {
        super(message);
    }
}
