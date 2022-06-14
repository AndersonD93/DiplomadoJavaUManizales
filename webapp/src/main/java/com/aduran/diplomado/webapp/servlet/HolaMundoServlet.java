package com.aduran.diplomado.webapp.servlet;

import jakarta.jws.WebService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hola-mundo")
public class HolaMundoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("</html>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Titulo Final</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hola Diplomado 1234</h1>");
        out.println("</body>");
        out.println("</html>");

    }

}
