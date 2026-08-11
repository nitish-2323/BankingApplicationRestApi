package com.javaRestApi.BankingApplicationRestApi.Configure;

import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO.CustomerDto;
import com.javaRestApi.BankingApplicationRestApi.Repository.AccountRepositry;
import com.javaRestApi.BankingApplicationRestApi.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerAuthentication implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomerDto user =customerRepository.findByFullName(username);
        if (user == null) {
            throw new UsernameNotFoundException(
                    "Customer not found: " + username);
        }

        return User.withUsername(user.getFullName())
                .password(user.getPassword())
                .roles("ADMIN")
                .build();
    }
}
