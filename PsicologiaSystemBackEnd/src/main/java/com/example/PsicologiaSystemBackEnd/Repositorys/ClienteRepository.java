package com.example.PsicologiaSystemBackEnd.Repositorys;

import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
