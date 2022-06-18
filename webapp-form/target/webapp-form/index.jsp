<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%
    Map<String, String> errores = (Map<String, String>request.getAttribute("errores");
%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Formulario de Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  </head>
  <body>
    <h3>Formulario de usuarios</h3>

  <%if(errores != null && errores.size()>0{
  %>
  <ul class="alert alert-danger mx-5 px-5">
  <%for (String error: errores.values()){%>
  <li><%=error%></li>
  <%}%]
  <div class="px-5">
  <form action="/webapp-form/registro" method="post">

    <div class="row mb-3">
    <label for="username" class="col-form-label col-sm-2">Usuario </label>
    <div class="col-sm-4">
        <input type="text" name="username" id="username" class="form-control" value="${param.username}">
    </div>

    </div>
        <%
        if(errores !=null && errores.containsKey("username")){
           out.println("<div class='row mb-3 alert-danger col-sm-4' style='color:red;'>"+ errores.get("username")+"</div>");
        }
        %>
    <div class="row mb-3">
        <label for="password" class="col-form-label col-sm-2">Password </label>
        <div class="col-sm-4"><input type="password" name="password" id="password" class="form-control"></div>
        </div>
            <%
            if(errores !=null && errores.containsKey("password")){
               out.println("<small class='alert-danger col-sm-4' style='color:red;'>"+ errores.get("password")+"</small>");
            }
            %>
    <div class="row mb-3">
            <label for="email" class="col-form-label col-sm-2">Email</label>
            <div class="col-sm-4"><input type="text" name="email" id="email" class="form-control" value="${param.email}"></div>
            </div>
                <%
                if(errores !=null && errores.containsKey("emial")){
                   out.println("<small class='alert-danger col-sm-4' style='color:red;'>"+ errores.get("email")+"</small>");
                }
                %>
    <div class="row mb-3">
            <label for="pais" class="col-form-label col-sm-2">Pais</label>
            <div class="col-sm-4">
            <select name="pais" id="pais" class="form-select">
                <option value="">-- Seleccionar --</option>
                <option value="ES">${param.pais.equals("ES")?"selected": ""}>España</option>
                <option value="MX">${param.pais.equals("MX")?"selected": ""}>México</option>
                <option value="CL">${param.pais.equals("CL")?"selected": ""}>Chile</option>
                <option value="AR">${param.pais.equals("AR")?"selected": ""}>Argentina</option>
                <option value="PE">${param.pais.equals("PE")?"selected": ""}>Perú</option>
                <option value="CO">${param.pais.equals("CO")?"selected": ""}>Colombia</option>
                <option value="VE">${param.pais.equals("VE")?"selected": ""}>Venezuela</option>
            </select>
            </div>
                <%
                    if(errores !=null && errores.containsKey("pais")){
                       out.println("<small class='alert-danger col-sm-4' style='color:red;'>"+ errores.get("email")+"</small>");
                       }
                %>





    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
  </body>
</html>