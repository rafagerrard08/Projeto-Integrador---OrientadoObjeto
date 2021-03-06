<%-- 
    Document   : cabecalho
    Created on : 06/06/2021, 19:15:31
    Author     : Bia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="jquery/jquery-3.6.0.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.js"></script>
        <script>
            function getCookie(cookieName) {
                let cookie = {};
                document.cookie.split(';').forEach(function(el) {
                    let [key,value] = el.split('=');
                    cookie[key.trim()] = value;
              })
              return cookie[cookieName];
            }
            //FUNCAO PARA SE O USUARIO NAO ESTA LOGADO, SER REDIRECIONADO PARA A PAG DE LOGIN
            $(document).ready(function() {
                var coks = getCookie( "userID" );
                if( coks == null ||
                    coks <= 0 ){
                    var url = "login.jsp";
                    $(location).attr('href',url);
                }
            });
            //FUNCAO PARA LOGOUT 
            function logout(){
                document.cookie = "userID=; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
                var url = "login.jsp";
                $(location).attr('href',url);
            }
        </script>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-expand-md fixed-top navbar-light bg-light border-bottom">
              <div class="container-fluid">
                    <a class="navbar-brand" href="#">
                        <svg width="22" height="22" fill="currentColor" class="bi bi-bag" viewBox="0 0 16 16">
                            <path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z"/>
                        </svg>
                        BRMT
                    </a>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarCliente" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Cliente
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarCliente">
                                    <li><a class="dropdown-item" href="/PI3/Cliente/Cadastro.jsp">Cadastro</a></li>
                                    <li><a class="dropdown-item" href="/PI3/ListaClienteServlet">Listar</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarProduto" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Produto
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarProduto">
                                    <li><a class="dropdown-item" href="/PI3/CadastrarProdutoServlet">Cadastro</a></li>
                                    <li><a class="dropdown-item" href="/PI3/ListaProdutoServlet">Listar</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarVenda" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Venda
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarVenda">
                                    <li><a class="dropdown-item" href="/PI3/CadastrarVendaServlet">Registrar</a></li>
                                    <li><a class="dropdown-item" href="/PI3/ListaVendaServlet">Listar</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="/PI3/RelatorioServlet">Relatório</a></li>
                        </ul>
                        <div class="d-flex">
                            <button class="btn btn-outline-secondary" type="submit" onclick="logout()">Logout</button>
			</div>
                    </div>
              </div>
            </nav>
        </header>
        </br>
        </br>
        </br>
    </body>
</html>
