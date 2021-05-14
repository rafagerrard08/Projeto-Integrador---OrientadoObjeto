/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bmrt.conexaobd.servlet;

import br.com.bmrt.conexaobd.dao.ProdutoDAO;
import br.com.bmrt.conexaobd.entidade.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelFerraz
 */
public class ProdutoServlet extends HttpServlet {

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
        
        List<Produto> listaProdutos;
         // Passo 1 - Nao precisa
        // Passo 2 - Listar clientes
        listaProdutos = ProdutoDAO.getProdutos();

        request.setAttribute("listaProdutos", listaProdutos);
           // Passo 3 - Encaminhar para o JSP

        request.getRequestDispatcher("/listaProdutos.jsp").forward(request, response);

    }

}
