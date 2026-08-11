package com.javaRestApi.BankingApplicationRestApi.Configure;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@org.springframework.context.annotation.Configuration

@EnableWebSecurity
public class Configure {

    @Bean
    public UserDetailsService getUserDetails(){
        List<UserDetails> user =new ArrayList<>();
        UserDetails userDetails=User.withDefaultPasswordEncoder().username("Ram")
                .password("Ram")
                .roles("Admin")
                .build();
        user.add(userDetails);
        return new InMemoryUserDetailsManager(user);
    }

}

