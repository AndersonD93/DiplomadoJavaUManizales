package controladores;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Requerimientos;
import servicios.EntidadServices;
import servicios.LoginService;
import servicios.LoginServiceImpl;
import servicios.RequerimientoServicesImp;
import util.JpaUtil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/listarRequerimientos")
public class ListarReqerimientosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = JpaUtil.getEntityManager();
        EntidadServices<Requerimientos> requerimientosEntidadServices= new RequerimientoServicesImp(em);

        List<Requerimientos>requerimientosList = requerimientosEntidadServices.listar();
        LoginService auth = new LoginServiceImpl();
        Optional<String> usernameOptional=auth.getUsername(req);

        req.setAttribute("requerimientos",requerimientosList);
        req.setAttribute("username",usernameOptional);
        getServletContext().getRequestDispatcher("/listarRequerimientos.jsp").forward(req, resp);

    }
}
