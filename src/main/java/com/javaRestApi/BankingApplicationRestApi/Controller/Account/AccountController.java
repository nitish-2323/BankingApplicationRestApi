package com.javaRestApi.BankingApplicationRestApi.Controller.Account;

import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.AccountRequestDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.AccountResponseDTO;
import com.javaRestApi.BankingApplicationRestApi.service.Account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Create Account
    @PostMapping("/create")
    public AccountResponseDTO createAccount(@RequestBody AccountRequestDTO request) {
        return accountService.createAccount(request);
    }

    // Get Account By Id
    @GetMapping("/{accountId}")
    public AccountResponseDTO getAccount(@PathVariable Long accountId) {
        return accountService.getAccount(accountId);
    }

    // Get All Accounts of a Customer
    @GetMapping("/customer/{customerId}")
    public List<AccountResponseDTO> getCustomerAccounts(@PathVariable Long customerId) {
        return accountService.getCustomerAccounts(customerId);
    }

    // Close Account
    @PutMapping("/close/{accountId}")
    public String closeAccount(@PathVariable Long accountId) {

        accountService.closeAccount(accountId);

        return "Account Closed Successfully";
    }

}
