package controladores;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Productos;
import servicios.EntidadServices;
import servicios.ProductoServiceImp;
import util.JpaUtil;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/productos/eliminar")
public class EliminarProductoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = JpaUtil.getEntityManager();
        EntidadServices<Productos> productosEntidadServices = new ProductoServiceImp(em);

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        if (id > 0) {
            Optional<Productos> o = productosEntidadServices.porId(id);
            if (o.isPresent()) {
                productosEntidadServices.eliminar(id);
                resp.sendRedirect(req.getContextPath() + "/listarProductosProveedor");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el producto en la base de datos!");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id es null, se debe enviar como parametro en la url!");
        }

    }


}
