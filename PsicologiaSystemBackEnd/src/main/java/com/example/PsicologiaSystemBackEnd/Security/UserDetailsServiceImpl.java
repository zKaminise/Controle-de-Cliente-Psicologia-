package com.example.PsicologiaSystemBackEnd.Security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements  UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    .password("{noop}admin123")
                    .roles("ADMIN")
                    .build();
        }
        throw new UsernameNotFoundException("Usuario não encontrado");
    }
}
