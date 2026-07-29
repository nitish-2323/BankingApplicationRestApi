package com.javaRestApi.BankingApplicationRestApi.Repository;

import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerDto,Integer> {


    boolean existsBycustomerId(int intExact);

    CustomerDto findBycustomerId(Long customerId);


    CustomerDto findByFullName(String fullName);





    CustomerDto deleteByCustomerId(long customerId);


}
