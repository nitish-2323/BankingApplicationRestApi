package com.javaRestApi.BankingApplicationRestApi.Controller;

import com.javaRestApi.BankingApplicationRestApi.Execption.GlobalExecption;
import com.javaRestApi.BankingApplicationRestApi.Execption.UserExecption;
import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.ResponseDTO;
import com.javaRestApi.BankingApplicationRestApi.Repositry.MainRepositry;
import com.javaRestApi.BankingApplicationRestApi.service.Mainservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private ResponseDTO responseDTO;
    @Autowired
    private Mainservice mainservice;
  @Autowired
  private MainRepositry repositry;

    @PostMapping("/addUser")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody CustomerDTO dto){
          CustomerDTO  obj = mainservice.save(dto);

          responseDTO.setError(false);
          responseDTO.setMsg("Created sucessfully");
          responseDTO.setStatusCode(201);
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        customerDTOList.add(obj);
        responseDTO.setMydtos(customerDTOList);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);

    }

}
