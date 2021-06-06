
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="lib/jquery-3.6.0.min.js"></script>
        <script type="text/javascript" src='bootstrap/js/bootstrap.min.js'></script>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="container-fluid">
            <a class="navbar-brand" href="#">BMRT</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
              <ul class="navbar-nav">
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Vendas
                  </a>
                  <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <li><a class="dropdown-item" href="cadastrar.jsp">Cadastrar</a></li>
                    <!--li><a class="dropdown-item" href="ClienteServlet">Lista</a></li-->
                    <li><a class="dropdown-item" href="VendaServlet">Listar</a></li>
                    <li><a class="dropdown-item" href="RelatorioVendaServlet">Relatórios</a></li>
                  </ul>
                </li>
              </ul>
            </div>
          </div>
        </nav>
    </body>
</html>
