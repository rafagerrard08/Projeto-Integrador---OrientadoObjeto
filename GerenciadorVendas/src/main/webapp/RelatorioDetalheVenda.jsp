<%@include file="./header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatorios</title>
        <style>
            #Cliente, #Categoria, #Loja {
                display: none;
            }
        </style>
        <script lang="text/javascript">
            function tipo() {
                var select = document.getElementById('filtro');
                var option = select.children[select.selectedIndex];
                var texto = option.textContent;
                console.log(texto);
                //
                if (texto === '-') {
                    document.getElementById('Categoria').style.display = "none";
                    document.getElementById('Cliente').style.display = "none";
                    document.getElementById('Loja').style.display = "none";
                } else if (texto === 'Cliente') {
                    document.getElementById('Cliente').style.display = "block";
                } else if (texto === 'Categoria') {
                    document.getElementById('Categoria').style.display = "block";
                } else if (texto === 'Loja') {
                    document.getElementById('Loja').style.display = "block";
                }
                //document.getElementById(texto).style.display = "block";
            }
            ;
            function filtraPorCliente() {
                var campo = document.getElementById('campoId_cliente');
                alert(campo.value);
                window.location.href = "DetalharVendaClienteServlet?id_cliente=" + campo.value;
            }
            function filtraPorProduto() {
                var select = document.getElementById('produto');
                var option = select.children[select.selectedIndex];
                var texto = option.textContent;
                window.location.href = "DetalharVendaProduto?Categoria=" + texto;
            }
            function filtraPorFilial() {
                var campo = document.getElementById('campoLoja');
                alert(campo.value);
                window.location.href = "DetalharVendaLojaServlet?id_loja=" + campo.value;
            }
            function teste() {
                for (var i = 0, row; row = table.rows[i]; i++) {
                    console.log(row.cells[0]);
                    console.log(row.cells[1]);
                    console.log(row.cells[2]);
                    console.log(row.cells[3]);
                }
            }
        </script>
    </head>
    <c:if test="${sessionScope.user.isGerenteF()}">
        <script>
            window.location.href = "DetalharVendaLoja?id_loja=" + ${sessionScope.user.id_loja};
        </script>
    </c:if>
    <c:if test="${sessionScope.user.isVendedor()}">
        <script>
            window.location.href = "acessoNaoAutorizado.jsp";
        </script>
    </c:if>
    <c:if test="${sessionScope.user.isAnalista()}">
        <script>
            window.location.href = "acessoNaoAutorizado.jsp";
        </script>
    </c:if>
    <div class="container">
        <div>
            <h6>Filtrar Por:</h6>
            <select class="form-control col-5" id="filtro">
                <option value="op">-</option>
                <option value="op">Loja</option>
                <option value="op">Categoria</option>
                <option value="op">Cliente</option>
            </select>
            <button onclick="tipo()" type="submit" class="btn btn-primary">&#128269;</button>
        </div>
        <div id="Categoria">
            <option value="op">Banho</option>                
            </select>
            <button onclick="filtraPorProduto()" type="submit" class="btn btn-primary">&#128269;</button>
        </div>
        <div class="row" id="Cliente">            
            <div class="col-1">
                <label type="text" class="input-group-text">ID</label>
                <input type="search" id="campoId_cliente" name="id_cliente" class="form-control"/>
                <button type="submit" onclick="filtraPorCliente()" class="btn btn-primary">&#128269;</button><br/>
            </div>
        </div>  
        <div class="row" id="Loja">
            <div class="col-1">
                <label type="text" class="input-group-text">ID</label>
                <input type="search" id="campoLoja" name="id_loja" class="form-control"/>
                <button type="submit" onclick="filtraPorFilial()" class="btn btn-primary">&#128269;</button><br/>
            </div>

        </div>

        <h4>Relatórios de Vendas</h4>
        <h6>Filtrar por período</h6>

        <table id="table" class="table">
            <thead>
            <th>ID da Venda</th>
            <th>ID do Cliente </th>
            <th>Desconto</th>
            <th>Data</th>
            <th>Valor Total</th>
            <th>Detalhe Venda</th>
            </thead>
            <tbody>
                <c:forEach var="v" items="${listaVendas}">
                    <tr>
                        <td>${v.id_venda}</td>
                        <td>${v.id_cliente}</td>
                        <td>${v.desconto}</td>
                        <td>${v.data_venda}</td>
                        <td>${v.valor_final}</td>
                        <td><a href="DetalharVenda?id_venda=${v.id_venda}"><button type="button" class="btn btn-danger">Detalhes</button></a></td>
                    </tr>
                </c:forEach>
            </tbody>
            <button onclick="teste()" type="submit" class="btn btn-primary">&#128269;</button>
        </table>
    </div>
                    