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
        <script type="text/javascript">
            function mostrarTelaConfirmacao(nome, id){
                $("#nomeProduto").html(nome);
                $("#id_venda").html(id);
                
                var modalConfirmacao = $("#confirmarExclusao");
                modalConfirmacao.show();
            }
            
            function fecharTelaConfirmacao() {
                $("#confirmarExclusao").hide();
            }
            
            function deletarVenda( ) {
                var id_banco = $("#id_venda").text();
                fecharTelaConfirmacao();
                  $.ajax( "ExcluirVendaServlet?id="+id_banco).done(function() {
                        //Sucesso
                        location.reload();
                      })
                      .fail(function() {
                        console.log( "error" );
                        $("#alerta").css("display", "block");
                        setTimeout(function (){
                            $("#alerta").css("display", "none");
                        }, 1000);
                      })      
            }
        </script>
    </head>
    <body class="container">
        <c:import url="../cabecalho.jsp"/>
        <br>
        <h3>Lista de Venda</h3>
        <br>
        <!--div class="input-group mb-3">
          <input type="text" id="pesquisaNomeCliente" name="pesquisaNomeCliente" class="form-control" placeholder="Nome do Cliente" aria-label="Nome do Cliente" aria-describedby="button-addon2">
          <button class="btn btn-outline-primary" type="button" onclick="pesquisarCliente()">Pesquisar</button>
        </div-->
        <br>
        <div class="alert alert-danger" role="alert" id="alerta" style="display:none">
            Erro ao excluir produto!
         </div>
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
                    <th scope="col"> </th>
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

                        <td><button type="button" class="btn btn-warning" onclick="mostrarTelaConfirmacao(`${venda.nome_produto}`,`${venda.idBanco}`)">Excluir</button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
                
        <div class="modal" id="confirmarExclusao" >
            <div class="modal-dialog">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title">Confirmar Exclusão</h5>
                 </div>
                <div class="modal-body">
                    <p>Confirmar a exclusão da venda com o produto <label id="nomeProduto"></label>  ?</p>
                    <label style="visibility:hidden" id="id_venda"></label>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                    <button type="button" class="btn btn-primary" onclick="deletarVenda()" >Confirmar</button>
                </div>
              </div>
            </div>
          </div>
    </body>
</html>
