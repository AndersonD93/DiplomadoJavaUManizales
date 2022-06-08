package com.aduran.diplomado.jdbc;

import com.aduran.diplomado.jdbc.modelo.Categoria;
import com.aduran.diplomado.jdbc.modelo.Producto;
import com.aduran.diplomado.jdbc.repositorio.ProductoRepositorioImpl;
import com.aduran.diplomado.jdbc.repositorio.Repositorio;
import com.aduran.diplomado.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.time.Clock;
import java.util.Date;

public class EjemploJDBC {

    public static void main(String[] args) {
        try (Connection con = ConexionBaseDatos.getInstance()){
            Repositorio<Producto> respositorio= new ProductoRepositorioImpl();
            System.out.println("======Listar======");
            respositorio.listar().forEach(System.out::println);
            System.out.println("======Obtener por ID======");
            System.out.println(respositorio.porId(7L));
            System.out.println("============ Insertar Nuevo Producto ============");
            Producto producto= new Producto();
            producto.setNombre("TV Qled");
            producto.setPrecio(450);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(1l);
            producto.setCategoria(categoria);
            respositorio.guardar(producto);
            respositorio.listar().forEach(System.out::println);



            /*Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= LISTAR =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============ Obtener por Id =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============ Insertar Nuevo Producto ============");
            Producto producto = new Producto();
            producto.setNombre("Teclado Razer mecanico");
            producto.setPrecio(550);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con exito");
            repositorio.listar().forEach(System.out::println);

             */
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
