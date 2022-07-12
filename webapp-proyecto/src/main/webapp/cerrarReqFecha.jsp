<%@page contentType="UTF-8" import="java.util.*, modelos.*,java.time.*"%>
<%
Optional<String> username = (Optional<String>) request.getAttribute("username");
%>

<!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Cerrar Requerimientos por fecha</title>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        </head>
        <body>
        <h1>Formulario para cerrar requerimiento por fecha</h1>
        <% if(username.isPresent()){%>
                <div>Hola <%=username.get()%>, bienvenido!</div>
                <%}%>

        <form action="<%=request.getContextPath()%>/requerimientos/cerrarFecha" method="post">

        <div>
                <label for="fechaActual">Fecha Actual</label>
                <div>
                    <input type="date" name="fechaActual" id="fechaActual" value="">
                </div>
        </div>
        <div><input type="submit" value="Enviar"></div>
            <input type="hidden" name="id" >
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>





        </body>
        </html>

