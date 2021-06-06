
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Vendas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body class="container">
        <script type="text/javascript">
            function mostrarTelaConfirmacao(vendedor, id_venda) {
                /*alert(id_venda);
                alert(vendedor);*/
                $("#vendedor").html(vendedor);
                $("#id_venda").val(id_venda);

               var modalConfirmacao = $("#confirmarExclusao");
                $(".modal").show();
            }

            function fecharTelaConfirmacao() {
                $("#confirmarExclusao").hide();
            }
            function deletarVenda( ) {
                alert($("#id_venda").val());
                var id_venda = $("#id_venda").val();
                //fecharTelaConfirmacao();
                 $(".modal").hide();
                $.ajax("ExcluirVendaServlet?id_venda=" + id_venda).done(function() {
                //Sucesso
                location.reload();
                })
                .fail(function() {
                    console.log("error");
                    $("#alerta").css("display", "block");
                    setTimeout(function (){
                        $("#alerta").css("display", "none");
                    }, 1000);
                    
                });
            }
            
            // }
        </script>
        <c:import url="header.jsp"/>
        <br>
        <h3>Lista de Vendas</h3>
        <br>
        <!--div class="input-group mb-3">
          <input type="text" id="pesquisaNomeCliente" name="pesquisaNomeCliente" class="form-control" placeholder="Nome do Cliente" aria-label="Nome do Cliente" aria-describedby="button-addon2">
          <button class="btn btn-outline-primary" type="button" onclick="pesquisarCliente()">Pesquisar</button>
        </div-->
        <br>
        <div class="alert alert-danger" role="alert" id="alerta" style="display:none">
            Erro ao excluir venda!
        </div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">ID VENDA</th>
                    <th scope="col">VENDEDOR</th>
                    <th scope="col">ID LOJA</th>
                    <th scope="col">ID CLIENTE</th>                                   
                    <th scope="col">ID PRODUTO</th>
                    <th scope="col">ID VALOR</th>
                    <th scope="col">FORMA DE PAGAMENTO</th>
                    <th scope="col">STATUS</th>
                    <th scope="col">DESCONTO</th>
                    <th scope="col">VALOR FINAL</th>
                        <th scope="col">DATA_VENDA</th>


                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaVendas}" var="Venda">
                    <tr>
                        <td>${Venda.id_venda}</td>
                        <td>${Venda.vendedor}</td>                    
                        <td>${Venda.id_cliente}</td>
                        <td>${Venda.id_loja}</td>
                        <td>${Venda.id_produto}</td>
                        <td>${Venda.id_valor}</td>
                        <td>${Venda.forma_pagamento}</td>
                            <td>${Venda.status}</td>
                        <td>${Venda.desconto}</td>
                        <td>${Venda.valor_final}</td>
                             <td>${Venda.data_venda}</td>


                        <td><a type="button" class="btn btn-primary" href="AlterarVendaServlet?id_venda=${Venda.id_venda}">Alterar</a></td>
                        <td><button type="button" class="btn btn-warning" onclick="mostrarTelaConfirmacao(`${Venda.vendedor}`, `${Venda.id_venda}`)">Excluir</button></td>
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
                        <p>Confirmar a exclusão da venda <label id="vendedor"></label>  ?</p>
                        <label style="visibility:hidden" id="id_venda"></label>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                        <button type="button" class="btn btn-primary" onclick="deletarVenda()" >Confirmar</button>
                    </div>
                </div>
            </div>
        </div>


        <c:import url="footer.jsp"/>
    </body>
</html>
