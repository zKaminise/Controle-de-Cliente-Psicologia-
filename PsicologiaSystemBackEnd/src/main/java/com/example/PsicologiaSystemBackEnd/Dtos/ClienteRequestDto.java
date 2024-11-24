package com.example.PsicologiaSystemBackEnd.Dtos;

import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteRequestDto { //DTO para receber dados ao Cadastrar ou editar um cliente

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
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
