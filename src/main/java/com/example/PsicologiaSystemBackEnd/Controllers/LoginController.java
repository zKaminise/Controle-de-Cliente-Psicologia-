package com.example.PsicologiaSystemBackEnd.Controllers;

import com.example.PsicologiaSystemBackEnd.Dtos.LoginRequestDto;
import com.example.PsicologiaSystemBackEnd.Services.LoginService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Login", description = "Login e autenticação de usúario")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public String login(@RequestBody LoginRequestDto loginRequestDTO) {
        return loginService.login(loginRequestDTO);
    }
}
