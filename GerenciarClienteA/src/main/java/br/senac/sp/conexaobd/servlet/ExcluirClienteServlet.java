
package br.senac.sp.conexaobd.servlet;

import br.senac.sp.conexaobd.dao.ClienteDAO;
import br.senac.sp.conexaobd.utils.Redirect;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ExcluirClienteServlet extends HttpServlet {

   
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        
        boolean ok = ClienteDAO.deletar(id);
        response.setStatus(ok? 200:500);
    }

    

   

}
