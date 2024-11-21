package com.example.PsicologiaSystemBackEnd.Dtos;

import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import com.example.PsicologiaSystemBackEnd.Enums.EstadosBrasileirosEnum;
import com.example.PsicologiaSystemBackEnd.Enums.GeneroEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClienteDto {

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

    public ClienteDto(Cliente cliente) {
        BeanUtils.copyProperties(cliente, this);
    }
}
