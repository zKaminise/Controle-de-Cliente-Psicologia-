package com.example.PsicologiaSystemBackEnd.Controllers;

import com.example.PsicologiaSystemBackEnd.Dtos.ClienteRequestDto;
import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import com.example.PsicologiaSystemBackEnd.Exceptions.ClienteNotFoundException;
import com.example.PsicologiaSystemBackEnd.Exceptions.InvalidCpfException;
import com.example.PsicologiaSystemBackEnd.Services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Informações dos Clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Listar todos Clientes", description = "Essa função é responsável por listar todos clientes")
    public List<ClienteRequestDto> findAll() {
        List<ClienteRequestDto> findAllClientes = clienteService.findAll();
        return findAllClientes;
    }

    @GetMapping("/{cpf}")
    @Operation(summary = "Listar Clientes filtrados por CPF", description = "Essa função é responsável por listar clientes com base no CPF pesquisado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Cliente.class))
            }),
            @ApiResponse(responseCode = "400", description = "Não foi encontrado cliente com esse CPF")
    })
    public ResponseEntity<Cliente> buscarCliente(@PathVariable String cpf) {
        Optional<Cliente> cliente = clienteService.buscarClientePorCpf(cpf);
        return cliente.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null));
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo Cliente", description = "Essa função é responsável por cadastrar novos clientes")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Cliente.class))
            }),
            @ApiResponse(responseCode = "400", description = "Cliente já existe")
    })
    public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.novoCliente(cliente);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Cliente cadastrado com sucesso!");
        } catch (InvalidCpfException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Alterar informações dos clientes", description = "Essa função é responsável por Alterar informações dos clientes")
    public ResponseEntity<String> editarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        try {
            clienteService.editarCliente(id, cliente);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente atualizado com sucesso!");
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir Cliente", description = "Essa função é responsável por excluir um determinado cliente")
    public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
        try {
            clienteService.excluirCliente(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente excluído com sucesso!");
        } catch (ClienteNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
