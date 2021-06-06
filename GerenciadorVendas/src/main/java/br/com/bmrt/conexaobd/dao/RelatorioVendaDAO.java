/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bmrt.conexaobd.dao;

/**
 *
 * @author Thiago Gilabel de Souza
 */


import br.com.bmrt.conexaobd.entidade.Venda;
import br.com.bmrt.conexaobd.conexao.Conexao;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.DateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Servlet;


public class RelatorioVendaDAO {

    public static List<Venda> getRelatorioVenda(){
        List<Venda> listaVendas = new ArrayList();
        String query;
        PreparedStatement ps = null;
        Date dataFormatada = null;
        try {
            Connection con = Conexao.getConexao();

            query = "select * from venda";
            ps = con.prepareStatement(query);

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
                Date data_venda = rs.getDate("DATA_VENDA");

                DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String dataString = formato.format(data_venda);

                Venda venda = new Venda(id_venda, vendedor, id_cliente, id_loja, id_produto, id_valor, forma_pagamento, status, desconto, valor_final, dataString);
                listaVendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }

    public static List<Venda> getDetalheRelatorioVenda(int id) throws SQLException {
        List<Venda> listaVendas = new ArrayList();
        try {
            Connection con = Conexao.getConexao();

            String query = "select * from detalhe_venda\n"
                    + "where  detalhe_venda.id_venda=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
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
                listaVendas.add(new Venda(id_venda, vendedor, id_cliente, id_loja, id_produto, id_valor, forma_pagamento, status, desconto, valor_final, data_venda));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);

        }
        return listaVendas;
    }

    public static List<Venda> getDetalheRelatorioVendaPorCategoria(String cat) throws SQLException {
        List<Venda> listaVendas = new ArrayList();
        try {
            Connection con = Conexao.getConexao();

            String query = "select produto.categoria, venda.data_venda,sub_total,detalhe_venda.cod_produto,detalhe_venda.qtd_vendida, detalhe_venda.id_venda, detalhe_venda.nome from detalhe_venda\n"
                    + " inner join venda on detalhe_venda.id_venda = venda.id_venda"
                    + " inner join produto on produto.cod_produto=detalhe_venda.cod_produto where categoria=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cat);
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

                Date data = rs.getDate("data_venda");
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String dataString = formato.format(data);

                listaVendas.add(new Venda(id_venda, vendedor, id_cliente, id_loja, id_produto, id_valor, forma_pagamento, status, desconto, valor_final, data_venda));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);

        }
        return listaVendas;
    }

    public static List<Venda> getDetalheRelatorioVendaPorCliente(int id_cliente){
        List<Venda> listaVendas = new ArrayList();
        String query;
        Date dataFormatada = null;
        try {
            Connection con = Conexao.getConexao();

            query = "select * from venda where id_cliente=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps = con.prepareStatement(query);
            ps.setInt(1, id_cliente);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id_venda = rs.getInt("ID_VENDA");
                String vendedor = rs.getString("VENDEDOR");
                Integer id_loja = rs.getInt("ID_LOJA");
                Integer id_produto = rs.getInt("ID_PRODUTO");
                Double id_valor = rs.getDouble("ID_VALOR");
                String forma_pagamento = rs.getString("FORMA_PAGAMENTO");
                String status = rs.getString("STATUS");
                Double desconto = rs.getDouble("DESCONTO");
                Double valor_final = rs.getDouble("VALOR_FINAL");
                 String data_venda = rs.getString("DATA_VENDA");

                Date data = rs.getDate("data_venda");
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String dataString = formato.format(data);

                Venda venda = new Venda(id_venda, vendedor, id_cliente, id_loja, id_produto, id_valor, forma_pagamento, status, desconto, valor_final, dataString);
                listaVendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }

    public static List<Venda> getDetalheRelatorioVendaPorLoja(int id_loja){
        List<Venda> listaVendas = new ArrayList();
        String query;
        Date dataFormatada = null;
        try {
            Connection con = Conexao.getConexao();

            query = "select * from venda where id_loja=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps = con.prepareStatement(query);
            ps.setInt(1, id_loja);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id_venda = rs.getInt("ID_VENDA");
                String vendedor = rs.getString("VENDEDOR");
                Integer id_cliente = rs.getInt("ID_CLIENTE");
                Integer id_produto = rs.getInt("ID_PRODUTO");
                Double id_valor = rs.getDouble("ID_VALOR");
                String forma_pagamento = rs.getString("FORMA_PAGAMENTO");
                String status = rs.getString("STATUS");
                Double desconto = rs.getDouble("DESCONTO");
                Double valor_final = rs.getDouble("VALOR_FINAL");
                 String data_venda = rs.getString("DATA_VENDA");

                Date data = rs.getDate("data_venda");
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String dataString = formato.format(data);

                Venda venda = new Venda(id_venda, vendedor, id_cliente, id_loja, id_produto, id_valor, forma_pagamento, status, desconto, valor_final, dataString);
                listaVendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return listaVendas;
    }
}
