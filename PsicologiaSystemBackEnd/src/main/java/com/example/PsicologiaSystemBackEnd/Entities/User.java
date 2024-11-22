package com.example.PsicologiaSystemBackEnd.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_user")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Usuario é obrigatório")
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank(message = "Senha é obrigatório")
    @Column(unique = true, nullable = false)
    private String password;


}
