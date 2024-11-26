package com.example.PsicologiaSystemBackEnd.Entities;

import com.example.PsicologiaSystemBackEnd.Enums.EstadosBrasileirosEnum;
import com.example.PsicologiaSystemBackEnd.Enums.GeneroEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Table(name = "tb_cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 3, message = "Nome não pode estar vazio")
    @Column(nullable = false)
    @Schema(example = "Gabriel Misao",minLength = 3, maxLength = 150, requiredMode = Schema.RequiredMode.REQUIRED, description = "Nome do Cliente")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past(message = "A data não está correta")
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private GeneroEnum generoEnum;

    private String endereco;

    @Enumerated(EnumType.STRING)
    private EstadosBrasileirosEnum estadosBrasileirosEnum;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 números.")
    @Column(unique = true, nullable = false)
    @Schema(example = "12345678910",minLength = 11, maxLength = 11, requiredMode = Schema.RequiredMode.REQUIRED, description = "CPF do Cliente")
    private String cpf;

    @Email(message = "Email deve ser valido")
    @Column(unique = true, nullable = false)
    @Schema(example = "Gabriel@teste.com", requiredMode = Schema.RequiredMode.REQUIRED, description = "Email do Cliente")
    private String email;

    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter apenas números.")
    @Column(length = 11, nullable = false)
    @Schema(example = "34999999999",minLength = 10, maxLength = 11, description = "Celular do Cliente")
    private String telefone;


    private String religiao;
    private String medicamentos;

    @Column(columnDefinition = "TEXT")
    private String queixaPrincipal;

    private Boolean recebeuAlta;

}
