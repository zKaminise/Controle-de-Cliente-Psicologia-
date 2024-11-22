package com.example.PsicologiaSystemBackEnd.Controllers;

import com.example.PsicologiaSystemBackEnd.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        if (userService.validateUser(username, password)) {
            return ResponseEntity.ok("Login bem sucedido");
        } else {
            return ResponseEntity.status(401).body("Usuario ou senha incorretos");
        }
    }
}
