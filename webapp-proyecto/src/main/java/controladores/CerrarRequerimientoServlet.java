package controladores;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Productos;
import servicios.ProductoServiceImp;
import util.JpaUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet("/requerimientos/cerrar")
public class CerrarRequerimientoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = JpaUtil.getEntityManager();
        ProductoServiceImp productoServiceImp= new ProductoServiceImp(em);

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e) {
            id = 0L;
        }
        List<Productos> productos = productoServiceImp.listar();
        List<BigDecimal> precios= new ArrayList<>();
        for(Productos p: productos){
            if (id==p.getIdReq()){
                precios.add(p.getPrecio());
            }
        }
        BigDecimal minimo= Collections.min(precios);
        Long idMin=0l;
        String nombreMin = null;
        for (Productos p1:productos){
            if(p1.getPrecio().equals(minimo)){
                idMin= p1.getId();
                nombreMin=p1.getNombre();
            }
        }
        req.setAttribute("minimo", minimo);
        req.setAttribute("idMin", idMin);
        req.setAttribute("nombreMin", nombreMin);
        getServletContext().getRequestDispatcher("/cerrarRequerimiento.jsp").forward(req, resp);



    }
}
