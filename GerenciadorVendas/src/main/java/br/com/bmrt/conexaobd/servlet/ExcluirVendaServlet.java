
package br.com.bmrt.conexaobd.servlet;

import br.com.bmrt.conexaobd.dao.VendasDAO;
import br.com.bmrt.conexaobd.utils.Redirect;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago Gilabel de Souza
 */

public class ExcluirVendaServlet extends HttpServlet {

   
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            Integer id_venda = Integer.parseInt(request.getParameter("id_venda"));
        
        boolean ok = VendasDAO.deletar(id_venda);
        response.setStatus(ok? 200:500);
    }

    

   

}
