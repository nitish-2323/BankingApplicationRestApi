package com.javaRestApi.BankingApplicationRestApi.Configure;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@org.springframework.context.annotation.Configuration

@EnableWebSecurity
public class Configure {

//    @Bean
//    public UserDetailsService getUserDetails(){
//        List<UserDetails> user =new ArrayList<>();
//        UserDetails userDetails=User.withDefaultPasswordEncoder().username("Ram")
//                .password("Ram")
//                .roles("Admin")
//                .build();
//        user.add(userDetails);
//        return new InMemoryUserDetailsManager(user);
//    }
     @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity request){
         return request.csrf(crsf ->crsf.disable())
                 .authorizeHttpRequests(auth->
                         auth.requestMatchers("/userInfo/**")
                                 .hasRole("ADMIN")
                                 .anyRequest()
                                 .authenticated()).httpBasic(Customizer.withDefaults()).build();

     }
}

