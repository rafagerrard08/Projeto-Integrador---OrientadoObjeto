import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RelatorioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String idLoja = "";
            String idCategoriaProduto = "";
            String idCliente = "";
            String dataInical = "";
            String dataFinal = "";
            
            if( request.getParameter("ID_LOJA") != null )
            {
                idLoja = request.getParameter("ID_LOJA");
                if( idLoja.equals( "branco" ) ){
                    idLoja = "";
                }
            }
            if( request.getParameter("ID_CAT_PROD") != null )
            {
                idCategoriaProduto = request.getParameter("ID_CAT_PROD");
                if( idCategoriaProduto.equals( "branco" ) ){
                    idCategoriaProduto = "";
                }
            }
            if( request.getParameter("ID_CLIENTE") != null )
            {
                idCliente = request.getParameter("ID_CLIENTE");
                if( idCliente.equals( "branco" ) ){
                    idCliente = "";
                }
            }
            if( request.getParameter("DATA_INICIAL") != null )
            {
                dataInical = request.getParameter("DATA_INICIAL");
            }
            if( request.getParameter("DATA_FINAL") != null )
            {
                dataFinal = request.getParameter("DATA_FINAL");
            }
            
            System.out.println("idLoja:"+idLoja);
            System.out.println("idCategoriaProduto:"+idCategoriaProduto);
            System.out.println("idCliente:"+idCliente);
            System.out.println("dataInical:"+dataInical);
            System.out.println("dataFinal:"+dataFinal);
            
            List<Venda> listaVendas;
            List<Cliente> listaClientes;
            List<Loja> listaLoja;
            List<CategoriaProduto> listaCategorias;
            
            if( dataInical.isEmpty() == true && 
                dataFinal.isEmpty() == true && 
                idCategoriaProduto.isEmpty() == true && 
                idCliente.isEmpty() == true && 
                idLoja.isEmpty() == true )
            {
                listaVendas = BancoDados.getVendas( );
            }
            else
            {
                listaVendas = BancoDados.getVendas( dataInical, dataFinal, idCategoriaProduto, idCliente, idLoja );
            }
                
            listaClientes = BancoDados.getClientes();
            listaLoja = BancoDados.getLoja();
            listaCategorias = BancoDados.getCategorias();
            
            request.setAttribute("listaVendas", listaVendas);
            request.setAttribute("listaClientes", listaClientes);
            request.setAttribute("listaLoja", listaLoja);
            request.setAttribute("listaCategorias", listaCategorias);
            
            request.getRequestDispatcher("/Relatorio/Relatorio.jsp").forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            
            List<Venda> listaVendas;
            List<Cliente> listaClientes;
            List<Loja> listaLoja;
            List<CategoriaProduto> listaCategorias;
            
            listaVendas = BancoDados.getVendas( );    
            listaClientes = BancoDados.getClientes();
            listaLoja = BancoDados.getLoja();
            listaCategorias = BancoDados.getCategorias();
            
            request.setAttribute("listaVendas", listaVendas);
            request.setAttribute("listaClientes", listaClientes);
            request.setAttribute("listaLoja", listaLoja);
            request.setAttribute("listaCategorias", listaCategorias);
            
            request.getRequestDispatcher("/Relatorio/Relatorio.jsp").forward(request, response);
    }
}
