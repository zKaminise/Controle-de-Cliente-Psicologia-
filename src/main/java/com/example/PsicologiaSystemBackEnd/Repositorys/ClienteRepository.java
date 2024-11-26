package com.example.PsicologiaSystemBackEnd.Repositorys;

import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    Optional<Cliente> findByCpf(String cpf);
    Cliente findByNome(String nome);
    Optional<Cliente> findByEmail(String email);
}
