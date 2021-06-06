

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Vendas</title>
    </head>
    <body class="container">
        <c:import url="header.jsp"/>
        <br>
        <c:if test="${not empty venda}">
            <h3>Registrar venda</h3>
            <br>
            <div class="border border-1 rounded">
                <form class="p-4" action="AlterarVendaServlet" method="POST">
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">ID venda</label>
                        <div class="col-sm-10">
                            <input type="text" name="id_venda" required="true" class="form-control" required value="${venda.id_venda}"/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Nome vendedor</label>
                        <div class="col-sm-10">
                            <input type="text" name="vendedor" required="true" class="form-control" required value="${venda.vendedor}"/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">ID Cliente</label>
                        <div class="col-sm-10">
                            <input type="text" name="id_cliente" required="true" class="form-control" required value="${venda.id_cliente}"/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">ID Loja</label>
                        <div class="col-sm-10">
                            <input type="text" name="id_loja" required="true" class="form-control" required value="${venda.id_loja}"/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">ID Produto</label>
                        <div class="col-sm-10">
                            <input type="text" name="id_produto" required="true" class="form-control" required value="${venda.id_produto}"/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Valor</label>
                        <div class="col-sm-10"> 
                            <input type="text" name="id_valor" required="true" class="form-control" required value="${venda.id_valor}"/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Desconto</label>
                        <div class="col-sm-10">
                            <input type="text" name="desconto" required="true" class="form-control" required value="${venda.desconto}"/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Status</label>
                        <div class="col-sm-10">
                            <input type="text" name="status" required="true" class="form-control" required value="${venda.status}"/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Forma de pagamento</label>
                        <div class="col-sm-10">
                            <input type="text" name="forma_pagamento" required="true" class="form-control" required value="${venda.forma_pagamento}"/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Valor final</label>
                        <div class="col-sm-10">
                            <input type="text" name="valor_final" required="true" class="form-control" required value="${venda.valor_final}"/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Data da Venda</label>
                        <div class="col-sm-10">
                            <input type="date" name="data_venda" required="true" class="form-control" required value="${venda.data_venda}"/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Alterar</button>s
                </form>
            </div>
        </c:if>
        <c:if test="${empty venda}">
            <h3>Registrar venda</h3>
            <br>
            <div class="border border-1 rounded">
                <form class="p-4" action="CadastrarVendaServlet" method="POST">
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">ID venda</label>
                        <div class="col-sm-10">
                            <input type="text" name="id_venda" required="true" class="form-control" required/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Nome vendedor</label>
                        <div class="col-sm-10">
                            <input type="text" name="vendedor" required="true" class="form-control" required/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">ID Cliente</label>
                        <div class="col-sm-10">
                            <input type="text" name="id_cliente" required="true" class="form-control" required/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">ID Loja</label>
                        <div class="col-sm-10">
                            <input type="text" name="id_loja" required="true" class="form-control" required/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">ID Produto</label>
                        <div class="col-sm-10">
                            <input type="text" name="id_produto" required="true" class="form-control" required/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Valor</label>
                        <div class="col-sm-10">
                            <input type="text" name="id_valor" required="true" class="form-control" required/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Desconto</label>
                        <div class="col-sm-10">
                            <input type="text" name="desconto" required="true" class="form-control" required/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Status</label>
                        <div class="col-sm-10">
                            <input type="text" name="status" required="true" class="form-control" required/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Forma de pagamento</label>
                        <div class="col-sm-10">
                            <input type="text" name="forma_pagamento" required="true" class="form-control" required/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Valor final</label>
                        <div class="col-sm-10">
                            <input type="text" name="valor_final" required="true" class="form-control" required/>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <label class="col-sm-2 col-form-label">Data da Venda</label>
                        <div class="col-sm-10">
                            <input type="date" name="data_venda" required="true" class="form-control" required/>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Registrar</button>
                </form>
            </div>
        </c:if>
        <br/><br/>
        <c:import url="footer.jsp"/>
    </body>
</html>
