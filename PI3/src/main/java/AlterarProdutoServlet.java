import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlterarProdutoServlet extends HttpServlet {

    private String idProdutoAtual;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        idProdutoAtual = id;
        Integer id_produto = Integer.parseInt(id);
        List<Loja> listaLoja;
        List<CategoriaProduto> listaCategorias;
        
        Produto produto = BancoDados.getProduto(id_produto);
        listaLoja = BancoDados.getLoja();
        listaCategorias = BancoDados.getCategorias();
        
        request.setAttribute("produto", produto);
        request.setAttribute("listaLoja", listaLoja);
        request.setAttribute("listaCategorias", listaCategorias);
        
        request.getRequestDispatcher("/Produto/Cadastro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id_loja = Integer.parseInt(request.getParameter("id_loja"));
        String nome = request.getParameter("nome");
        Integer qtd_produto = Integer.parseInt(request.getParameter("qtd_produto"));
        Double valor = Double.parseDouble(request.getParameter("valor").replace( ',', '.'));
        Integer id_categoria = Integer.parseInt( request.getParameter("id_categoria") );
        String cor = request.getParameter("cor");
        String marca = request.getParameter("marca");

        Integer id_produto = Integer.parseInt(idProdutoAtual);
        
        Produto produto = new Produto( id_loja, nome, qtd_produto, valor, id_categoria, cor, marca );
        produto.setId_produto( id_produto );
        
        boolean ok = BancoDados.atualizarProduto(produto);
        
        Redirect.sendRedirect(ok, response);

    }

}

