<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Produtos</title>
	<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<script src="../jquery/jquery-3.6.0.min.js"></script>
	<script src="../bootstrap/js/bootstrap.bundle.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function mostrarTelaConfirmacao(nome, id){
                $("#nomeProduto").html(nome);
                $("#id_produto").html(id);
                
                var modalConfirmacao = $("#confirmarExclusao");
                modalConfirmacao.show();
            }
            
            function fecharTelaConfirmacao() {
                $("#confirmarExclusao").hide();
            }
            
            function deletarCliente( ) {
                var id_banco = $("#id_produto").text();
                fecharTelaConfirmacao();
                  $.ajax( "ExcluirProdutoServlet?id="+id_banco).done(function() {
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
        <h3>Lista de Produtos</h3>
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
                    <th scope="col">Nome</th>
                    <th scope="col">Qtd</th>
                    <th scope="col">Valor</th>
                    <th scope="col">Categoria</th>
                    <th scope="col">Cor</th>
                    <th scope="col">Marca</th>
                    <th scope="col"> </th>
                    <th scope="col"> </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaProdutos}" var="produto">
                    <tr>
                        <td>${produto.nome_loja}</td>
                        <td>${produto.nome}</td>
                        <td>${produto.qtd_produto}</td>
                        <td>${produto.valor}</td>
                        <td>${produto.categoria}</td>
                        <td>${produto.cor}</td>
                        <td>${produto.marca}</td>

                        <td><a type="button" class="btn btn-primary" href="AlterarProdutoServlet?id=${produto.id_produto}">Alterar</a></td>
                        <td><button type="button" class="btn btn-warning" onclick="mostrarTelaConfirmacao(`${produto.nome}`,`${produto.id_produto}`)">Excluir</button></td>
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
                    <p>Confirmar a exclusão do produto <label id="nomeProduto"></label>  ?</p>
                    <label style="visibility:hidden" id="id_produto"></label>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                    <button type="button" class="btn btn-primary" onclick="deletarCliente()" >Confirmar</button>
                </div>
              </div>
            </div>
          </div>
    </body>
</html>
