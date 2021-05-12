
package br.senac.sp.conexaobd.servlet;

import br.senac.sp.conexaobd.dao.ClienteDAO;
import br.senac.sp.conexaobd.entidade.Cliente;
import br.senac.sp.conexaobd.utils.Redirect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AlterarClienteServlet extends HttpServlet {

    private String idClienteAtual;
    
     // CARREGAR INFO DO CLIENTE
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                String id = request.getParameter("id");
                idClienteAtual = id;
                
                Cliente cliente = ClienteDAO.getCliente(id);

                request.setAttribute("cliente", cliente);

                request.getRequestDispatcher("/cadastrar.jsp").forward(request, response);
   }

    // ATUALIZAR O BD COM AS NOVAS INFO.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                cliente.setIdBanco( Integer.parseInt(idClienteAtual) );
                
                boolean ok = ClienteDAO.atualizar(cliente);
                
                Redirect.sendRedirect(ok, response);
    }

    

}
