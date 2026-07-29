//package com.javaRestApi.BankingApplicationRestApi.service;
//
//import com.javaRestApi.BankingApplicationRestApi.Model.CustomerDTO.CustomerDTO;
//import com.javaRestApi.BankingApplicationRestApi.Repositry.MainRepositry;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class CustomUserDetailservice  implements UserDetailsService {
//
//    @Autowired
//    private MainRepositry repositry;
//    @Override
//    public UserDetails loadUserByUsername(String fullName) throws UsernameNotFoundException {
//        CustomerDTO obj =repositry.findByFullName(fullName);
//        if( obj == null) throw new UsernameNotFoundException("No username found in DB");
//
//        return new User(obj.getFullName(),obj.getPassword(),new ArrayList<>());
//    }
//}
