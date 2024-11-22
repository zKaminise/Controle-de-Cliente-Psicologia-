package com.example.PsicologiaSystemBackEnd.Services;

import com.example.PsicologiaSystemBackEnd.Entities.Cliente;
import com.example.PsicologiaSystemBackEnd.Exceptions.ClienteNotFoundException;
import com.example.PsicologiaSystemBackEnd.Repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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








//    @Transactional
//    public List<ClienteMinInfoDto> findAll() { //Listar Todos Clientes Já cadastrado na Base de Dados (Tela Inicial)
//        List<Cliente> result = clienteRepository.findAll();
//        return result.stream().map(ClienteMinInfoDto::new).toList();
//    }
//
//    @Transactional
//    public Cliente findByCpf(String cpf) {
//        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
//        return cliente.orElseThrow(() -> new RuntimeException("Cliente com o CPF: " + cpf + "Não foi encontrado"));
//    }
//
//    public void validarCadastro(ClienteDto clienteDto) {
//        clienteRepository.findByEmail(clienteDto.getEmail())
//                .ifPresent(cliente -> {
//                    throw new EmailOrCpfFoundException("Email já cadastrado: " + clienteDto.getEmail());
//                });
//        clienteRepository.findByCpf(clienteDto.getCpf())
//                .ifPresent(cliente -> {
//                    throw new EmailOrCpfFoundException("CPF já cadastrado: " + clienteDto.getCpf());
//                });
//    }
//
//    @Transactional
//    public Cliente cadastrarCliente(ClienteDto clienteDto) {
//        Cliente cliente = new Cliente();
//        atualizarEntidade(cliente, clienteDto); // Preenche os dados
//        return clienteRepository.save(cliente);
//    }
//
//    private void atualizarEntidade(Cliente cliente, ClienteDto clienteDto) {
//        cliente.setNome(clienteDto.getNome());
//        cliente.setDataNascimento(clienteDto.getDataNascimento());
//        cliente.setGeneroEnum(clienteDto.getGeneroEnum());
//        cliente.setEndereco(clienteDto.getEndereco());
//        cliente.setEstadosBrasileirosEnum(clienteDto.getEstadosBrasileirosEnum());
//        cliente.setCpf(clienteDto.getCpf());
//        cliente.setEmail(clienteDto.getEmail());
//        cliente.setTelefone(clienteDto.getTelefone());
//        cliente.setReligiao(clienteDto.getReligiao());
//        cliente.setMedicamentos(clienteDto.getMedicamentos());
//        cliente.setQueixaPrincipal(clienteDto.getQueixaPrincipal());
//        cliente.setRecebeuAlta(clienteDto.getRecebeuAlta());
//    }
//
//    @Transactional
//    public Cliente atualizarCliente(Long id, ClienteDto clienteDto) {
//        Cliente cliente = clienteRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Cliente com o ID: " + id + "não foi encontrado"));
//        atualizarEntidade(cliente, clienteDto);
//        return clienteRepository.save(cliente);
//    }
//
//    @Transactional
//    public void deletarCliente(Long id) {
//        Cliente cliente = clienteRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Cliente com o ID: " + id + " não foi encontrado"));
//        clienteRepository.delete(cliente);
//    }
//}
