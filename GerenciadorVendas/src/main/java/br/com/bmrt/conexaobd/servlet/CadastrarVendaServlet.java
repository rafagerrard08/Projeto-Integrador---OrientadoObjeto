package br.com.bmrt.conexaobd.servlet;

import br.com.bmrt.conexaobd.dao.VendasDAO;
import br.com.bmrt.conexaobd.entidade.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael Ferraz
 */

public class CadastrarVendaServlet extends HttpServlet {

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

        Venda venda = new Venda(id_venda, vendedor, id_loja, id_cliente, id_produto, id_valor, forma_pagamento, status, desconto, valor_final, data_venda);

        boolean ok = VendasDAO.cadastrar(venda);
        //boolean ok = true;

        if (ok) {
            response.sendRedirect("sucesso.jsp");
        } else {
            String msg = "Não foi possível inserir venda";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("erro.jsp").forward(request, response);

        }
    }
}
