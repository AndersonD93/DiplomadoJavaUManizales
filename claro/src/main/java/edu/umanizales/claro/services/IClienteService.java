package edu.umanizales.claro.services;


import edu.umanizales.claro.dto.ClienteDTO;
import edu.umanizales.claro.entities.Cliente;

public interface IClienteService{

    public Cliente consultarCliente(ClienteDTO clienteDTO) throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException;

    public Cliente guardarCliente(ClienteDTO clienteDTO);

    public Cliente eliminarCliente(ClienteDTO clienteDTO);

    public Cliente actualizarCliente(ClienteDTO clienteDTO);
}
