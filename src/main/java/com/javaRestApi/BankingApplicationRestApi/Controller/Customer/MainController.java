package com.javaRestApi.BankingApplicationRestApi.Controller.Customer;

import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO.CustomerDto;
import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO.ResponseDTO;
import com.javaRestApi.BankingApplicationRestApi.Repository.CustomerRepository;
import com.javaRestApi.BankingApplicationRestApi.service.Mainservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    private ResponseDTO responseDTO;
    @Autowired
    private Mainservice mainservice;
  @Autowired
  private CustomerRepository repositry;

    @PostMapping("/addUser/{customerId}")
    public ResponseEntity<ResponseDTO> addUser(@RequestBody CustomerDto dto, @PathVariable long customerId){
          CustomerDto obj = mainservice.save(dto,customerId);

          responseDTO.setError(false);
          responseDTO.setMsg("Created sucessfully ...");
          responseDTO.setStatusCode(201);
        List<CustomerDto> customerDTOList = new ArrayList<>();
        customerDTOList.add(obj);
        responseDTO.setMydtos(customerDTOList);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);

    }
    @GetMapping("/userInfo/{customerId}")
    public ResponseEntity<ResponseDTO> userInfo(CustomerDto dto, @PathVariable long customerId){
        CustomerDto obj =mainservice.getInfo(dto,customerId);
        responseDTO.setError(false);
        responseDTO.setMsg("You can read info");
        responseDTO.setStatusCode(HttpStatus.OK.value());
        List<CustomerDto> list =new ArrayList<>();
        list.add(obj);
        responseDTO.setMydtos(list);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
     @PutMapping("/userUpdate/{customerId}")
    public ResponseEntity<ResponseDTO> userUpdate(@RequestBody CustomerDto dto, @PathVariable long customerId){
        CustomerDto obj =mainservice.updateObj(dto,customerId);
        responseDTO.setStatusCode(HttpStatus.FOUND.value());
        responseDTO.setError(false);
        responseDTO.setMsg("Update sucessfully");
        List<CustomerDto> list = new ArrayList<>();
        list.add(obj);
        responseDTO.setMydtos(list);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
     }
     @DeleteMapping("/deleteUser/{customerId}")
     public ResponseEntity<ResponseDTO> Delete(@PathVariable long customerId){
        CustomerDto dto=  mainservice.delete(customerId);
         responseDTO.setStatusCode(HttpStatus.OK.value());
         responseDTO.setMsg("Deleted customer from database");
         responseDTO.setError(false);
         List<CustomerDto> list = new ArrayList<>();
         list.add(dto);
         responseDTO.setMydtos(list);
         return new ResponseEntity<>(responseDTO,HttpStatus.OK);

     }


}
