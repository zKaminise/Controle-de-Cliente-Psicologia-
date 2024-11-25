package com.example.PsicologiaSystemBackEnd.Dtos;

import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteRequestDto { //DTO para receber dados ao Cadastrar ou editar um cliente

    private Long id;

    @Schema(example = "Gabriel Misao")
    private String nome;

    @Schema(example = "12345678910")
    private String cpf;

    @Schema(example = "gabriel@gmail.com")
    private String email;

    @Schema(example = "34999999999")
    private String telefone;

    @Schema(example = "true")
    private Boolean recebeuAlta;

    public ClienteRequestDto(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        cpf = cliente.getCpf();
        email = cliente.getEmail();
        telefone = cliente.getTelefone();
        recebeuAlta = cliente.getRecebeuAlta();
    }
}
