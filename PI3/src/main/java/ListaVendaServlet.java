import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bia
 */
public class ListaVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            List<Venda> listaVendas;

            listaVendas = BancoDados.getVendas();

            request.setAttribute("listaVendas", listaVendas);

            request.getRequestDispatcher("/Venda/Lista.jsp").forward(request, response);
    }
}
