package com.example.PsicologiaSystemBackEnd.Services;

import com.example.PsicologiaSystemBackEnd.Dtos.ClienteDto;
import com.example.PsicologiaSystemBackEnd.Dtos.ClienteMinInfoDto;
import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import com.example.PsicologiaSystemBackEnd.Repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public List<ClienteMinInfoDto> findAll() { //Listar Todos Clientes Já cadastrado na Base de Dados (Tela Inicial)
        List<Cliente> result = clienteRepository.findAll();
        return result.stream().map(ClienteMinInfoDto::new).toList();
    }

    @Transactional
    public ClienteDto findById(@PathVariable Long id) { //Buscar um cliente pelo ID
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return new ClienteDto(cliente);
    }

    @Transactional
    public Cliente findByCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
        return cliente.orElseThrow(() -> new RuntimeException("Cliente com o CPF: " + cpf + "Não foi encontrado"));
    }
}
