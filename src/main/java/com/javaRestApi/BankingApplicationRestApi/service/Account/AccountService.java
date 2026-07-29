package com.javaRestApi.BankingApplicationRestApi.service.Account;

import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.Account;
import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.AccountRequestDTO;
import com.javaRestApi.BankingApplicationRestApi.Model.AccountDTO.AccountResponseDTO;

import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO.CustomerDto;
import com.javaRestApi.BankingApplicationRestApi.Repository.AccountRepository;
import com.javaRestApi.BankingApplicationRestApi.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    // Create Account
    public AccountResponseDTO createAccount(AccountRequestDTO request) {

        CustomerDto customer = customerRepository.findById(Math.toIntExact(request.getCustomerId())).orElse(null);

        if (customer == null) {
            return null;
        }

        Account account = new Account();

        account.setAccountType(request.getAccountType());
        account.setBalance(request.getOpeningBalance());
        account.setStatus("ACTIVE");

        // Generate Random 10 Digit Account Number
        Random random = new Random();
        String accountNumber = String.valueOf(1000000000L + random.nextInt(900000000));

        account.setAccountNumber(accountNumber);

        // Set Customer Relation
        account.setCustomer(customer);

        Account savedAccount = accountRepository.save(account);

        AccountResponseDTO response = new AccountResponseDTO();

        response.setAccountId(savedAccount.getAccountId());
        response.setAccountNumber(savedAccount.getAccountNumber());
        response.setAccountType(savedAccount.getAccountType());
        response.setBalance(savedAccount.getBalance());
        response.setStatus(savedAccount.getStatus());

        return response;
    }

    // Get Single Account
    public AccountResponseDTO getAccount(Long accountId) {

        Account account = accountRepository.findById(accountId).orElse(null);

        if (account == null) {
            return null;
        }

        AccountResponseDTO response = new AccountResponseDTO();

        response.setAccountId(account.getAccountId());
        response.setAccountNumber(account.getAccountNumber());
        response.setAccountType(account.getAccountType());
        response.setBalance(account.getBalance());
        response.setStatus(account.getStatus());

        return response;
    }

    // Get Customer Accounts
    public List<AccountResponseDTO> getCustomerAccounts(Long customerId) {

        List<Account> accounts = accountRepository.findByCustomerCustomerId(customerId);

        List<AccountResponseDTO> responseList = new ArrayList<>();

        for (Account account : accounts) {

            AccountResponseDTO response = new AccountResponseDTO();

            response.setAccountId(account.getAccountId());
            response.setAccountNumber(account.getAccountNumber());
            response.setAccountType(account.getAccountType());
            response.setBalance(account.getBalance());
            response.setStatus(account.getStatus());

            responseList.add(response);
        }

        return responseList;
    }

    // Close Account
    public void closeAccount(Long accountId) {

        Account account = accountRepository.findById(accountId).orElse(null);

        if (account != null) {

            account.setStatus("CLOSED");

            accountRepository.save(account);
        }

    }

}