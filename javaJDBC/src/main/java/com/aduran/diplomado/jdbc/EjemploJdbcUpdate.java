package com.aduran.diplomado.jdbc;

import com.aduran.diplomado.jdbc.modelo.Categoria;
import com.aduran.diplomado.jdbc.modelo.Producto;
import com.aduran.diplomado.jdbc.repositorio.ProductoRepositorioImpl;
import com.aduran.diplomado.jdbc.repositorio.Repositorio;
import com.aduran.diplomado.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {
        try (Connection con = ConexionBaseDatos.getInstance()){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= LISTAR =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============ Obtener por Id =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============ editar Producto ============");
            Producto producto = new Producto();
            producto.setId(5L);
            producto.setNombre("Teclado Cosair k95 mecanico");
            producto.setPrecio(700);
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto editado con exito");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
