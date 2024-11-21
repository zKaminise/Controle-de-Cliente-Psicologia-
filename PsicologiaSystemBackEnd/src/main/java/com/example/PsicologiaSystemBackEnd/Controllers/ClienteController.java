package com.example.PsicologiaSystemBackEnd.Controllers;

import com.example.PsicologiaSystemBackEnd.Dtos.ClienteMinInfoDto;
import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import com.example.PsicologiaSystemBackEnd.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

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
}
