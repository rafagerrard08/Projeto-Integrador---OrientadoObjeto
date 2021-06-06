package br.com.bmrt.conexaobd.utils;

import br.com.bmrt.conexaobd.entidade.Loja;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thiago Gilabel de Souza 
 */
public class Utils {

    /**
     *
     * @param ok
     * @param response
     * @throws IOException
     */
    public static void sendRedirect(boolean ok, HttpServletResponse response) throws IOException {
        if (ok) {
            response.sendRedirect("sucesso.jsp");
        } else {
            response.sendRedirect("erro.jsp");
        }
    }

    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static Loja popularLoja(ResultSet rs) throws SQLException {
        Integer id_loja = rs.getInt("id_loja");
        String nome_loja = rs.getString("nome_loja");
        String tipo_loja = rs.getString("tipo_loja");
        String endereco = rs.getString("endereco");
        String telefone = rs.getString("telefone");
        Integer id_cliente = rs.getInt("id_cliente");
        
        Loja loja = new Loja(id_loja, nome_loja, tipo_loja, endereco, telefone, id_cliente);
        return loja;
    }
}
