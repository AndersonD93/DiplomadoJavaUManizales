package edu.umanizales.claro.servlets;

import edu.umanizales.claro.dto.ClienteDTO;
import edu.umanizales.claro.entities.Cliente;
import edu.umanizales.claro.services.ClienteService;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

@WebServlet("/cliente")
public class ServletCliente extends HttpServlet {

    @Inject
    private ClienteService clienteService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IllegalAccessError {
        Long id = Long.parseLong(req.getParameter("id"));
        String nombre = req.getParameter("nombre");
        String cedula = req.getParameter("cedula");
        String celular = req.getParameter("celular");
        ClienteDTO clienteDTO = ClienteDTO.builder().id(id).cedula(cedula).nombre(nombre).celular(celular).build();
        Cliente cliente = null;
        try {
            cliente = clienteService.consultarCliente(clienteDTO);
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
        PrintWriter pw = resp.getWriter();
        pw.println(cliente.toString());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = req.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            throw new IOException("Error parsing JSON request string");
        }

        JsonReader jsonReader =  Json.createReader(new StringReader(jb.toString()));
        JsonObject jsonObject = jsonReader.readObject();

        String nombre = jsonObject.getString("nombre");
        String cedula = jsonObject.getString("cedula");
        String celular = jsonObject.getString("celular");

        ClienteDTO clienteDTO = ClienteDTO.builder().cedula(cedula).nombre(nombre).celular(celular).build();
        Cliente cliente = clienteService.guardarCliente(clienteDTO);
        PrintWriter pw = resp.getWriter();
        pw.println(cliente.toString());
    }

}
