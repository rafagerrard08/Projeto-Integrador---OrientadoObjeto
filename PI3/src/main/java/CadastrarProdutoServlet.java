import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Loja> listaLoja;

        listaLoja = BancoDados.getLoja();
        
        request.setAttribute("listaLoja", listaLoja);

        request.getRequestDispatcher("/Produto/Cadastro.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Integer id_loja = Integer.parseInt(request.getParameter("loja"));
                Double valor = Double.parseDouble(request.getParameter("valor"));
                Integer qtd_produto = Integer.parseInt(request.getParameter("qtd_produto"));
                String nome = request.getParameter("nome");
                String categoria = request.getParameter("categoria");
                String cor = request.getParameter("cor");
                String marca = request.getParameter("marca");
        //PASSO 2 - INSERIR O CLIENTE NO BD
        Produto produto = new Produto( id_loja, nome, qtd_produto, valor, categoria, cor, marca);
        boolean ok = BancoDados.cadastrarProduto(produto);

        // PASSO 3 - REDIRECIONAR PARA TELA DE SUCESSO/ERRO
        if (ok) {
            response.sendRedirect("sucesso.jsp");
        } else {
            String msg = "Não foi possível cadastrar o produto!";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }

    }

}

