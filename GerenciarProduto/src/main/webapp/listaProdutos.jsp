
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <title>Lista de Produtos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="container">
    
        <script type="text/javascript"> 
                function mostrarTelaConfirmacao(id_produto, nome) {
                  //alert(id_produto)
                //console.log("não funciona!", id_produto);
                $("#id_produto").val(id_produto);
                $("#nomeProduto").html(nome);
                $(".modal").show();

                var modalConfirmacao = $("#confirmarExclusao");
                modalConfirmacao.show();
            }

            function fecharModal() {
                $("#confirmarExclusao").hide();
            }

            function deletarProduto() {
                var id_produto = $("#id_produto").val();
                //alert(id_produto)
                 $(".modal").hide();
                  //fecharTelaConfirmacao();
                $.ajax("ExcluirProdutoServlet?id_produto=" + id_produto).done(function() {
                    //Sucesso
                    //alert('passou');
                    location.reload();
                })
                .fail(function () {
                    alert("error");
                    $("#alerta").css("display", "block");
                        setTimeout(function () {
                            $("#alerta").css("display", "none");
                        }, 1000);
                    }
                );
 
            }
            function pesquisarProdutos(){
                var nomeProduto = $("#pesquisaNomeProduto").val();
                  $.ajax( "ClienteServlet?nome="+nomeProduto).done(function() {
                      location.reload();
                  })           ;     
            }
            </script>
      <c:import url="header.jsp"/>    
               
        <h1>lista de Produtos:</h1>
        <div class="alert alert-danger" role="alert" id="alerta" style="display:none">
            Erro ao excluir produto!
        </div>
        <table class="table table-success table-striped">
            <thead>
            <th>Id do produto</th>
            <th>Id da loja</th>
            <th>Nome</th>
            <th>Quantidade do produto</th>
            <th>Valor</th>
            <th>Categoria</th>
            <th>Cor</th>
            <th>Marca</th>
            </thead>
            <tbody> 

                <c:forEach items="${listaProdutos}" var="Produto">
                    <tr>
                        <td>${Produto.id_produto}</td>
                        <td>${Produto.id_loja}</td>
                        <td>${Produto.nome}</td>
                        <td>${Produto.qtd_produto}</td>
                        <td>${Produto.valor}</td>
                        <td>${Produto.categoria}</td>
                        <td>${Produto.cor}</td>
                        <td>${Produto.marca}</td>

                        <td><a href="AlterarProdutoServlet?id_produto=${Produto.id_produto}">Alterar</a></td>

                        <td><button type="button" class="btn btn-link" onclick="mostrarTelaConfirmacao(`${Produto.id_produto}`, `${Produto.nome}`)">Excluir</button></td>
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
                        <p>Confirmar a exclusão do produto <label id="nomeProduto"></label> ?</p>
                        <input id="id_produto"  />
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="deletarProduto()" >Confirmar</button>
                    </div>
                </div>
            </div>
        </div>

        
        <c:import url="footer.jsp"/>
    </body>
</html>


