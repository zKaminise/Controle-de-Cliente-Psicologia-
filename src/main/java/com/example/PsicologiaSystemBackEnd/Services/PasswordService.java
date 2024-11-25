package com.example.PsicologiaSystemBackEnd.Services;

import org.springframework.stereotype.Service;

@Service
public class PasswordService {

    public void resetPassword(String username, String newPassword) {
        System.out.println("Senha alterada para o usúario" + username);
    }
}
