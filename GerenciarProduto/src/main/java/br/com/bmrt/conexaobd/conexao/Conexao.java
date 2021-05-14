/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bmrt.conexaobd.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafaelFerraz
 */
public class Conexao {

    static {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return @throws SQLException
     */
    public static Connection getConexao() throws SQLException {
        String url = "jdbc:derby://localhost:1527/bmrt";
        String user = "bmrt";
        String pass = "bmrt";
        return DriverManager.getConnection(url, user, pass);
    }

}
