 

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
        <c:if test="${not empty produto}">
            <form action="AlterarProdutoServlet" method="POST">
                <label>Id do produto</label><br/>
                <input type="text" name="id_produto" hidden="true" value="${produto.id_produto}"/>
                <label>Id da loja</label><br/>
                <input type="text" name="id_loja" required="true" value="${produto.id_loja}"/><br/><br/>
                <label>Nome</label><br/>
                <input type="text" name="nome" required="true" value="${produto.nome}"/><br/><br/>
                <label>Quantidade do produto</label><br/>
                <input type="text" name="qtd_produto" required="true" value="${produto.qtd_produto}"/><br/><br/>
                <label>Valor</label><br/>
                <input type="text" name="valor" required="true" value="${produto.valor}"/><br/><br/>
                <label>Categoria</label><br/>
                <input type="text" name="categoria" required="true" value="${produto.categoria}"/><br/><br/>
                <label>Cor</label><br/>
                <input type="text" name="cor" required="true" value="${produto.cor}"/><br/><br/>
                <label>Marca</label><br/>
                <input type="text" name="marca" required="true" value="${produto.marca}" /><br/><br/>
                <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
            </c:if>
            <c:if test="${empty Produto}">
                <form action="CadastrarProdutosServlet" method="POST">                
                    <label class="form-label">Id do produto</label><br/>
                    <input type="text" name="id_produto" class="form-control" required="true"/> <br/><br/>
                    <label class="form-label">Id da loja</label><br/>
                    <input type="text" name="id_loja" class="form-control" required="true"/><br/><br/>
                    <label class="form-label">Nome</label><br/>
                    <input type="text" name="nome" class="form-control" required="true"/><br/><br/>
                    <label class="form-label">Quantidade de produto</label><br/>
                    <input type="text" name="qtd_produto" class="form-control" required="true"/><br/><br/>
                    <label class="form-label">Valor</label><br/>
                    <input type="text" name="valor" class="form-control" required/><br/><br/>
                    <label class="form-label">Categoria</label><br/>
                    <input type="text" name="categoria" class="form-control" required="true"/><br/><br/>
                    <label class="form-label">Cor</label><br/>
                    <input type="text" name="cor" class="form-control" required="true"/><br/><br/>
                    <label class="form-label">Marca</label><br/>
                    <input type="text" name="marca" class="form-control" required="true"/><br/><br/>

                    <button type="submit" class="btn btn-warning">Cadastrar</button>
                </form>
            </c:if>
            <c:import url="../footer.jsp"/>

    </body>
</html>
