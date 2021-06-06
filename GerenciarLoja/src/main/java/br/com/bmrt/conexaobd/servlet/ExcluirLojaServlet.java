package br.com.bmrt.conexaobd.servlet;

import br.com.bmrt.conexaobd.dao.LojaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago Gilabel de Souza 
 */
public class ExcluirLojaServlet extends HttpServlet {

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
        
            Integer id_loja = Integer.parseInt(request.getParameter("id_loja"));
                   
        boolean ok = LojaDAO.deletar(id_loja);
        response.setStatus(ok? 200:500);
    }

}
