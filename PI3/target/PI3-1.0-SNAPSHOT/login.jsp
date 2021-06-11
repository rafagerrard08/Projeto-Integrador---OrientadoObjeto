
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title>BRMT</title>
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="jquery/jquery-3.6.0.min.js"></script>
	<script src="bootstrap/js/bootstrap.bundle.js"></script>
    <meta name="theme-color" content="#7952b3">
    <link href="css_login/login.css" rel="stylesheet">
    
    <script>
        <c:if test="${not empty msgErro}">
            $(document).ready(function() { 
                alert( "${msgErro}" );
            });
        </c:if>
        //GERENCIAMENTO DE SESSÃO (USADO COOKIES) 
        function getCookie(cookieName) {
            let cookie = {};
            document.cookie.split(';').forEach(function(el) {
                let [key,value] = el.split('=');
                cookie[key.trim()] = value;
          })
          return cookie[cookieName];
        }
        
        $(document).ready(function() {
            var coks = getCookie( "userID" );
            if( coks != null &&
                coks > 0 ){
                var url = "pagInicial.jsp";
                $(location).attr('href',url);
            }
        });
    </script>    
    
  </head>
<body class="text-center">    
    <main class="form-signin">
        <form action="/PI3/LoginServlet">
        <h1 class="h3 mb-3 fw-normal">Digite seu Usuario e Senha</h1>

        <div class="form-floating">
          <input type="text" class="form-control" id="USUARIO" name="USUARIO" placeholder="Usuario">
          <label for="floatingInput">Usuario</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control" id="SENHA" name="SENHA" placeholder="Senha">
          <label for="floatingPassword">Senha</label>
        </div>

        <div class="mb-3">
        </div>
        <button class="w-100 btn btn-lg btn-primary" type="submit">Entrar</button>
        <div class="mb-3">
        </div>
        <a href="registrar.jsp">Registrar</a>
        <p class="mt-5 mb-3 text-muted">© BRMT - todos os direitos reservados</p>
      </form>
    </main>
</body>
</html>