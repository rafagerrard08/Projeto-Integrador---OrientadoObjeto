<%-- 
    Document   : index
    Created on : Apr 9, 2021, 7:54:18 PM
    Author     : t735915
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciador de produto</title>
    </head>
    <body class="container">
        <c:import url="header.jsp"/>
        <br/>
        <h1 class= "d-inline p-0 bg-primary text-white">Menu</h1>
        <br/>
        <br/>
         <div class="btn btn-secondary-center">
            <a type="button" class="btn btn-lg bg-light" href="produtos/cadastrar.jsp">Cadastrar Produtos</a>
            <a type="button" class="btn btn-lg bg-light" href="ProdutosServlet">Listar Produtos</a>
                        
        </div>
    </body>