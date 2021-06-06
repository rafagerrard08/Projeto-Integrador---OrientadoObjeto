package br.com.bmrt.conexaobd.servlet;

import br.com.bmrt.conexaobd.dao.VendasDAO;
import br.com.bmrt.conexaobd.entidade.Venda;
import br.com.bmrt.conexaobd.utils.Redirect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago Gilabel de Souza
 */

public class AlterarVendaServlet extends HttpServlet {

    private Integer idVendaAtual;

    // CARREGAR INFO DO CLIENTE
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer id_venda = Integer.parseInt(request.getParameter("id_venda"));
        idVendaAtual = id_venda;

        Venda venda = VendasDAO.getVendas(id_venda);

        request.setAttribute("venda", venda);

        request.getRequestDispatcher("/cadastrar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id_venda = Integer.parseInt(request.getParameter("id_venda"));
        String vendedor = request.getParameter("vendedor");
        Integer id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        Integer id_loja = Integer.parseInt(request.getParameter("id_loja"));
        Integer id_produto = Integer.parseInt(request.getParameter("id_produto"));
        Double id_valor = Double.parseDouble(request.getParameter("id_valor"));
        String forma_pagamento = request.getParameter("forma_pagamento");
        String status = request.getParameter("status");
        Double desconto = Double.parseDouble(request.getParameter("desconto"));
        Double valor_final = Double.parseDouble(request.getParameter("valor_final"));
        String data_venda = request.getParameter("data_venda");

        Venda venda = new Venda(id_venda, vendedor, id_cliente, id_loja, id_produto, id_valor, forma_pagamento, status, desconto, valor_final, data_venda);
        

        boolean ok = VendasDAO.atualizar(venda);

        Redirect.sendRedirect(ok, response);
    }
    
}
