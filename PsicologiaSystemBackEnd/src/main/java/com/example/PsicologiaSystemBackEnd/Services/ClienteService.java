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
    public Cliente findByCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
        return cliente.orElseThrow(() -> new RuntimeException("Cliente com o CPF: " + cpf + "Não foi encontrado"));
    }

    @Transactional
    public Cliente cadastrarCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        atualizarEntidade(cliente, clienteDto); // Preenche os dados
        return clienteRepository.save(cliente);
    }

    private void atualizarEntidade(Cliente cliente, ClienteDto clienteDto) {
        cliente.setNome(clienteDto.getNome());
        cliente.setDataNascimento(clienteDto.getDataNascimento());
        cliente.setGeneroEnum(clienteDto.getGeneroEnum());
        cliente.setEndereco(clienteDto.getEndereco());
        cliente.setEstadosBrasileirosEnum(clienteDto.getEstadosBrasileirosEnum());
        cliente.setCpf(clienteDto.getCpf());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setTelefone(clienteDto.getTelefone());
        cliente.setReligiao(clienteDto.getReligiao());
        cliente.setMedicamentos(clienteDto.getMedicamentos());
        cliente.setQueixaPrincipal(clienteDto.getQueixaPrincipal());
        cliente.setRecebeuAlta(clienteDto.getRecebeuAlta());
    }

    @Transactional
    public Cliente atualizarCliente(Long id, ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente com o ID: " + id + "não foi encontrado"));
        atualizarEntidade(cliente, clienteDto);
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void deletarCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente com o ID: " + id + " não foi encontrado"));
        clienteRepository.delete(cliente);
    }
}
