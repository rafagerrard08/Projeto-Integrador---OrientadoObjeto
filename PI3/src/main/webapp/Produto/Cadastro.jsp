<%-- 
    Document   : Cadastro
    Created on : 06/06/2021, 19:26:58
    Author     : Bia
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produto</title>
	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="../jquery/jquery-3.6.0.min.js"></script>
	<script src="../bootstrap/js/bootstrap.bundle.js"></script>
    </head>
    <body class="container">
        <c:import url="../cabecalho.jsp"/>
        <br>
        <c:if test="${empty cliente}">
        <h3>Cadastro de Produto</h3>
        <br>
        <div class="border border-1 rounded">    
            <form class="p-4" action="/PI3/CadastrarProdutoServlet" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Loja</label>
                    <div class="col-sm-10">
                        <select class="form-select" id="loja" name="loja">
                                <c:forEach var="lj" items="${listaLoja}">
                                    <option value="${lj.id}">${lj.nome}</option>
                                </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Nome</label>
                    <div class="col-sm-10">
                        <input type="text" name="nome" required="true" class="form-control" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Quantidade</label>
                    <div class="col-sm-10">
                        <input type="text" name="qtd_produto" required="true" class="form-control" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Valor</label>
                    <div class="col-sm-10">
                        <input type="text" name="valor" required="true" class="form-control" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Categoria</label>
                    <div class="col-sm-10">
                        <select class="form-select" id="loja" name="id_categoria">
                                <c:forEach var="cat" items="${listaCategorias}">
                                    <option value="${cat.idBanco}">${cat.nome}</option>
                                </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Cor</label>
                    <div class="col-sm-10">
                        <input type="text" name="cor" required="true" class="form-control" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Marca</label>
                    <div class="col-sm-10">
                        <input type="text" name="marca" required="true" class="form-control" required/>
                    </div>
                </div>
                
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
        </c:if>
        <c:if test="${not empty cliente}">
        <h3>Alteração de Clientes</h3>
        <br>
        <div class="border border-1 rounded">    
            <form class="p-4" action="../AlterarProdutoServlet" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Id da loja</label>
                    <div class="col-sm-10">
                        <input type="text" name="id_loja" required="true" class="form-control" value="${produto.id_loja}" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Nome</label>
                    <div class="col-sm-10">
                        <input type="text" name="nome" required="true" class="form-control" value="${produto.nome}" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Quantidade</label>
                    <div class="col-sm-10">
                        <input type="text" name="qtd_produto" required="true" class="form-control" value="${produto.qtd_produto}" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Valor</label>
                    <div class="col-sm-10">
                        <input type="text" name="valor" required="true" class="form-control" value="${produto.valor}" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Categoria</label>
                    <div class="col-sm-10">
                        <input type="text" name="categoria" required="true" class="form-control" value="${produto.categoria}" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Cor</label>
                    <div class="col-sm-10">
                        <input type="text" name="cor" required="true" class="form-control" value="${produto.cor}" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Marca</label>
                    <div class="col-sm-10">
                        <input type="text" name="marca" required="true" class="form-control" value="${produto.marca}" required/>
                    </div>
                </div>

                <button type="submit" class="btn btn-primary">Atualizar</button>
            </form>            
        </div>
        </c:if>
        <br/>
        <br/>
    </body>
</html>
