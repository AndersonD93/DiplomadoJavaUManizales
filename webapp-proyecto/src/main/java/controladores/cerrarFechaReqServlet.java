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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@WebServlet("/requerimientos/cerrarFecha")
public class cerrarFechaReqServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImpl();
        Optional<String> usernameOptional=auth.getUsername(req);
        req.setAttribute("username",usernameOptional);
        getServletContext().getRequestDispatcher("/cerrarReqFecha.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = JpaUtil.getEntityManager();
        EntidadServices<Requerimientos> requerimientosEntidadServices= new RequerimientoServicesImp(em);
        List<Requerimientos> requerimientosList= requerimientosEntidadServices.listar();
        List<Requerimientos> requerimientosCerrar= new ArrayList<>();
        ProductoServiceImp productoServiceImp= new ProductoServiceImp(em);

        LocalDate fechaParse;
        try {
            fechaParse = LocalDate.parse((req.getParameter("fechaActual")));
        } catch (NumberFormatException e) {
            fechaParse = LocalDate.now();
        }

        for(Requerimientos requerimientos: requerimientosList){
            LocalDate fechareq=requerimientos.getFechaFinal();
            if(fechareq.isBefore(fechaParse) || fechareq.isEqual(fechaParse)){
                requerimientosCerrar.add(requerimientos);
            }
        }
        List<Long> listIdcerrar= new ArrayList<>();
        for (Requerimientos requi: requerimientosCerrar){
            listIdcerrar.add(requi.getId());
        }
        List<Productos> productos = productoServiceImp.listar();
        List<BigDecimal> precios= new ArrayList<>();
        List<Productos> productosMinimos= new ArrayList<>();
        Productos productoMinimo=null;

        List<Long> idlist = new ArrayList<>();
        for(Long id:listIdcerrar){
            List<Productos>productos2=new ArrayList<>();
            for(Productos p: productos){
                if (id==p.getIdReq()){
                    productos2.add(p);
                    idlist.add(p.getId());
                    precios.add(p.getPrecio());
                }
            }
            BigDecimal precioMinimo=productos2.get(0).getPrecio();
            productoMinimo=productos2.get(0);

            for (Productos p2:productos2){
                BigDecimal precioActual=p2.getPrecio();

                if(precioActual.min(precioMinimo)!=precioMinimo){
                    productoMinimo=p2;
                }
            }
            productosMinimos.add(productoMinimo);

        }

        req.setAttribute("productosMinimos", productosMinimos);
        getServletContext().getRequestDispatcher("/cerrarRequerimientoFecha.jsp").forward(req, resp);

    }
}
