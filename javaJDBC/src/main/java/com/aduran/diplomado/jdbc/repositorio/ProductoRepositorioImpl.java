package com.aduran.diplomado.jdbc.repositorio;

import com.aduran.diplomado.jdbc.modelo.Categoria;
import com.aduran.diplomado.jdbc.modelo.Producto;
import com.aduran.diplomado.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

    private Connection getConnection() throws SQLException {
        return ConexionBaseDatos.getInstance();
    }

    private Producto crearObjetoProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setFechaRegistro(rs.getDate("fecha_registro"));
        Categoria categoria= new Categoria();
        categoria.setId(rs.getLong("categoria_id"));
        categoria.setNombre(rs.getString("categoria"));
        p.setCategoria(categoria);

        return p;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try {
            Statement stmt = getConnection().createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT p.*, c.nombre as categoria  FROM productos as p "+
            "INNER JOIN categorias as c ON (p.categoria_id = c.id)");
            {
                while (resultado.next()) {
                    Producto p = crearObjetoProducto(resultado);
                    productos.add(p);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;
        try (PreparedStatement stmt = getConnection().prepareStatement("SELECT p.*, c.nombre as categoria  FROM productos as p "+
                "INNER JOIN categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")) {
            stmt.setLong(1, id);
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    producto = crearObjetoProducto(resultado);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void guardar(Producto producto) {
        String sql;
        if (producto != null && producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre=?,precio=?,categoria_id=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre,precio,categoria_id,fecha_registro) VALUES (?,?,?,?)";
        }

        try (PreparedStatement stmt = getConnection().prepareStatement(sql)) {
            stmt.setString(1, producto.getNombre());
            stmt.setInt(2, producto.getPrecio());
            stmt.setLong(3,producto.getCategoria().getId());
            if (producto != null && producto.getId() != null && producto.getId() > 0) {
                stmt.setLong(4, producto.getId());

            } else {
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
            }
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {

        try (PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM productos WHERE id=?")) {

            stmt.setLong(1,id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    }

    /*
        try(Statement stmt = getConnection().createStatement();
            ResultSet rs= stmt.executeQuery("SELECT * FROM p.*, c.nombre as categoria FROM productos as p "+
                    "inner join categorias as c ON (p.categorias_id = c.id)")) {
        //SELECT productos.id , categorias.nombre  FROM productos  inner join categorias ON (productos.categoria_id = categorias.id)
            while (rs.next()){
                Producto p = crearProducto(rs);
                productos.add(p);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return productos;
    }

    @Override
    public Producto porId(Long id) {
        Producto producto = null;

        try(PreparedStatement stmt = getConnection().
                prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " +
                        "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")) {
            stmt.setLong(1,id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    producto = crearProducto(rs);
                }
            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return producto;

    }

    @Override
    public void guardar(Producto producto) {
        String sql;

        if ( producto.getId() != null && producto.getId()>0){
            sql="UPDATE productos SET nombre=?, precio=?, WHERE id=?";
        } else {
            sql="INSERT INTO productos(nombre,precio,categoria_id,fecha_registro) VALUES(?,?,?,?)";
        }
        try (PreparedStatement stmt = getConnection().prepareStatement(sql)){
            stmt.setString(1, producto.getNombre());
            stmt.setLong(2,producto.getPrecio());
            stmt.setLong(3,producto.getCategoria().getId());

            if (producto.getId() != null && producto.getId()>0){
                stmt.setLong(4,producto.getId());
            }else {
                stmt.setDate(4, new Date(producto.getFechaRegistro().getTime()));
            }
            stmt.executeUpdate();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }

    @Override
    public void eliminar(Long id) {
        try(PreparedStatement stmt= getConnection().prepareStatement("DELETE FROM productos WHERE id=?")){
            stmt.setLong(1,id);
            stmt.executeUpdate();
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }
    private Producto crearProducto(ResultSet rs) throws  SQLException {
        Producto p= new Producto();
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
}*/
