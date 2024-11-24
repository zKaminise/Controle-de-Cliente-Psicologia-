package com.example.PsicologiaSystemBackEnd.Dtos;

import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import com.example.PsicologiaSystemBackEnd.Enums.EstadosBrasileirosEnum;
import com.example.PsicologiaSystemBackEnd.Enums.GeneroEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteResponseDto { //Clase DTO para Retornar Dados do cliente após consulta

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private GeneroEnum generoEnum;
    private String endereco;
    private EstadosBrasileirosEnum estadosBrasileirosEnum;
    private String cpf;
    private String email;
    private String telefone;
    private String religiao;
    private String medicamentos;
    private String queixaPrincipal;
    private Boolean recebeuAlta;

    public ClienteResponseDto(Cliente cliente) {
        BeanUtils.copyProperties(cliente, this);
    }
}
