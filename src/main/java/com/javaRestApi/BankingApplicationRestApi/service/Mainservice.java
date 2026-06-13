package com.javaRestApi.BankingApplicationRestApi.service;

import com.javaRestApi.BankingApplicationRestApi.Execption.UserExecption;
import com.javaRestApi.BankingApplicationRestApi.Execption.UserNotFound;
import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO;
import com.javaRestApi.BankingApplicationRestApi.Repositry.MainRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mainservice {
    @Autowired
    private MainRepositry mainRepositry;

    public CustomerDTO save(CustomerDTO dto) {
        if (mainRepositry.existsBycustomerId(Math.toIntExact(dto.getCustomerId()))) {
            throw new UserExecption("Id must be unique,plz check Customer id");
        } else {
            CustomerDTO obj = mainRepositry.save(dto);
            return obj;
        }
    }

    public CustomerDTO getInfo(CustomerDTO dto,long customerId) {
      CustomerDTO obj=  mainRepositry.findBycustomerId(customerId);
      if( obj == null){
          throw  new UserNotFound("Invalid employee user ");
      }
      else {
          return obj;
      }
    }
}

