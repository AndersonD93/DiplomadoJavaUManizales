package edu.umanizales.claro.repositories;

import edu.umanizales.claro.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteRepositoryImpl{

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findCliente(Cliente cliente){
        return clienteRepository.findAll(Example.of(cliente));
    }
}
