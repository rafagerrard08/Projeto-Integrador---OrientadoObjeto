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
        <title>Registrar Venda</title>
	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="../jquery/jquery-3.6.0.min.js"></script>
	<script src="../bootstrap/js/bootstrap.bundle.js"></script>
    <script>
        
        function setValorProduto( prod ){
            <c:forEach var="teste" items="${listaProdutos}">  
                    if( '${teste.id_produto}' == prod.value ){
                        var valorProd = '${teste.valor}';
                        document.getElementById('valor_produto').value = valorProd;
                    }
            </c:forEach>
        }
        
        function mudouLoja( loja ){
            window.location.href = "/PI3/CadastrarVendaServlet?ID_LOJA=" +loja.value;
        }
        
    </script>
    </head>
    <body class="container">
        <c:import url="../cabecalho.jsp"/>
        <br>
        <h3>Registro de Venda</h3>
        <br>
        <div class="border border-1 rounded">    
            <form class="p-4" action="/PI3/CadastrarVendaServlet" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Nome vendedor</label>
                    <div class="col-sm-10">
                        <input type="text" name="nomeVendedor" required="true" class="form-control" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Cliente</label>
                    <div class="col-sm-2">
                        <select class="form-select" name="cliente">
                                <c:forEach var="cli" items="${listaClientes}">
                                    <option value="${cli.idBanco}">${cli.nome}</option>
                                </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Loja</label>
                    <div class="col-sm-2">
                        <select class="form-select" name="loja" onchange="mudouLoja( this )">
                                <c:forEach var="lj" items="${listaLoja}">
                                    <c:choose>
                                        <c:when test="${lj.id == param.ID_LOJA}">
                                            <option value="${lj.id}" selected>${lj.nome}</option>
                                        </c:when>    
                                        <c:otherwise>
                                            <option value="${lj.id}">${lj.nome}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Produto</label>
                    <div class="col-sm-2">
                        <select class="form-select" name="produto" onchange="setValorProduto( this )">
                                <c:forEach var="prod" items="${listaProdutos}">
                                    <option value="${prod.id_produto}">${prod.nome}</option>
                                </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Valor</label>
                    <div class="col-sm-10">
                        <c:if test="${not empty listaProdutos}">
                            <input type="text" id="valor_produto" name="valor_produto" required="true" class="form-control" value="${listaProdutos[ 0 ].valor}" readonly/>
                        </c:if>
                        <c:if test="${empty listaProdutos}">
                            <input type="text" id="valor_produto" name="valor_produto" required="true" class="form-control" readonly/>
                        </c:if>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Desconto</label>
                    <div class="col-sm-10">
                        <input type="text" name="desconto" required="true" class="form-control" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Forma de pagamento</label>
                    <div class="col-sm-10">
                        <select class="form-select" name="formas_pgto" >
                                <c:forEach var="formaPgto" items="${listaFormasPgto}">
                                    <option value="${formaPgto.id}">${formaPgto.nome}</option>
                                </c:forEach>
                        </select>
                    </div>
                </div>

                
                <button type="submit" class="btn btn-primary">Registrar</button>
            </form>
        </div>
        <br/>
        <br/>
    </body>
</html>
