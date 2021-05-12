/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.conexaobd.servlet;

import br.senac.sp.conexaobd.dao.ClienteDAO;
import br.senac.sp.conexaobd.entidade.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author scarton
 */
public class ClienteServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            List<Cliente> listaClientes;
            //if (request.getParameterMap().containsKey("nome")) {
            //    String nome = request.getParameter("nome");
                
            //    listaClientes = ClienteDAO.getClientes( nome );
            //}
            //else{
                listaClientes = ClienteDAO.getClientes();
            //}

            request.setAttribute("listaClientes", listaClientes);

            request.getRequestDispatcher("/listaClientes.jsp").forward(request, response);
        
    }
    

}
