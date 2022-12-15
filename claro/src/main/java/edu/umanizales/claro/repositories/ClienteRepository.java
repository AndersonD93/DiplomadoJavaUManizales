package edu.umanizales.claro.repositories;

import edu.umanizales.claro.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nombre) = LOWER(:nombre)")
    public List<Cliente> buscarClientes(@Param("name") String name);

}
