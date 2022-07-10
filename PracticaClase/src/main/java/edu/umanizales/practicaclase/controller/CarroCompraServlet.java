package edu.umanizales.practicaclase.controller;

import edu.umanizales.practicaclase.consultas.CarroCompraServiceImpl;
import edu.umanizales.practicaclase.entities.CarroCompras;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/carrosCompra")
public class CarroCompraServlet extends HttpServlet {

    @Inject
    CarroCompraServiceImpl consultasCarroCompras;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarroCompras cc = new CarroCompras();
        cc = consultasCarroCompras.almacenarCarrosCompra(cc);
        PrintWriter pw = resp.getWriter();
        //pw.println("<h1> Sevlet guardado </h1>");
        pw.println(cc.toString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        consultasCarroCompras.findCarrosCompra();
    }
}
