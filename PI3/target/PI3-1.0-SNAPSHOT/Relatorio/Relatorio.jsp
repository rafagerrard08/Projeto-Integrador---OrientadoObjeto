<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Vendas</title>
	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="../jquery/jquery-3.6.0.min.js"></script>
	<script src="../bootstrap/js/bootstrap.bundle.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="container">
        <c:import url="../cabecalho.jsp"/>
        <br>
        <h3>Relatorio</h3>
        <br>
        <br>
        <div class="border border-1 rounded">    
            <form class="p-4" action="/PI3/RelatorioServlet" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Data inicial</label>
                    <div class="col-sm-2">
                        <input type="date" class="form-control" name="DATA_INICIAL" value="${param.DATA_INICIAL}" />
                    </div>
                    <label class="col-sm-2 col-form-label">Data final</label>
                    <div class="col-sm-2">
                        <input type="date" class="form-control" name="DATA_FINAL" value="${param.DATA_FINAL}" />
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Loja</label>
                    <div class="col-sm-2">
                        <select class="form-select" name="ID_LOJA">
                                <option value="branco" selected>-</option>
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
                    <label class="col-sm-2 col-form-label">Categoria de produto</label>
                    <div class="col-sm-2">
                        <select class="form-select" name="ID_CAT_PROD">
                                <option value="branco" selected>-</option>
                                <c:forEach var="cat" items="${listaCategorias}">
                                    <c:choose>
                                        <c:when test="${cat.idBanco == param.ID_CAT_PROD}">
                                            <option value="${cat.idBanco}" selected>${cat.nome}</option>
                                        </c:when>    
                                        <c:otherwise>
                                            <option value="${cat.idBanco}">${cat.nome}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                        </select>
                    </div>    
                    <label class="col-sm-2 col-form-label">Cliente</label>
                    <div class="col-sm-2">
                        <select class="form-select" name="ID_CLIENTE">
                                <option value="branco" selected>-</option>
                                <c:forEach var="cli" items="${listaClientes}">
                                    <c:choose>
                                        <c:when test="${cli.idBanco == param.ID_CLIENTE}">
                                            <option value="${cli.idBanco}" selected>${cli.nome}</option>
                                        </c:when>    
                                        <c:otherwise>
                                            <option value="${cli.idBanco}">${cli.nome}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                        </select>
                    </div>    
                </div>
               
                <button class="btn btn-primary">Buscar</button>
            </form>
        </div>
        <br>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Loja</th>
                    <th scope="col">Nome Vendedor</th>
                    <th scope="col">Produto</th>
                    <th scope="col">Qtd</th>
                    <th scope="col">Valor Final</th>
                    <th scope="col">Desconto</th>
                    <th scope="col">Data da Venda</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaVendas}" var="venda">
                    <tr>
                        <td>${venda.nome_loja}</td>
                        <td>${venda.nomeVendedor}</td>
                        <td>${venda.nome_produto}</td>
                        <td>1</td>
                        <td>${venda.valor}</td>
                        <td>${venda.desconto}</td>
                        <td>${venda.data_venda}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
