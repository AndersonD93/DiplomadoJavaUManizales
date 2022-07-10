package controladores;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Requerimientos;
import servicios.EntidadServices;
import servicios.RequerimientoServicesImp;
import util.JpaUtil;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/requerimientos/eliminar")
public class EliminarRequerimientoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = JpaUtil.getEntityManager();
        EntidadServices<Requerimientos> requerimientosEntidadServices = new RequerimientoServicesImp(em);

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        if (id > 0) {
            Optional<Requerimientos> o = requerimientosEntidadServices.porId(id);
            if (o.isPresent()) {
                requerimientosEntidadServices.eliminar(id);
                resp.sendRedirect(req.getContextPath()+ "/listarRequerimientos");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el requerimiento en la base de datos!");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Error el id es null, se debe enviar como parametro en la url!");
        }


    }
}
