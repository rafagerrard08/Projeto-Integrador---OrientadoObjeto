import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaClienteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            List<Cliente> listaClientes;

            listaClientes = BancoDados.getClientes();

            request.setAttribute("listaClientes", listaClientes);

            request.getRequestDispatcher("/Cliente/Lista.jsp").forward(request, response);
    }
}
