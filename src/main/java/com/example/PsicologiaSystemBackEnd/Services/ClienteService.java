package com.example.PsicologiaSystemBackEnd.Services;

import com.example.PsicologiaSystemBackEnd.Dtos.ClienteRequestDto;
import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import com.example.PsicologiaSystemBackEnd.Exceptions.ClienteNotFoundException;
import com.example.PsicologiaSystemBackEnd.Repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente novoCliente (Cliente cliente) {
        if (clienteRepository.existsByCpf(cliente.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    public List<ClienteRequestDto> findAll() {
        List<Cliente> result = clienteRepository.findAll();
        return result.stream().map(ClienteRequestDto::new).toList();
    }

    public Optional<Cliente> buscarClientePorCpf(String cpf) {
        return clienteRepository.findByCpf(cpf);
    }

    public Cliente editarCliente(Long id, Cliente clienteAtualizado) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não foi encontado"));
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
        cliente.setGeneroEnum(clienteAtualizado.getGeneroEnum());
        cliente.setEndereco(clienteAtualizado.getEndereco());
        cliente.setEstadosBrasileirosEnum(clienteAtualizado.getEstadosBrasileirosEnum());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setReligiao(clienteAtualizado.getReligiao());
        cliente.setMedicamentos(clienteAtualizado.getMedicamentos());
        cliente.setQueixaPrincipal(clienteAtualizado.getQueixaPrincipal());
        cliente.setRecebeuAlta(clienteAtualizado.getRecebeuAlta());

        return clienteRepository.save(cliente);
    }

    public void excluirCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não foi encontado"));
        clienteRepository.delete(cliente);
    }
}









