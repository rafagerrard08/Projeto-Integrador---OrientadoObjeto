package br.com.bmrt.conexaobd.servlet;

import br.com.bmrt.conexaobd.dao.ProdutoDAO;
import java.io.IOException;
import br.com.bmrt.conexaobd.utils.Utils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelFerraz
 */
public class ExcluirProdutoServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            Integer id_produto = Integer.parseInt(request.getParameter("id_produto"));
            System.out.println("Id do produto: "+ id_produto);
            boolean ok = ProdutoDAO.deletar(id_produto);
        response.setStatus(ok? 200:500);
       }

}
