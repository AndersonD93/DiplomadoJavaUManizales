package org.diplomado.testjpa;

import jakarta.persistence.EntityManager;
import org.diplomado.models.EquipoMovil;
import org.diplomado.services.EntidadServices;
import org.diplomado.services.EquipoMovilServicesImpl;
import org.diplomado.utils.Conexion;

import java.math.BigDecimal;
import java.util.List;

public class main {

    public static void main(String[] args) {
        EntityManager em = Conexion.getEntityManager();

        EntidadServices equipomovilservices = new EquipoMovilServicesImpl(em);
        EquipoMovil equipoMovil = new EquipoMovil();
        equipoMovil.setCantidad(5);
        equipoMovil.setPrecio(BigDecimal.valueOf(45.000));
        equipoMovil.setNombre("Telefono");
        equipoMovil.setMarca("Nokia");
        equipomovilservices.guardar(equipoMovil);
        System.out.println("====listar====");
        List<EquipoMovil> productos = equipomovilservices.listar();
        productos.forEach(System.out::println);
    }
}
