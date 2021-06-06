/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bmrt.conexaobd.servlet;

import br.com.bmrt.conexaobd.dao.RelatorioVendaDAO;
import br.com.bmrt.conexaobd.entidade.Venda;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago Gilabel de Souza
 */

public class DetalharVendaLojaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            int id_loja = Integer.parseInt(request.getParameter("id_loja"));
         List<Venda> listaVendas;

        listaVendas = RelatorioVendaDAO.getDetalheRelatorioVendaPorLoja(id_loja);
        request.setAttribute("listaVendas", listaVendas);

        request.getRequestDispatcher("/listaVendas.jsp").forward(request, response);
    }
}
