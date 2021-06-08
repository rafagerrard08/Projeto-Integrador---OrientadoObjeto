
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Clientes</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function mostrarTelaConfirmacao(nome, id){
                $("#nomeCliente").html(nome);
                $("#id_cliente").html(id);
                
                var modalConfirmacao = $("#confirmarExclusao");
                modalConfirmacao.show();
            }
            
            function fecharTelaConfirmacao() {
                $("#confirmarExclusao").hide();
            }
            
            function deletarCliente( ) {
                var id_banco = $("#id_cliente").text();
                fecharTelaConfirmacao();
                  $.ajax( "ExcluirClienteServlet?id="+id_banco).done(function() {
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
            
            function pesquisarCliente(){
                var nomeCliente = $("#pesquisaNomeCliente").val();
                  $.ajax( "ClienteServlet?nome="+nomeCliente).done(function() {
                      location.reload();
                  })                
            }
        </script>
    </head>
    <body class="container">
        <c:import url="header.jsp"/>
        <br>
        <h3>Lista de Clientes</h3>
        <br>
        <!--div class="input-group mb-3">
          <input type="text" id="pesquisaNomeCliente" name="pesquisaNomeCliente" class="form-control" placeholder="Nome do Cliente" aria-label="Nome do Cliente" aria-describedby="button-addon2">
          <button class="btn btn-outline-primary" type="button" onclick="pesquisarCliente()">Pesquisar</button>
        </div-->
        <br>
        <div class="alert alert-danger" role="alert" id="alerta" style="display:none">
            Erro ao excluir cliente!
         </div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">NOME</th>
                    <th scope="col">CPF/CNPJ</th>
                    <th scope="col">ENDEREÇO</th>
                    <th scope="col">DATA NASCIMENTO</th>
                    <th scope="col">SEXO</th>
                    <th scope="col">EMAIL</th>
                    <th scope="col">TELEFONE</th>
                    <th scope="col"> </th>
                    <th scope="col"> </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listaClientes}" var="cliente">
                    <tr>
                        <td>${cliente.nome}</td>

                        <c:if test = "${cliente.tipo == 'cpf'}" >
                        <td>${cliente.cpf}</td>
                        </c:if>
                        <c:if test = "${cliente.tipo == 'cnpj'}" >
                        <td>${cliente.cnpj}</td>
                        </c:if>
                        <td>${cliente.endereco}</td>
                        <td><fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.dataNascimento}" /></td>
                        <td>${cliente.sexo}</td>
                        <td>${cliente.email}</td>
                        <td>${cliente.telefone}</td>

                        <td><a type="button" class="btn btn-primary" href="AlterarClienteServlet?id=${cliente.idBanco}">Alterar</a></td>
                        <td><button type="button" class="btn btn-warning" onclick="mostrarTelaConfirmacao(`${cliente.nome}`,`${cliente.idBanco}`)">Excluir</button></td>
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
                    <p>Confirmar a exclusão do cliente <label id="nomeCliente"></label>  ?</p>
                    <label style="visibility:hidden" id="id_cliente"></label>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" onclick="fecharTelaConfirmacao()">Cancelar</button>
                    <button type="button" class="btn btn-primary" onclick="deletarCliente()" >Confirmar</button>
                </div>
              </div>
            </div>
          </div>
        
        
        <c:import url="footer.jsp"/>
    </body>
</html>
