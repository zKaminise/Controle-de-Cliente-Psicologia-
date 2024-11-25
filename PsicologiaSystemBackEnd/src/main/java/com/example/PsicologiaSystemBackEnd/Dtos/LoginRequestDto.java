package com.example.PsicologiaSystemBackEnd.Dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginRequestDto {

    @Schema(example = "Gabriel")
    private String username;

    private String password;
}
