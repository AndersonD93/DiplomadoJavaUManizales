package controladores;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Productos;
import modelos.Requerimientos;
import servicios.EntidadServices;
import servicios.ProductoServiceImp;
import servicios.RequerimientoServicesImp;
import util.JpaUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/productos/crear")
public class CrearProductosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = JpaUtil.getEntityManager();
        EntidadServices<Productos> productosEntidadServices= new ProductoServiceImp(em);

        Productos productos = new Productos();
        req.setAttribute("productos",productos);
        getServletContext().getRequestDispatcher("/crearProducto.jsp").forward(req, resp);

        long id;
        try {
            id = Long.parseLong(req.getParameter("id"));
        } catch (NumberFormatException e){
            id = 0L;
        }

        if (id > 0) {
            Optional<Productos> o = productosEntidadServices.porId(id);
            if (o.isPresent()) {
                productos = o.get();
            }
        }

        req.setAttribute("productos", productos);
        getServletContext().getRequestDispatcher("/crearProducto.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManager em = JpaUtil.getEntityManager();
        EntidadServices<Productos> productosEntidadServices= new ProductoServiceImp(em);

        int cantidadOfertada;

        try {
            cantidadOfertada = Integer.parseInt(req.getParameter("cantidadOfertada"));
        } catch (NumberFormatException e){
            cantidadOfertada = 0;
        }


        BigDecimal precioOfertado;
        try {
            precioOfertado = BigDecimal.valueOf(Integer.valueOf(req.getParameter("precioOfertado")));
        } catch (NumberFormatException e){
            precioOfertado = BigDecimal.valueOf(0);
        }

        String nombre = req.getParameter("nombre");

        int idReq;

        try {
            idReq = Integer.parseInt(req.getParameter("idReq"));
        } catch (NumberFormatException e){
            idReq = 0;
        }

        Map<String, String> errores = new HashMap<>();

        if (cantidadOfertada== 0) {
            errores.put("cantidad", "la cantidad es requerida!");
        }

        if (precioOfertado.equals(0)) {
            errores.put("precio", "el precio es requerido!");
        }

        if (nombre == null || nombre.isBlank()){
            errores.put("nombre", "el nombre es requerido!");
        }

        if (idReq== 0) {
            errores.put("idReq", "idReq es requerido!");
        }

        Productos productos = new Productos();
        productos.setCantidadOfertada(cantidadOfertada);
        productos.setPrecio(precioOfertado);
        productos.setNombre(nombre);
        productos.setIdReq(idReq);


        if (errores.isEmpty()) {
            productosEntidadServices.guardar(productos);
            resp.sendRedirect(req.getContextPath() + "/listarProductosProveedor");
        } else {
            req.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/crearProducto.jsp").forward(req, resp);
        }

    }
}
