/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bmrt.conexaobd.dao;

import br.com.bmrt.conexaobd.conexao.Conexao;
import br.com.bmrt.conexaobd.entidade.Loja;
import br.com.bmrt.conexaobd.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago Gilabel de Souza
 */
public class LojaDAO {

    /**
     *
     * @param loja
     * @return
     */
    public static boolean cadastrar(Loja loja) {
        boolean ok = true;
        String query = "insert into lojas(id_loja, nome_loja, tipo_loja, endereco, telefone, id_cliente) values (?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, loja.getId_loja());
            ps.setString(2, loja.getNome_loja());
            ps.setString(3, loja.getTipo_loja());
            ps.setString(4, loja.getEndereco());
            ps.setString(5, loja.getTelefone());
            ps.setInt(6, loja.getId_cliente());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    /**
     *
     * @return
     */
    public static List<Loja> getLojas() {
        List<Loja> lojas = new ArrayList<>();
        String query = "select * from lojas";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id_loja = rs.getInt("id_loja");
                String nome_loja = rs.getString("nome_loja");
                String tipo_loja = rs.getString("tipo_loja");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                Integer id_cliente = rs.getInt("id_cliente");
                Loja loja = new Loja(id_loja, nome_loja, tipo_loja, endereco, telefone, id_cliente);

                lojas.add(loja);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lojas;
    }

    /**
     *
     * @param id_loja
     * @return
     */
    public static Loja getLoja(Integer id_loja) {
        Loja loja = null;
        String query = "select * from lojas where id_loja=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_loja);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                loja = Utils.popularLoja(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loja;
    }

    /**
     *
     * @param id_loja
     *
     * @return
     */
    public static boolean deletar(Integer id_loja) {
        System.out.println(id_loja);
        boolean ok = true;
        String queryLojas = "delete from lojas where id_loja=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(queryLojas);
            ps.setInt(1, id_loja);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    /**
     *
     * @param loja
     * @return
     */
    public static boolean atualizar(Loja loja) {
        boolean ok = true;
        String query = "update lojas set nome_loja=?, tipo_loja=?, endereco=?, telefone=?, id_cliente=? where id_loja=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, loja.getNome_loja());
            ps.setString(2, loja.getTipo_loja());
            ps.setString(3, loja.getEndereco());
            ps.setString(4, loja.getTelefone());
            ps.setInt(5, loja.getId_cliente());
            ps.setInt(6, loja.getId_loja());

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LojaDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

}
