package com.example.PsicologiaSystemBackEnd.Services;

import com.example.PsicologiaSystemBackEnd.Dtos.LoginRequestDto;
import com.example.PsicologiaSystemBackEnd.Repositorys.JwtUtil;
import com.example.PsicologiaSystemBackEnd.Security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    public String login(LoginRequestDto loginRequestDTO) {
        // Criando o token de autenticação
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDTO.getUsername(),
                        loginRequestDTO.getPassword()
                )
        );

        // Depois de autenticar, carregamos os detalhes do usuário
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequestDTO.getUsername());

        // Gerar o token JWT
        return jwtUtil.generateToken(userDetails.getUsername());
    }
}
