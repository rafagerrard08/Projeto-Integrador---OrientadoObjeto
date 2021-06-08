import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer id_venda = Integer.parseInt(request.getParameter("id"));
            
        boolean ok = BancoDados.deletarVenda(id_venda);
        
        response.setStatus(ok? 200:500);
    }

}

