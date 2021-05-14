/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bmrt.conexaobd.dao;

import br.com.bmrt.conexaobd.conexao.Conexao;
import br.com.bmrt.conexaobd.entidade.Produto;
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
 * @author rafaelFerraz
 */
public class ProdutoDAO {

    /**
     *
     * @param produto
     * @return
     */
    public static boolean cadastrar(Produto produto) {
        boolean ok = true;
        String query = "insert into produto(id_produto, id_loja, nome, qtd_produto, valor, categoria, cor, marca) values (?,?,?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, produto.getId_produto());
            ps.setInt(2, produto.getId_loja());
            ps.setString(3, produto.getNome());
            ps.setInt(4, produto.getQtd_produto());
            ps.setDouble(5, produto.getValor());
            ps.setString(6, produto.getCategoria());
            ps.setString(7, produto.getCor());
            ps.setString(8, produto.getMarca());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    /**
     *
     * @return
     */
    public static List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String query = "select * from produto";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id_produto = rs.getInt("id_produto");
                Integer id_loja = rs.getInt("id_loja");
                String nome = rs.getString("nome");
                Integer qtd_produto = rs.getInt("qtd_produto");
                Double valor = rs.getDouble("valor");
                String categoria = rs.getString("categoria");
                String cor = rs.getString("cor");
                String marca = rs.getString("marca");
                Produto produto = new Produto(id_produto, id_loja, nome, qtd_produto, valor, categoria, cor, marca);

                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }

    /**
     *
     * @param id_produto
     * @return
     */
    public static Produto getProduto(Integer id_produto) {
        Produto produto = null;
        String query = "select * from produto where id_produto=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_produto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                produto = Utils.popularProduto(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    /**
     *
     * @param id_produto
     * @return
     */
    public static boolean deletar(Integer id_produto) {
        System.out.println("Deletar ID:" + id_produto);
        boolean ok = true;
        String query = "delete from produto where id_produto=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_produto);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    /**
     *
     * @param produto
     * @return
     */
    public static boolean atualizar(Produto produto) {
        boolean ok = true;
        String query3 = "update produto set id_loja=?, nome=?, qtd_produto=?, valor=?, categoria=?, cor=?, marca=? where id_produto=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query3);
            
            ps.setInt(1, produto.getId_loja());
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getQtd_produto());
            ps.setDouble(4, produto.getValor());
            ps.setString(5, produto.getCategoria());
            ps.setString(6, produto.getCor());
            ps.setString(7, produto.getMarca());
            ps.setInt(8, produto.getId_produto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

}
