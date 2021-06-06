
package br.com.bmrt.conexaobd.utils;

import java.io.IOException;
import br.com.bmrt.conexaobd.entidade.Venda;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rafael Ferraz
 */

public class Redirect {
    
    public static void sendRedirect(boolean ok, HttpServletResponse response) throws IOException {
        if (ok) {
            response.sendRedirect("sucesso.jsp");
        } else {
            response.sendRedirect("erro.jsp");
        }
    }
    public static Venda popularVenda(ResultSet rs) throws SQLException {
        Integer id_venda = rs.getInt("ID_VENDA");
        String vendedor = rs.getString("VENDEDOR");
        Integer id_cliente = rs.getInt("ID_CLIENTE");
        Integer id_loja = rs.getInt("ID_LOJA");
        Integer id_produto = rs.getInt("ID_PRODUTO");
        Double id_valor = rs.getDouble("ID_VALOR");
        String forma_pagamento = rs.getString("FORMA_PAGAMENTO");
        String status = rs.getString("STATUS");
        Double desconto = rs.getDouble("DESCONTO");
        Double valor_final = rs.getDouble("VALOR_FINAL");
        String data_venda = rs.getString("DATA_VENDA");
        
        Venda venda = new Venda(id_venda, vendedor, id_cliente, id_loja, id_produto, id_valor, forma_pagamento, status, desconto, valor_final, data_venda);
        return venda;
    }
}
