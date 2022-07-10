<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Api Requerimientos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


</head>

    <body>
    <h1>Login Administrador</h1>

    <form action="/webapp-proyecto/loginEmpresa" method="post">
      <div class="mb-3">
      <debugger>
        <label for="username" class="form-label">Nombre Administrador</label>
        <div>
          <input type="text" name="username" id="username" class="form-control">
        </div>
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">Contraseña</label>
        <div>
          <input type="password" name="password" id="password" class="form-control">
        </div>
      </div>
      <div>
        <input type="submit" value="Login">
      </div>
    </form>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>

</html>