package edu.umanizales.claro.services;

import edu.umanizales.claro.dto.ClienteDTO;
import edu.umanizales.claro.entities.Cliente;
import edu.umanizales.claro.entities.Enum.EnumEstado;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@Transactional
public class ClienteService implements IClienteService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cliente consultarCliente(ClienteDTO clienteDTO) throws IllegalAccessException {
        StringBuilder consulta = new StringBuilder("SELECT c FROM Cliente c");
        List<String> consultaLista = new ArrayList<>();

        for(Field field: ClienteDTO.class.getDeclaredFields()){
            field.setAccessible(Boolean.TRUE);
            if(field.get(clienteDTO) != null){
                consultaLista.add(" c." + field.getName() + " = " + field.get(clienteDTO));
            }
        }
        consulta.append( " WHERE " +  StringUtils.join(consultaLista," AND "));
        Query q = entityManager.createQuery(consulta.toString().replace("\"", "'"));

        return (Cliente)q.getSingleResult();
    }

    @Override
    public Cliente guardarCliente(ClienteDTO clienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        entityManager.persist(cliente);
        return cliente;
    }

    @Override
    public Cliente eliminarCliente(ClienteDTO clienteDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(clienteDTO, Cliente.class);
        cliente.setEstado(EnumEstado.INACTIVO);
        entityManager.persist(cliente);
        return cliente;
    }

    @Override
    public Cliente actualizarCliente(ClienteDTO clienteDTO) {
        return null;
    }


}
