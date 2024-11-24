package com.example.PsicologiaSystemBackEnd.Controllers;

import com.example.PsicologiaSystemBackEnd.Dtos.ClienteRequestDto;
import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import com.example.PsicologiaSystemBackEnd.Exceptions.ClienteNotFoundException;
import com.example.PsicologiaSystemBackEnd.Exceptions.EmailOrCpfFoundException;
import com.example.PsicologiaSystemBackEnd.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteRequestDto> findAll() {
        List<ClienteRequestDto> findAllClientes = clienteService.findAll();
        return findAllClientes;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable String cpf) {
        Optional<Cliente> cliente = clienteService.buscarClientePorCpf(cpf);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    @PostMapping
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.novoCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Cliente cadastrado com sucesso!");
        } catch (EmailOrCpfFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            clienteService.editarCliente(id, cliente);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente atualizado com sucesso!");
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
        try {
            clienteService.excluirCliente(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído com sucesso!");
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
