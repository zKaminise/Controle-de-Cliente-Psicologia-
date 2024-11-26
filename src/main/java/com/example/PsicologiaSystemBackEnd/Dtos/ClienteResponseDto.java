package com.example.PsicologiaSystemBackEnd.Dtos;

import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import com.example.PsicologiaSystemBackEnd.Enums.EstadosBrasileirosEnum;
import com.example.PsicologiaSystemBackEnd.Enums.GeneroEnum;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(example = "Gabriel Misao")
    private String nome;

    private LocalDate dataNascimento;
    private GeneroEnum generoEnum;

    @Schema(example = "Rua Itabira")
    private String endereco;
    private EstadosBrasileirosEnum estadosBrasileirosEnum;

    @Schema(example = "12345678910")
    private String cpf;

    @Schema(example = "gabriel@teste.com")
    private String email;

    @Schema(example = "34999999999")
    private String telefone;

    @Schema(example = "Católico")
    private String religiao;

    @Schema(example = "Aspirina"    )
    private String medicamentos;

    private String queixaPrincipal;
    private Boolean recebeuAlta;

    public ClienteResponseDto(Cliente cliente) {
        BeanUtils.copyProperties(cliente, this);
    }
}
