package com.example.PsicologiaSystemBackEnd.Dtos;

import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteMinInfoDto {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Boolean recebeuAlta;

    public ClienteMinInfoDto(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        cpf = cliente.getCpf();
        email = cliente.getEmail();
        telefone = cliente.getTelefone();
        recebeuAlta = cliente.getRecebeuAlta();
    }
}
