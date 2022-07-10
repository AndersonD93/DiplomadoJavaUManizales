package controladores;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Productos;
import modelos.Requerimientos;
import servicios.*;
import util.JpaUtil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/listarProductosProveedor")
public class ListarProductosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = JpaUtil.getEntityManager();
        EntidadServices<Productos> productosEntidadServices= new ProductoServiceImp(em);

        List<Productos> productosList = productosEntidadServices.listar();
        LoginService auth = new LoginServiceImpl();
        Optional<String> usernameOptional=auth.getUsername(req);

        req.setAttribute("productos",productosList);
        req.setAttribute("username",usernameOptional);
        getServletContext().getRequestDispatcher("/listarProductos.jsp").forward(req, resp);


    }


}
