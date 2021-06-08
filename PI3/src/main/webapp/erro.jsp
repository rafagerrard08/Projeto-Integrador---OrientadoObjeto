
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro!</title>
    </head>
    <body class="container">
        <c:import url="cabecalho.jsp"/>
        <br>
        <h3 style="color:red">Ops, algo deu errado!</h3>
        <p>${msgErro}</p>
        <br>
        <c:import url="rodape.jsp"/>
    </body>
</html>
