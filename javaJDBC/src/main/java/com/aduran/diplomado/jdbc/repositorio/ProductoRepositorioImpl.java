package com.aduran.diplomado.jdbc.repositorio;

import com.aduran.diplomado.jdbc.modelo.Categoria;
import com.aduran.diplomado.jdbc.modelo.Producto;
import com.aduran.diplomado.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    public Connection conn;

    public ProductoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    public ProductoRepositorioImpl(){
    }
    public void setConn(Connection conn){
        this.conn=conn;
    }


    private Producto crearObjetoProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        Categoria categoria = new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);

        return p;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try (
                Statement stmt = conn.createStatement();
                ResultSet resultado = stmt.executeQuery("SELECT p.*, c.nombre as categoria  FROM productos as p " +
                        "INNER JOIN categorias as c ON (p.categoria_id = c.id)")) {
            while (resultado.next()) {
                Producto p = crearObjetoProducto(resultado);
                productos.add(p);
            }

        }
        return productos;

    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT p.*, c.nombre as categoria  FROM productos as p " +
                "INNER JOIN categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")) {
            stmt.setLong(1, id);
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    producto = crearObjetoProducto(resultado);
                }
            }
        }
        return producto;
    }

    @Override
    public Producto guardar(Producto producto) throws SQLException {
        String sql;
        if (producto != null && producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre=?,precio=?,categoria_id=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre,precio,categoria_id,sku,fecha_registro) VALUES (?,?,?,?,?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setLong(3, producto.getCategoria().getId());
            stmt.setString(4, producto.getSku());
            if (producto != null && producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(5, producto.getId());

            } else {
                stmt.setDate(5, new Date(producto.getFechaRegistro().getTime()));
            }
            stmt.executeUpdate();

            if (producto.getId() == null) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        producto.setId(rs.getLong(1));
                    }
                }
            }
            return producto;

        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {

        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHERE id=?")) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        }
    }
}
