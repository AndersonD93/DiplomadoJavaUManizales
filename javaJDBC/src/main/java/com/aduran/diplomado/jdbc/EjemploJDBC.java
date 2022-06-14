package com.aduran.diplomado.jdbc;

import com.aduran.diplomado.jdbc.modelo.Categoria;
import com.aduran.diplomado.jdbc.modelo.Producto;
import com.aduran.diplomado.jdbc.repositorio.CategoriaRepositorioImpl;
import com.aduran.diplomado.jdbc.repositorio.ProductoRepositorioImpl;
import com.aduran.diplomado.jdbc.repositorio.Repositorio;
import com.aduran.diplomado.jdbc.servicio.CatalogoServicio;
import com.aduran.diplomado.jdbc.servicio.Servicio;
import com.aduran.diplomado.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.time.Clock;
import java.util.Date;

public class EjemploJDBC {

    public static void main(String[] args) throws SQLException {

        Servicio servicio = new CatalogoServicio();
        System.out.println("========Listar==========");
        servicio.listar().forEach(System.out::println);
        Categoria categoria = new Categoria();
        categoria.setNombre("Iluminación");

        Producto producto = new Producto();
        producto.setNombre("Lampara led");
        producto.setPrecio(990);
        producto.setFechaRegistro(new Date());
        producto.setSku("abcdf12");
        servicio.guardarProductoConCategoria(producto,categoria);
        System.out.println("Producto guardado con exito: "+ producto.getId());
        servicio.listar().forEach(System.out::println);

        }

    }

        /*try (Connection con = ConexionBaseDatos.getConnection()) {
            if (con.getAutoCommit()) {
                con.setAutoCommit(false);
            }
            try {
                Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(con);
                System.out.println("======Insertar nueva categoria ======");
                Categoria categoria = new Categoria();
                categoria.setNombre("Papeleria");
                Categoria nuevaCategoria = repositorioCategoria.guardar(categoria);
                System.out.println("Categoria guardada con exito: " + nuevaCategoria.getId());


                Repositorio<Producto> respositorio = new ProductoRepositorioImpl(con);
                System.out.println("======Listar======");
                respositorio.listar().forEach(System.out::println);

                System.out.println("======Obtener por ID======");
                System.out.println(respositorio.porId(7L));

                System.out.println("============ Insertar Nuevo Producto ============");
                Producto producto = new Producto();
                producto.setNombre("RefrigeradorLG");
                producto.setPrecio(5350);
                producto.setFechaRegistro(new Date());
                producto.setSku("12345c");

                producto.setCategoria(nuevaCategoria);
                respositorio.guardar(producto);
                System.out.println("Producto guardado con exito : " + producto.getId());
                respositorio.listar().forEach(System.out::println);

                con.commit();

            } catch (SQLException e) {
                con.rollback();
                e.printStackTrace();
            }
        }

         */


