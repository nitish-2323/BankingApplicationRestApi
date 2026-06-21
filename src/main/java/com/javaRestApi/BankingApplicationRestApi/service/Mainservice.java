package com.javaRestApi.BankingApplicationRestApi.service;

import com.javaRestApi.BankingApplicationRestApi.Execption.UserExecption;
import com.javaRestApi.BankingApplicationRestApi.Execption.UserNotFound;
import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO;
import com.javaRestApi.BankingApplicationRestApi.Repositry.MainRepositry;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mainservice {
    @Autowired
    private MainRepositry mainRepositry;

    public CustomerDTO save(CustomerDTO dto, long customerId) {
       CustomerDTO obj = mainRepositry.findBycustomerId(customerId);
       if(obj != null){
            throw new UserExecption("Id must be unique,plz check Customer id");
        } else {
           return  mainRepositry.save(dto);

       }
    }

    public CustomerDTO getInfo(CustomerDTO dto, long customerId) {
        CustomerDTO obj = mainRepositry.findBycustomerId(customerId);
        if (obj == null) {
            throw new UserNotFound("Invalid employee user ");
        } else {
            return obj;
        }
    }

    public CustomerDTO updateObj(CustomerDTO dto,long customerId) {
        CustomerDTO obj = mainRepositry.findBycustomerId(customerId);
        if (obj == null) {
            throw new UserNotFound("CustomerId cannot found ");
        }
        obj.setFullName(dto.getFullName());
        obj.setEmail(dto.getEmail());
        obj.setPhoneNumber(dto.getPhoneNumber());
        obj.setAddress(dto.getAddress());
        obj.setAadhaarNumber(dto.getAadhaarNumber());
        obj.setPanNumber(dto.getPanNumber());
        return mainRepositry.save(obj);

    }
    @Transactional
    public CustomerDTO delete(long customerId) {
           CustomerDTO obj =mainRepositry.findBycustomerId(customerId);
           if(obj == null) {
               throw new UserNotFound("customerId not found for delete");
           }
           mainRepositry.deleteByCustomerId(customerId);
           return obj;

    }
}

