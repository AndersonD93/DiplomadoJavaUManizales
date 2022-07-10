<%@page contentType="UTF-8" import="java.util.*, modelos.*"%>
<%
List<Requerimientos> requerimientos = (List<Requerimientos>) request.getAttribute("requerimientos");
Optional<String> username = (Optional<String>) request.getAttribute("usernameProv");
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
                        <th>acción</th>
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
                        <td><a onclick="return confirm('esta seguro que desea participar?');"
                        href="<%=request.getContextPath()%>/productos/crear?idReq=<%=r.getId()%>">ofertar</a></td>
                        <% } %>
                </tr>
                <%}%>
        <p><a href="<%=request.getContextPath()%>/loginProveedorSuccess">volver[<-]</a></p>

        </body>

        </html>