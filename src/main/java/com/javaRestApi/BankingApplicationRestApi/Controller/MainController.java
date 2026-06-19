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
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/userInfo/{customerId}")
    public ResponseEntity<ResponseDTO> userInfo(CustomerDTO dto,@PathVariable long customerId){
        CustomerDTO obj =mainservice.getInfo(dto,customerId);
        responseDTO.setError(false);
        responseDTO.setMsg("You can read info");
        responseDTO.setStatusCode(HttpStatus.OK.value());
        List<CustomerDTO> list =new ArrayList<>();
        list.add(obj);
        responseDTO.setMydtos(list);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
     @PutMapping("/userUpdate/{customerId}")
    public ResponseEntity<ResponseDTO> userUpdate(@RequestBody CustomerDTO dto,@PathVariable long customerId){
        CustomerDTO obj =mainservice.updateObj(dto,customerId);
        responseDTO.setStatusCode(HttpStatus.FOUND.value());
        responseDTO.setError(false);
        responseDTO.setMsg("Update sucessfully");
        List<CustomerDTO> list = new ArrayList<>();
        list.add(obj);
        responseDTO.setMydtos(list);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
     }
     @DeleteMapping("/deleteUser/{customerId}")
     public ResponseEntity<ResponseDTO> Delete(@PathVariable long customerId){
        CustomerDTO dto=  mainservice.delete(customerId);
         responseDTO.setStatusCode(HttpStatus.OK.value());
         responseDTO.setMsg("Deleted customer from database");
         responseDTO.setError(false);
         List<CustomerDTO> list = new ArrayList<>();
         list.add(dto);
         responseDTO.setMydtos(list);
         return new ResponseEntity<>(responseDTO,HttpStatus.OK);

     }


}
