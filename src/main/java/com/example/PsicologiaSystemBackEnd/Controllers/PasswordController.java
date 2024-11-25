package com.example.PsicologiaSystemBackEnd.Controllers;

import com.example.PsicologiaSystemBackEnd.Services.PasswordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/password")
@Tag(name = "Reset de Senha", description = "Reset de senha")
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PutMapping("/reset")
    public String resetPassword(@RequestParam String username, @RequestParam String newPassword) {
        passwordService.resetPassword(username, newPassword);
        return "Senha alterada com sucesso";
    }
}
