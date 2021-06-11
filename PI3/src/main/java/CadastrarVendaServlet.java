import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarVendaServlet extends HttpServlet {
    /*  Rodar Script no banco: 
        INSERT INTO FORMA_PGTO( FORMA ) VALUES( 'DEBITO' );
        INSERT INTO FORMA_PGTO( FORMA ) VALUES( 'CREDITO A VISTA' );
        INSERT INTO FORMA_PGTO( FORMA ) VALUES( 'PARCELADO EM 2 VEZES' );
        INSERT INTO FORMA_PGTO( FORMA ) VALUES( 'PARCELADO EM 3 VEZES' );*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idLoja = "";
        if( request.getParameter("ID_LOJA") != null )
        {
            idLoja = request.getParameter("ID_LOJA");
        }

        List<Produto> listaProdutos;
        List<Cliente> listaClientes;
        List<FormasPgto> listaFormasPgto;
        List<Loja> listaLoja;
            
        listaClientes = BancoDados.getClientes();
        listaFormasPgto = BancoDados.getFormasPgto();
        listaLoja = BancoDados.getLoja();
        
        if( idLoja.isEmpty( ) == false )
        {
            listaProdutos = BancoDados.getProdutosEmEstoque( idLoja );
        }
        else
        {
            listaProdutos = BancoDados.getProdutosEmEstoque( String.valueOf( listaLoja.get( 0 ).getId( ) ) );
        }
        
        request.setAttribute("listaProdutos", listaProdutos);
        request.setAttribute("listaClientes", listaClientes);
        request.setAttribute("listaFormasPgto", listaFormasPgto);
        request.setAttribute("listaLoja", listaLoja);

        request.getRequestDispatcher("/Venda/Cadastro.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
                String nomeVendedor = request.getParameter("nomeVendedor");
                Integer id_cliente = Integer.parseInt( request.getParameter("cliente") );
                Integer id_loja = Integer.parseInt( request.getParameter("loja") );
                Integer id_produto = Integer.parseInt( request.getParameter("produto") );
                String valor = request.getParameter("valor_produto");
                String desconto = request.getParameter("desconto");
                Integer formaPagamento = Integer.parseInt( request.getParameter("formas_pgto") );
                
                Venda venda = new Venda( nomeVendedor, id_cliente, id_loja, id_produto, Double.parseDouble(valor.replace( ',', '.')), Double.parseDouble(desconto.replace( ',', '.')), formaPagamento );
               
                boolean ok = BancoDados.cadastrarVenda(venda);
             
                if (ok) {
                    response.sendRedirect("sucesso.jsp");
                } else {
                    String msg = "Não foi possível inserir venda";
                    request.setAttribute("msgErro", msg);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);

                }
    }

}
