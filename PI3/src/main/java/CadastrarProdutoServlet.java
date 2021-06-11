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
        List<CategoriaProduto> listaCategorias;

        listaLoja = BancoDados.getLoja();
        listaCategorias = BancoDados.getCategorias();
        
        request.setAttribute("listaLoja", listaLoja);
        /*Setado direto no banco, rodar script: 
        INSERT INTO LOJA( NOME ) VALUES( 'BRMT MATRIZ' );
        INSERT INTO LOJA( NOME ) VALUES( 'BRMT FILIAL 1' );*/
        
        request.setAttribute("listaCategorias", listaCategorias);
        /*Setado direto no banco, rodar script: 
        INSERT INTO CATEGORIA_PRODUTO( NOME ) VALUES( 'COZINHA' );
        INSERT INTO CATEGORIA_PRODUTO( NOME ) VALUES( 'SALA' );
        INSERT INTO CATEGORIA_PRODUTO( NOME ) VALUES( 'ESCRITORIO' );
        INSERT INTO CATEGORIA_PRODUTO( NOME ) VALUES( 'BANHEIRO' );
        INSERT INTO CATEGORIA_PRODUTO( NOME ) VALUES( 'ELETRONICOS' );
        INSERT INTO CATEGORIA_PRODUTO( NOME ) VALUES( 'ELETRODOMESTICOS' );
        INSERT INTO CATEGORIA_PRODUTO( NOME ) VALUES( 'VARIEDADES' );*/
        
        request.getRequestDispatcher("/Produto/Cadastro.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Integer id_loja = Integer.parseInt(request.getParameter("loja"));
                Double valor = Double.parseDouble(request.getParameter("valor").replace( ',', '.'));
                Integer qtd_produto = Integer.parseInt(request.getParameter("qtd_produto"));
                String nome = request.getParameter("nome");
                Integer id_categoria = Integer.parseInt( request.getParameter("id_categoria") );
                String cor = request.getParameter("cor");
                String marca = request.getParameter("marca");
        //PASSO 2 - INSERIR O CLIENTE NO BD
        Produto produto = new Produto( id_loja, nome, qtd_produto, valor, id_categoria, cor, marca);
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

