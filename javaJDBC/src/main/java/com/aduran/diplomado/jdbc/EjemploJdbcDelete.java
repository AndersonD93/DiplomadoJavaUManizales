package com.aduran.diplomado.jdbc;

import com.aduran.diplomado.jdbc.modelo.Producto;
import com.aduran.diplomado.jdbc.repositorio.ProductoRepositorioImpl;
import com.aduran.diplomado.jdbc.repositorio.Repositorio;
import com.aduran.diplomado.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {
    public static void main(String[] args) {
        try (Connection con = ConexionBaseDatos.getInstance()){
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("============= LISTAR =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============ Obtener por Id =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============ Eliminar Producto ============");
            repositorio.eliminar(3L);
            System.out.println("Producto eliminado con exito");
            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
