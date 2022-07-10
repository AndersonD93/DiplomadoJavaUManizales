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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/requerimientos/crear")
public class CrearRequerimientosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = JpaUtil.getEntityManager();
        EntidadServices<Requerimientos> requerimientosEntidadServices= new RequerimientoServicesImp(em);

        Requerimientos requerimientos = new Requerimientos();
        req.setAttribute("requerimientos",requerimientos);
        getServletContext().getRequestDispatcher("/crearRequerimiento.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = JpaUtil.getEntityManager();
        EntidadServices<Requerimientos> requerimientosEntidadServices= new RequerimientoServicesImp(em);

        int cantidad;

        try {
            cantidad = Integer.parseInt(req.getParameter("cantidad"));
        } catch (NumberFormatException e){
            cantidad = 0;
        }


        String descripcion = req.getParameter("descripcion");
        String fechaIni = req.getParameter("fechaInicial");
        LocalDate fechaInicial;
        try {
            fechaInicial = LocalDate.parse(fechaIni, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            fechaInicial = null;
        }

        String fechaFin = req.getParameter("fechaFinal");
        LocalDate fechaFinal;
        try {
            fechaFinal = LocalDate.parse(fechaFin, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            fechaFinal = null;
        }

        BigDecimal precio;
        try {
            precio = BigDecimal.valueOf(Integer.valueOf(req.getParameter("precio")));
        } catch (NumberFormatException e){
            precio = BigDecimal.valueOf(0);
        }

        Map<String, String> errores = new HashMap<>();

        if (cantidad== 0) {
            errores.put("cantidad", "la cantidad es requerida!");
        }

        if (descripcion == null || descripcion.isBlank()){
            errores.put("descripcion", "la descripcion es requerido!");
        }
        if (fechaIni == null || fechaIni.isBlank()){
            errores.put("fecha-inicial", "la fecha inicial es requerida");
        }
        if (fechaFin == null || fechaFin.isBlank()){
            errores.put("fecha-final", "la fecha final es requerida");
        }
        if (precio.equals(0)) {
            errores.put("precio", "el precio es requerido!");
        }

        Requerimientos requerimientos = new Requerimientos();
        requerimientos.setCantidad(cantidad);
        requerimientos.setDescripcion(descripcion);
        requerimientos.setFechaInicial(fechaInicial);
        requerimientos.setFechaFinal(fechaFinal);
        requerimientos.setPrecio(precio);

        if (errores.isEmpty()) {
            requerimientosEntidadServices.guardar(requerimientos);
            resp.sendRedirect(req.getContextPath() + "/listarRequerimientos");
        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/crearRequerimiento.jsp").forward(req, resp);
        }


    }
}
