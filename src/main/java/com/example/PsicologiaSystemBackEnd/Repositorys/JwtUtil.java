package com.example.PsicologiaSystemBackEnd.Repositorys;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Expira em 10 horas
                .signWith(secretKey)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        try {
            return Jwts.parser()  // Usando o parserBuilder para JWT moderno
                    .setSigningKey(secretKey)
                    .build() // Chama o build() para finalizar a configuração
                    .parseClaimsJws(token)  // Parse o JWT para Claims
                    .getBody()  // Recupera o corpo do JWT
                    .getSubject();  // Retorna o "subject" (usuário)
        } catch (Exception e) {
            // Em caso de erro, pode lançar uma exceção ou logar
            throw new IllegalArgumentException("Token inválido ou expirado", e);
        }
    }

    public boolean validateToken(String token) {
        return !getUsernameFromToken(token).isEmpty();
    }
}
