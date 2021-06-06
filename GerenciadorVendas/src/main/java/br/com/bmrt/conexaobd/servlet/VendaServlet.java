/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bmrt.conexaobd.servlet;

import br.com.bmrt.conexaobd.dao.VendasDAO;
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

public class VendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Venda> listaVendas;

        listaVendas = VendasDAO.getVenda();

        request.setAttribute("listaVendas", listaVendas);

        request.getRequestDispatcher("/listaVendas.jsp").forward(request, response);

    }
}
