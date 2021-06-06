/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bmrt.conexaobd.dao;

import br.com.bmrt.conexaobd.conexao.Conexao;
import br.com.bmrt.conexaobd.entidade.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.bmrt.conexaobd.utils.Redirect;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thiago Gilabel de Souza
 */
public class VendasDAO {

    public static boolean cadastrar(Venda venda) {
        boolean ok = true;
        String query = "insert into venda (id_venda, vendedor, id_cliente, id_valor, id_loja, id_produto, forma_pagamento, status, desconto, valor_final, data_venda) values (?,?,?,?,?,?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, venda.getId_venda());
            ps.setString(2, venda.getVendedor());
            ps.setInt(3, venda.getId_cliente());
            ps.setDouble(4, venda.getId_valor());
            ps.setInt(5, venda.getId_loja());
            ps.setInt(6, venda.getId_produto());
            ps.setString(7, venda.getForma_pagamento());
            ps.setString(8, venda.getStatus());
            ps.setDouble(9, venda.getDesconto());
            ps.setDouble(10, venda.getValor_final());
            ps.setString(11, venda.getData_venda());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    public static List<Venda> getVenda() {
        List<Venda> vendas = new ArrayList<>();
        String query = "select * from venda";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

    public static Venda getVendas(Integer id_venda) {
        Venda venda = null;
        String query = "select * from venda where id_venda=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_venda);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                venda = Redirect.popularVenda(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venda;
    }

    /**
     *
     * @param id_venda
     * @return
     */
    public static boolean deletar(Integer id_venda) {
        System.out.println("Deletar ID:" + id_venda);
        boolean ok = true;
        String query = "delete from venda where id_venda=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_venda);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    public static boolean atualizar(Venda venda) {
        boolean ok = true;
        String query = "update venda set vendedor=?, id_cliente=?, ID_LOJA=?, ID_PRODUTO=?, FORMA_PAGAMENTO=?, status=?, DESCONTO=?, ID_VALOR=?, VALOR_FINAL=?, DATA_VENDA=? where id_venda=?";
                /*+ "vendedor=?, "
                + "id_cliente=?, "
                + "ID_LOJA=?, "
                + "ID_PRODUTO=?, "
                + "FORMA_PAGAMENTO=?,"
                + "status=?, "
                + "DESCONTO=?, "
                + "ID_VALOR =?,"
                + ""
                + "DATA_VENDA = ? "
                + " where "
                + " id_venda=? ";*/

        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, venda.getVendedor());
            ps.setInt(2, venda.getId_cliente());
            ps.setInt(3, venda.getId_loja());
            ps.setInt(4, venda.getId_produto());
            ps.setString(5, venda.getForma_pagamento());
            ps.setString(6, venda.getStatus());
            ps.setDouble(7, venda.getDesconto());
            ps.setDouble(8, venda.getId_valor());
            ps.setDouble(9, venda.getValor_final());
            ps.setString(10, venda.getData_venda());
            ps.setInt(11, venda.getId_venda());
            

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VendasDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

}
