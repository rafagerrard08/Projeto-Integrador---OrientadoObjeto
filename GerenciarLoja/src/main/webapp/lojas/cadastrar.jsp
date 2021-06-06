

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
    </head>
    <body class="container">
        <c:import url="../header.jsp"/>
        <c:if test="${not empty loja}">
            <form action="AlterarLojaServlet" method="POST">
                <label>Id da loja</label><br/>
                <input type="text" name="id_loja" required="true" value="${loja.id_loja}"/><br/><br/>
                <label>Nome</label><br/>
                <input type="text" name="nome_loja" required="true" value="${loja.nome_loja}"/><br/><br/>
                <label>Tipo de Loja</label><br/>
                <input type="text" name="tipo_loja" required="true" value="${loja.tipo_loja}"/><br/><br/>
                <label>Valor</label><br/>
                <input type="text" name="endereco" required="true" value="${loja.endereco}"/><br/><br/>
                <label>Telefone</label><br/>
                <input type="text" name="telefone" required="true" value="${loja.telefone}"/><br/><br/>
                <label>Cliente</label><br/>
                <input type="text" name="id_cliente" required="true" value="${loja.id_cliente}"/><br/><br/>
                <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            </c:if>
            <c:if test="${empty loja}">
                <form action="CadastrarLojaServlet" method="POST">                
                <label>Id da loja</label><br/>
                <input type="text" name="id_loja" required="true" value="${loja.id_loja}"/><br/><br/>
                <label>Nome</label><br/>
                <input type="text" name="nome_loja" required="true" value="${loja.nome_loja}"/><br/><br/>
                <label>Tipo de Loja</label><br/>
                <input type="text" name="tipo_loja" required="true" value="${loja.tipo_loja}"/><br/><br/>
                <label>Valor</label><br/>
                <input type="text" name="endereco" required="true" value="${loja.endereco}"/><br/><br/>
                <label>Telefone</label><br/>
                <input type="text" name="telefone" required="true" value="${loja.telefone}"/><br/><br/>
                <label>Id cliente</label><br/>
                <input type="text" name="id_cliente" required="true" value="${loja.id_cliente}"/><br/><br/>
                    <button type="submit" class="btn btn-warning">Cadastrar</button>
                </form>
            </c:if>
            <c:import url="../footer.jsp"/>

    </body>
</html>
