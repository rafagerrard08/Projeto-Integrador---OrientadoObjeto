

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Clientes</title>
    </head>
    <body class="container">
        <c:import url="header.jsp"/>
        <br>
        <c:if test="${empty cliente}">
        <h3>Cadastro de Clientes</h3>
        <br>
        <div class="border border-1 rounded">    
            <form class="p-4" action="CadastrarClienteServlet" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Nome</label>
                    <div class="col-sm-10">
                        <input type="text" name="nome" required="true" class="form-control" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Endereço</label>
                    <div class="col-sm-10">
                        <input type="text" name="endereco" required="true" class="form-control" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="text" name="email" required="true" class="form-control" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Data de Nascimento</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" name="dataNascimento" required="true" />
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Sexo</label>
                    <div class="col-sm-10">
                        <input type="text" name="sexo" required="true" class="form-control" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Telefone</label>
                    <div class="col-sm-10">
                        <input type="text" name="telefone" required="true" class="form-control" required/>
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Selecione</label>
                    <div class="col-sm-2">
                        <select class="form-select" name="tipoDePessoa">
                                <option value="cpf">CPF</option>
                                <option value="cnpj">CNPJ</option>
                        </select>
                    </div>                            
                    <div class="col-sm">
                            <input type="text" name="cpf_cpnj" required="true" class="form-control" required/>
                    </div>
                </div>
                
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
        </c:if>
        <c:if test="${not empty cliente}">
        <h3>Alteração de Clientes</h3>
        <br>
        <div class="border border-1 rounded">    
            <form class="p-4" action="AlterarClienteServlet" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Nome</label>
                    <div class="col-sm-10">
                        <input type="text" name="nome" required="true" class="form-control" value="${cliente.nome}" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Endereço</label>
                    <div class="col-sm-10">
                        <input type="text" name="endereco" required="true" class="form-control" value="${cliente.endereco}" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Email</label>
                    <div class="col-sm-10">
                        <input type="text" name="email" required="true" class="form-control" value="${cliente.email}" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Data de Nascimento</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" name="dataNascimento" required="true" value="${cliente.dataNascimento}" />
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Sexo</label>
                    <div class="col-sm-10">
                        <input type="text" name="sexo" required="true" class="form-control" value="${cliente.sexo}" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Telefone</label>
                    <div class="col-sm-10">
                        <input type="text" name="telefone" required="true" class="form-control" value="${cliente.telefone}" required/>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-sm-2 col-form-label">Selecione</label>
                    <div class="col-sm-2">
                        <select class="form-select" name="tipoDePessoa">
							<c:if test = "${cliente.tipo == 'cpf'}" >
                                <option value="cpf" selected>CPF</option>
                                <option value="cnpj">CNPJ</option>
							</c:if>
							<c:if test = "${cliente.tipo == 'cnpj'}" >
                                <option value="cpf">CPF</option>
                                <option value="cnpj" selected>CNPJ</option>
							</c:if>
                        </select>
                    </div>                            
                    <div class="col-sm">
                            <input type="text" name="cpf_cpnj" required="true" class="form-control" value="${cliente.tipo=='cpf'?cliente.cpf:cliente.cnpj}" required/>
                    </div>
                </div>                
                <button type="submit" class="btn btn-primary">Atualizar</button>
            </form>            
        </div>
        </c:if>
        <br/><br/>
        <c:import url="footer.jsp"/>
    </body>
</html>
