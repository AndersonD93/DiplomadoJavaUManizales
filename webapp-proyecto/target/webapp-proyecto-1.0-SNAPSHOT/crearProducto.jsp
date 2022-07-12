<%@page contentType="text/html" pageEncoding="UTF-8"
import="java.util.*,java.time.format.*,modelos.*,java.math.*"%>
<%
Map
<String, String> errores = (Map
<String, String>) request.getAttribute("errores");
Productos productos= (Productos) request.getAttribute("productos");
Long idReq= (Long) request.getAttribute("idReq");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario crear productos a ofertar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<h1>Formulario productos</h1>
    <form action="<%=request.getContextPath()%>/productos/crear" method="post">

    <div>
            <label for="cantidadOfertada">cantidad ofertada</label>
            <div>
                <input type="number" name="cantidadOfertada" id="cantidadOfertada" value="">
            </div>
            <% if(errores != null && errores.containsKey("cantidadOfertada")){%>
            <div style="color:red;"><%=errores.get("cantidadOfertada")%></div>
            <% } %>
    </div>

    <div>
            <label for="precioOfertado">Precio ofertado</label>
            <div>
                <input type="number" name="precioOfertado" id="precioOfertado" value="">
            </div>
            <% if(errores != null && errores.containsKey("precioOfertado")){%>
            <div style="color:red;"><%=errores.get("precioOfertado")%></div>
            <% } %>
    </div>
    <div>
            <label for="nombre">Nombre Producto</label>
    <div>
                <input type="text" name="nombre" id="nombre" value="">
            </div>
            <% if(errores != null && errores.containsKey("nombre")){%>
            <div style="color:red;"><%=errores.get("nombre")%></div>
            <% } %>
    </div>

    <div>
                <label for="idReq">Id Requerimiento</label>
                <div>
                    <input type="number" name="idReq" id="idReq" value="<%=idReq%>">
                </div>
               
        </div>



    <div><input type="submit" value="Enviar"></div>
        <input type="hidden" name="id" >
    </form>

     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
    </html>


