import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListaProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Produto> listaProdutos;

        listaProdutos = BancoDados.getProdutos();

        request.setAttribute("listaProdutos", listaProdutos);

        request.getRequestDispatcher("/Produto/Lista.jsp").forward(request, response);

    }

}

