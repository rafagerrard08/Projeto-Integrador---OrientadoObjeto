/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bmrt.conexaobd.servlet;

import br.com.bmrt.conexaobd.dao.ProdutoDAO;
import br.com.bmrt.conexaobd.entidade.Produto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafaelFerraz
 */
public class CadastrarProdutosServlet extends HttpServlet {

    //PASSO 1 - RECUPERAR OS PARAMETROS
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
        Integer id_produto = Integer.parseInt(request.getParameter("id_produto"));
        Integer id_loja = Integer.parseInt(request.getParameter("id_loja"));
        Double valor = Double.parseDouble(request.getParameter("valor"));
        Integer qtd_produto = Integer.parseInt(request.getParameter("qtd_produto"));
        String nome = request.getParameter("nome");
        String categoria = request.getParameter("categoria");
        String cor = request.getParameter("cor");
        String marca = request.getParameter("marca");

        //PASSO 2 - INSERIR O PRODUTO NO BD
        Produto produto = new Produto(id_produto, id_loja, nome, qtd_produto, valor, categoria, cor, marca);
        boolean ok = ProdutoDAO.cadastrar(produto);

        // PASSO 3 - REDIRECIONAR PARA TELA DE SUCESSO/ERRO
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/sucesso.jsp");
        } else {
            String msg = "Não foi possível cadastrar o produto!";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);

        }

    }

}
