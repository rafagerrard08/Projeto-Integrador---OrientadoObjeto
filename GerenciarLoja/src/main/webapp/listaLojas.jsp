
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
    <head>
        <title>Lista de Lojas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">         
    </head>
    <body class="container">
        <script type="text/javascript">

            function mostrarTelaConfirmacao(id_loja, nome_loja) {
                console.log("não funciona!", id_loja);
                $("#id_loja").val(id_loja);
                $("#nomeLoja").html(nome_loja);
                $(".modal").show();

                var modalConfirmacao = $("#confirmarExclusao");
                modalConfirmacao.show();
            }

            function fecharModal() {
                $("#confirmarExclusao").hide();
            }

            function deletarLoja() {
                //alert('asdasdasdad')
                var id_loja = $("#id_loja").val();
                var id_cliente = $("#id_cliente").val();
                //alert(id_loja);
                $(".modal").hide();
                $.ajax("ExcluirLojaServlet?id_loja=" + id_loja).done(function () {
                    //Sucesso
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
        </script>
        <c:import url="header.jsp"/> 
        <h1>Lojas:</h1>
        <div class="alert alert-danger" role="alert" id="alerta" style="display:none">
            Erro ao excluir a loja!
        </div>
        <table class="table table-success table-striped">
            <thead>
            
            <th>Id da loja</th>
            <th>Nome</th>
            <th>Tipo</th>
            <th>Endereco</th>
            <th>Telefone</th>
            <th>Id cliente</th>
        </thead>
        <tbody> 

            <c:forEach items="${listaLojas}" var="Loja">
                <tr>
                    <td>${Loja.id_loja}</td>
                    <td>${Loja.nome_loja}</td>
                    <td>${Loja.tipo_loja}</td>
                    <td>${Loja.endereco}</td>
                    <td>${Loja.telefone}</td>
                    <td>${Loja.id_cliente}</td>

                    <td><a href="AlterarLojaServlet?id_loja=${Loja.id_loja}">Alterar</a></td>

                    <td><button type="button" class="btn btn-link" onclick="mostrarTelaConfirmacao(`${Loja.id_loja}`, `${Loja.nome_loja}`)">Excluir</button></td>
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
                    <p>Confirmar a exclusão da loja <label id="nomeLoja"></label> ?</p>
                    <input type="hidden" id="id_loja" />
                    <input type="hidden" id="id_cliente" />
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                    <button type="button" class="btn btn-primary" onclick="deletarLoja()" >Confirmar</button>
                </div>
            </div>
        </div>
    </div>


    <c:import url="footer.jsp"/>
</body>
</html>
