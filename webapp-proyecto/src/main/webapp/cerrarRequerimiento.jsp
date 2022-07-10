<%@page contentType="text/html" pageEncoding="UTF-8"
import="java.util.*,java.time.format.*,modelos.*,java.math.*"%>
<%
BigDecimal minimo= (BigDecimal) request.getAttribute("minimo");
Long idMin=(Long) request.getAttribute("idMin");
String nombreMin= (String) request.getAttribute("nombreMin");
%>

<!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Fin de Requerimiento</title>
        </head>
        <body>
        <h1>Fin de Requerimiento</h1>
        <div>La orden minima corresponde al id <%=idMin%> del producto <%=nombreMin%>, cuyo precio es <%=minimo%> !</div>

        <div>se ha enviado un correo con la orden de compra al proveedor indicado.</div>

        <p><a href="<%=request.getContextPath()%>/loginAdminSuccess">volver[<-]</a></p>

        </body>

        </html>