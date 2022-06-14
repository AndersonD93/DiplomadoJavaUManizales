package com.aduran.diplomado.jdbc.repositorio;

import com.aduran.diplomado.jdbc.modelo.Categoria;
import com.aduran.diplomado.jdbc.modelo.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements  Repositorio<Categoria> {

    public Connection conn;

    public CategoriaRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    public  CategoriaRepositorioImpl(){
    }

    private Categoria crearCategoria (ResultSet rs) throws SQLException {
        Categoria c = new Categoria();

        c.setId(rs.getLong("id"));
        c.setNombre(rs.getString("nombre"));

        return c;
    }

    @Override
    public void setConn(Connection conn) {
        this.conn= conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        try (
                Statement stmt = conn.createStatement();
                ResultSet resultado = stmt.executeQuery("SELECT * FROM categorias")) {
            while (resultado.next()) {
                Categoria c = crearCategoria(resultado);
                categorias.add(c);
            }

        }
        return categorias;

    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM categorias as c WHERE c.id=? ")) {
            stmt.setLong(1, id);
            try (ResultSet resultado = stmt.executeQuery()) {
                if (resultado.next()) {
                    categoria = crearCategoria(resultado);
                }
            }
        }
        return categoria;
    }

    @Override
    public Categoria guardar(Categoria categoria) throws SQLException {
        String sql;
        if (categoria != null && categoria.getId() != null && categoria.getId() > 0) {
            sql = "UPDATE categorias SET nombre=? WHERE id=?";
        } else {
            sql = "INSERT INTO categorias(nombre) VALUES (?)";
        }

        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, categoria.getNombre());

            if (categoria != null && categoria.getId() != null && categoria.getId() > 0) {
                stmt.setLong(2, categoria.getId());

            }
            stmt.executeUpdate();

            if (categoria.getId() == null) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        categoria.setId(rs.getLong(1));
                    }
                }
            }
            return categoria;

        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {

        try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM categorias WHERE id=?")) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        }
    }


}
