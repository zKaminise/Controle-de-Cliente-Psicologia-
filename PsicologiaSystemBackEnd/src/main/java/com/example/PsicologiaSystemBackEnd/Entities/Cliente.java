package com.example.PsicologiaSystemBackEnd.Entities;

import com.example.PsicologiaSystemBackEnd.Enums.EstadosBrasileirosEnum;
import com.example.PsicologiaSystemBackEnd.Enums.GeneroEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroEnum generoEnum;

    private String endereco;

    @Enumerated(EnumType.STRING)
    private EstadosBrasileirosEnum estadosBrasileirosEnum;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(length = 12, nullable = false)
    private String telefone;
    private String religiao;
    private String medicamentos;

    @Column(columnDefinition = "TEXT")
    private String queixaPrincipal;

    private Boolean recebeuAlta;

}
