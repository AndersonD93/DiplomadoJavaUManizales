<%@page contentType="UTF-8" import="java.util.*, modelos.*"%>
<%
List<Requerimientos> requerimientos = (List<Requerimientos>) request.getAttribute("requerimientos");
Optional<String> username = (Optional<String>) request.getAttribute("username");
%>

<!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Listado de requerimientos</title>
        </head>
        <body>
        <h1>Listado de requerimientos</h1>
        <% if(username.isPresent()){%>
        <div>Hola <%=username.get()%>, bienvenido!</div>
        <p><a href="<%=request.getContextPath()%>/requerimientos/crear">crear [+]</a></p>
        <%}%>

        <table>
                <tr>
                        <th>id</th>
                        <th>cantidad</th>
                        <th>descripcion</th>
                        <th>fechaInicial</th>
                        <th>fechaFinal</th>
                        <th>precio</th>
                        <% if(username.isPresent()){%>
                        <th>eliminar</th>
                        <th>cerrar requerimiento</th>
                        <% } %>

                </tr>
                <% for(Requerimientos r: requerimientos){%>
                <tr>
                        <td><%=r.getId()%></td>
                        <td><%=r.getCantidad()%></td>
                        <td><%=r.getDescripcion()%></td>
                        <td><%=r.getFechaInicial()%></td>
                        <td><%=r.getFechaFinal()%></td>
                        <td><%=r.getPrecio()%></td>
                        <% if(username.isPresent()){%>
                        <td><a onclick="return confirm('esta seguro que desea eliminar?');"
                        href="<%=request.getContextPath()%>/requerimientos/eliminar?id=<%=r.getId()%>">eliminar</a></td>
                        <td><a onclick="return confirm('esta seguro que desea cerrar este requerimiento?');"
                        href="<%=request.getContextPath()%>/requerimientos/cerrar?id=<%=r.getId()%>">Cerrar requerimiento</a></td>
                        <% } %>
                </tr>
                <%}%>
        <p><a href="<%=request.getContextPath()%>/loginAdminSuccess">volver[<-]</a></p>

        </body>

        </html>