package com.example.PsicologiaSystemBackEnd.Controllers;

import com.example.PsicologiaSystemBackEnd.Dtos.ClienteDto;
import com.example.PsicologiaSystemBackEnd.Dtos.ClienteMinInfoDto;
import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import com.example.PsicologiaSystemBackEnd.Exceptions.EmailOrCpfFoundException;
import com.example.PsicologiaSystemBackEnd.Repositorys.ClienteRepository;
import com.example.PsicologiaSystemBackEnd.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteMinInfoDto> findAll() {
        List<ClienteMinInfoDto> findAllClientes = clienteService.findAll();
        return findAllClientes;
    }

    @GetMapping("/buscar")
    public ResponseEntity<Cliente> buscarPorCpf(@RequestParam String cpf) {
        try {
            Cliente cliente = clienteService.findByCpf(cpf);
            return ResponseEntity.ok(cliente);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> cadastrarCliente(@RequestBody ClienteDto clienteDto) {
        try {
            clienteService.validarCadastro(clienteDto);
            clienteService.cadastrarCliente(clienteDto);
            return ResponseEntity.ok("Cliente cadastrado com sucesso");
        } catch (EmailOrCpfFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        try {
            clienteService.atualizarCliente(id, clienteDto);
            return ResponseEntity.ok("Dados do cliente atualizados com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id) {
        try {
            clienteService.deletarCliente(id);
            return ResponseEntity.ok("Cliente deletado com sucesso");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
