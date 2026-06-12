package com.javaRestApi.BankingApplicationRestApi.Repositry;

import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRepositry extends JpaRepository<CustomerDTO,Integer> {


    boolean existsBycustomerId(int intExact);
}
