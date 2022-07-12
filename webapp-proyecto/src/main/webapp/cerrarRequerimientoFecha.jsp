<%@page contentType="text/html" pageEncoding="UTF-8"
import="java.util.*,java.time.format.*,modelos.*,java.math.*"%>
<%
List<BigDecimal> listpreciosMinimos = (List<BigDecimal>) request.getAttribute("listpreciosMinimos");
List<Long> listIdMin = (List<Long>) request.getAttribute("listIdMin");
List<String> listNombreMin = (List<String>) request.getAttribute("listNombreMin");
List<Productos> productosMinimos = (List<Productos>) request.getAttribute("productosMinimos");

%>
<!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Fin de Requerimiento</title>
        </head>
        <body>
        <h1>Fin de Requerimiento</h1>


                        <% for(Productos p: productosMinimos){%>
                        <div>El requerimiento con Id No. <%=p.getIdReq()%> se ha cerrado !</div>
                        <div>El producto con el precio mas competitivo es <%=p.getNombre()%> por una cantidad de <%=p.getCantidadOfertada()%> unidades</div>
                        <div>El precio final del requerimiento por unidad es <%=p.getPrecio()%> </div>
                        <div>------------------------------------------------------------------------------</div>
                        <% } %>


        <div>se ha enviado un correo con las ordenes de compra a los proveedores indicados.</div>

        <p><a href="<%=request.getContextPath()%>/loginAdminSuccess">volver[<-]</a></p>

        </body>

        </html>