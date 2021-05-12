package br.senac.sp.conexaobd.servlet;

import br.senac.sp.conexaobd.dao.ClienteDAO;
import br.senac.sp.conexaobd.entidade.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DateFormatter;

public class CadastrarClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                //PASSO 1 - RECUPERAR OS PARAMETROS
                String nome = request.getParameter("nome");
                String endereco = request.getParameter("endereco");
                String email = request.getParameter("email");
                String dataNascimento = request.getParameter("dataNascimento");
                String sexo = request.getParameter("sexo");
                String telefone = request.getParameter("telefone");
                String tipo = request.getParameter("tipoDePessoa");
                String status = "Ativo";
                String cpf = "";
                String cnpj = "";
                
                if( tipo.equals( "cpf" ) )
                {
                    cpf = request.getParameter("cpf_cpnj");
                }
                else
                {
                    cnpj = request.getParameter("cpf_cpnj");
                }

                Date date = Date.valueOf(dataNascimento);
                //PASSO 2 - INSERIR O CLIENTE NO BD
                Cliente cliente = new Cliente( nome, endereco, email, date, sexo, telefone, cpf, cnpj, tipo, status );
                System.out.println("Resultado da classe cliente[" + cliente.toString( ) + "]");

                boolean ok = ClienteDAO.cadastrar(cliente);
                //boolean ok = true;

                // PASSO 3 - REDIRECIONAR PARA TELA DE SUCESSO/ERRO
                if (ok) {
                    response.sendRedirect("sucesso.jsp");
                } else {
                    String msg = "Não foi possível cadastrar o cliente";
                    request.setAttribute("msgErro", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);

                }
    }

}
