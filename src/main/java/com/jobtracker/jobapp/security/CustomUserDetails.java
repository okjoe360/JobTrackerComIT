package com.jobtracker.jobapp.security;

import com.jobtracker.jobapp.entity.User;
import com.jobtracker.jobapp.enums.Role;
import com.jobtracker.jobapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetails implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public CustomUserDetails(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override   // this function is uses spring loadUserByUsername method that retrieves object from db and returns into spring security provided user.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user!=null){
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(String.valueOf(user.getRole()))));
        }
        else{
            throw new UsernameNotFoundException("Invalid email or password");
        }
    }
}
