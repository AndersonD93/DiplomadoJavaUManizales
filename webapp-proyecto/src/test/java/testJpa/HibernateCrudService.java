package testJpa;


import jakarta.ejb.Local;
import jakarta.persistence.EntityManager;
import modelos.Productos;
import modelos.Requerimientos;
import servicios.EntidadServices;
import servicios.ProductoServiceImp;
import servicios.RequerimientoServicesImp;
import util.JpaUtil;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class HibernateCrudService {

    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        ProductoServiceImp productoServiceImp= new ProductoServiceImp(em);

        System.out.println("====listar====");
        List<Productos> productos = productoServiceImp.listar();
        productos.forEach(System.out::println);
        int idRequerimiento=2;
        List<BigDecimal> precios= new ArrayList<>();
        for(Productos p: productos){
            if (idRequerimiento==p.getIdReq()){
                precios.add(p.getPrecio());
            }
        }
        BigDecimal minimo=Collections.min(precios);
        Long idMin=0l;
        String nombreMin = null;
        for (Productos p1:productos){
            if(p1.getPrecio().equals(minimo)){
                idMin= p1.getId();
                nombreMin=p1.getNombre();
            }
        }
        System.out.println(minimo);
        System.out.println(idMin);
        System.out.println(nombreMin);




        /*
        ProductoServiceImp productoServiceImp= new ProductoServiceImp(em);

        System.out.println("====listar====");
        List<Productos> productos = productoServiceImp.listar();
        productos.forEach(System.out::println);

        System.out.println("=====Por Id=====");
        Optional<Productos> optionalProductos= productoServiceImp.porId(2L);
        optionalProductos.ifPresent(System.out::println);

        System.out.println("====Insertar nuevo producto====");
        Productos p = new Productos();
        p.setNombre("nanoQled2");
        p.setPrecio(BigDecimal.valueOf(3800000));
        productos = productoServiceImp.listar();
        productos.forEach(System.out::println);


        productoServiceImp.guardar(p);
        System.out.println("cliente guardado con exito");

        System.out.println("====editar producto=====");
        Long id = p.getId();
        optionalProductos = productoServiceImp.porId(id);
        optionalProductos.ifPresent(pr->{
            p.setPrecio(BigDecimal.valueOf(6000000));
            productoServiceImp.guardar(pr);
            System.out.println("cliente editado con exito");
            List<Productos> productos1 = productoServiceImp.listar();
            productos1.forEach(System.out::println);

        });

        System.out.println("====eliminar producto====");
        id=p.getId();
        optionalProductos=productoServiceImp.porId(id);
        optionalProductos.ifPresent(pr->{
            productoServiceImp.eliminar(pr.getId());
        });
        System.out.println("Producto eliminado con exito");


        System.out.println("=====crear nuevo requerimiento");
        RequerimientoServicesImp rs = new RequerimientoServicesImp(em);
        Requerimientos nuevoReq = new Requerimientos();

        nuevoReq.setDescripcion("Nuevo Requerimiento7");
        nuevoReq.setPrecio(BigDecimal.valueOf(9500000));
        nuevoReq.setFechaInicial(LocalDate.parse("2022-06-29"));
        nuevoReq.setFechaFinal(LocalDate.parse("1922-06-30"));
        rs.guardar(nuevoReq);

        List<Requerimientos> requerimientosList=rs.listar();
        requerimientosList.forEach(System.out::println);
        */

        em.close();

    }
}
