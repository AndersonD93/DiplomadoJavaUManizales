<%@page contentType="text/html" pageEncoding="UTF-8"
import="java.util.*,java.time.format.*,modelos.*,java.math.*"%>
<%
Map
<String, String> errores = (Map
<String, String>) request.getAttribute("errores");
Requerimientos requerimientos= (Requerimientos) request.getAttribute("requerimientos");
String fechaIni = requerimientos.getFechaInicial() != null?
requerimientos.getFechaInicial().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")): "";
String fechaFin = requerimientos.getFechaFinal() != null?
requerimientos.getFechaFinal().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")): "";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario crear requerimientos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<h1>Formulario requerimientos</h1>
<form action="<%=request.getContextPath()%>/requerimientos/crear" method="post">

    <div>
            <label for="cantidad">cantidad</label>
            <div>
                <input type="number" name="cantidad" id="cantidad" value="">
            </div>
            <% if(errores != null && errores.containsKey("cantidad")){%>
            <div style="color:red;"><%=errores.get("cantidad")%></div>
            <% } %>
    </div>

    <div>
        <label for="descripcion">descripcion</label>
        <div>
            <input type="text" name="descripcion" id="descripcion" value="<%=requerimientos.getDescripcion() != null? requerimientos.getDescripcion(): ""%>">
        </div>
        <% if(errores != null && errores.containsKey("descripcion")){%>
        <div style="color:red;"><%=errores.get("descripcion")%></div>
        <% } %>
    </div>

    <div>
        <label for="fechaInicial">Fecha Registro</label>
        <div>
            <input type="date" name="fechaInicial" id="fechaInicial" value="<%=fechaIni%>">
        </div>
        <% if(errores != null && errores.containsKey("fechaInicial")){%>
        <div style="color:red;"><%=errores.get("fechaInicial")%></div>
        <% } %>
    </div>

    <div>
        <label for="fechaFinal">Fecha Registro</label>
        <div>
            <input type="date" name="fechaFinal" id="fechaFinal" value="<%=fechaFin%>">
        </div>
        <% if(errores != null && errores.containsKey("fechaFinal")){%>
        <div style="color:red;"><%=errores.get("fechaInicial")%></div>
        <% } %>
    </div>

    <div>
        <label for="precio">Precio Unitario</label>
        <div>
            <input type="number" name="precio" id="precio" value="">
        </div>
        <% if(errores != null && errores.containsKey("precio")){%>
        <div style="color:red;"><%=errores.get("precio")%></div>
        <% } %>
    </div>

    <div><input type="submit" value="Enviar"></div>
    <input type="hidden" name="id" >
</form>

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>