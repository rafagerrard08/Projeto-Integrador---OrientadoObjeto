/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bmrt.conexaobd.servlet;

import br.com.bmrt.conexaobd.dao.LojaDAO;
import br.com.bmrt.conexaobd.entidade.Loja;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.bmrt.conexaobd.utils.Utils;

/**
 *
 * @author Thiago Gilabel de Souza 
 */
public class AlterarLojaServlet extends HttpServlet {

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

        Loja loja = LojaDAO.getLoja(id_loja);
        request.setAttribute("loja", loja);

        request.getRequestDispatcher("/lojas/cadastrar.jsp").forward(request, response);

    }
// ATUALIZAR O BD COM AS NOVAS INFO.

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id_loja = Integer.parseInt(request.getParameter("id_loja"));
        String nome_loja = request.getParameter("nome_loja");
        
        String tipo_loja = request.getParameter("tipo_loja");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        Integer id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        Loja loja = new Loja(id_loja, nome_loja, tipo_loja, endereco, telefone, id_cliente);
        boolean ok = LojaDAO.atualizar(loja);
        Utils.sendRedirect(ok, response);

    }

}
