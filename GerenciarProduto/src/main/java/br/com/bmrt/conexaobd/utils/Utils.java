package br.com.bmrt.conexaobd.utils;

import br.com.bmrt.conexaobd.entidade.Produto;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author rafaelFerraz
 */
public class Utils {

    /**
     *
     * @param ok
     * @param request
     * @param response
     * @throws IOException
     */
      public static void redirecionarURL(boolean ok, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (ok) {
            response.sendRedirect(request.getContextPath()+"/sucesso.jsp");
        } else {
            response.sendRedirect(request.getContextPath()+"/erro.jsp");
        }
    }

    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Produto popularProduto(ResultSet rs) throws SQLException {
        Integer id_produto = rs.getInt("id_produto");
        Integer id_loja = rs.getInt("id_loja");
        String nome = rs.getString("nome");
        Integer qtd_produto = rs.getInt("qtd_produto");
        Double valor = rs.getDouble("valor");
        String categoria = rs.getString("categoria");
        String cor = rs.getString("cor");
        String marca = rs.getString("marca");
        
        Produto produto = new Produto(id_produto, id_loja, nome, qtd_produto, valor, categoria, cor, marca);
        return produto;
    }

}
