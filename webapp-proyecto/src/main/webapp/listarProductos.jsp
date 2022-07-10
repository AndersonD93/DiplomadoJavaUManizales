<%@page contentType="UTF-8" import="java.util.*, modelos.*"%>
<%
List<Productos> productos = (List<Productos>) request.getAttribute("productos");
Optional<String> username = (Optional<String>) request.getAttribute("username");
%>

<!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Listado de ofertas</title>
        </head>
        <body>
        <h1>Listado de productos ofertados</h1>
        <% if(username.isPresent()){%>
        <div>Hola <%=username.get()%>, bienvenido!</div>
        <p><a href="<%=request.getContextPath()%>/productos/crear">crear [+]</a></p>
        <%}%>
                <table>
                        <tr>
                                <th>id</th>
                                <th>cantidad ofertada</th>
                                <th>precio unitario</th>
                                <th>nombre</th>
                                <th>numero requerimiento</th>
                                <% if(username.isPresent() && username.get().equals("proveedor1")){%>
                                <th>eliminar</th>
                                <th>editar</th>
                                <% } %>

                        </tr>
                        <% for(Productos p: productos){%>
                                        <tr>
                                                <td><%=p.getId()%></td>
                                                <td><%=p.getCantidadOfertada()%></td>
                                                <td><%=p.getPrecio()%></td>
                                                <td><%=p.getNombre()%></td>
                                                <td><%=p.getIdReq()%></td>
                                                <% if(username.isPresent()&& username.get().equals("proveedor1")){%>
                                                <td><a onclick="return confirm('esta seguro que desea eliminar?');"
                                                href="<%=request.getContextPath()%>/productos/eliminar?id=<%=p.getId()%>">eliminar</a></td>
                                                <td><a href="<%=request.getContextPath()%>/productos/crear?id=<%=p.getId()%>">editar</a></td>
                                                <% } %>
                                        </tr>
                                        <%}%>
                </table>

                        <p><a href="<%=request.getContextPath()%>/loginProveedorSuccess">volver[<-]</a></p>

        </body>

</html>

