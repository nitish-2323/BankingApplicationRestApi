package com.javaRestApi.BankingApplicationRestApi.Execption;

public class UserNotFound extends RuntimeException{
     public  UserNotFound(String S){
          super(S);
      }
}
