/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.conexaobd.dao;

import br.senac.sp.conexaobd.conexao.Conexao;
import br.senac.sp.conexaobd.entidade.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author scarton
 */
public class ClienteDAO {
    
    public static boolean cadastrar( Cliente cliente ) {
        boolean ok = true;
        String query = "INSERT INTO CLIENTE (NOME, ENDERECO, EMAIL, DATA_NASCIMENTO, SEXO, TELEFONE, CPF, CNPJ, TIPO, STATUS) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getEmail());
            ps.setDate(  4, cliente.getDataNascimento( ));
            ps.setString(5, cliente.getSexo());
            ps.setString(6, cliente.getTelefone());
            ps.setString(7, cliente.getCpf());
            ps.setString(8, cliente.getCnpj());
            ps.setString(9, cliente.getTipo());
            ps.setString(10, cliente.getStatus());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    
   public static List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente where status = 'Ativo'";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String nome = rs.getString("NOME");
                String endereco = rs.getString("ENDERECO");
                String email = rs.getString("EMAIL");
                Date dataNascimento = rs.getDate("DATA_NASCIMENTO");
                String sexo = rs.getString("SEXO");
                String telefone = rs.getString("TELEFONE");
                String cpf = rs.getString("CPF");
                String cnpj = rs.getString("CNPJ");
                String tipo = rs.getString("TIPO");
                String status = rs.getString("STATUS");
                int    id     = rs.getInt("ID");
        
                Cliente cliente = new Cliente( nome, endereco, email, dataNascimento, sexo, telefone, cpf, cnpj, tipo, status );
                cliente.setIdBanco(id);
                
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }
   
    public static List<Cliente> getClientes( String nomeCliente ) {
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente where nome LIKE '%?%' AND status = 'Ativo'";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, nomeCliente);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                String nome = rs.getString("NOME");
                String endereco = rs.getString("ENDERECO");
                String email = rs.getString("EMAIL");
                Date dataNascimento = rs.getDate("DATA_NASCIMENTO");
                String sexo = rs.getString("SEXO");
                String telefone = rs.getString("TELEFONE");
                String cpf = rs.getString("CPF");
                String cnpj = rs.getString("CNPJ");
                String tipo = rs.getString("TIPO");
                String status = rs.getString("STATUS");
                int    id     = rs.getInt("ID");
        
                Cliente cliente = new Cliente( nome, endereco, email, dataNascimento, sexo, telefone, cpf, cnpj, tipo, status );
                cliente.setIdBanco(id);
                
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public static Cliente getCliente(String id) {
        Cliente cliente = null;
        String query = "select * from cliente where id=?";
        
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idDB = rs.getInt("ID");
                String nome = rs.getString("NOME");
                String endereco = rs.getString("ENDERECO");
                String email = rs.getString("EMAIL");
                Date dataNascimento = rs.getDate("DATA_NASCIMENTO");
                String sexo = rs.getString("SEXO");
                String telefone = rs.getString("TELEFONE");
                String tipo = rs.getString("TIPO");
                String status = rs.getString("STATUS");
                String cpf = rs.getString("CPF");
                String cnpj = rs.getString("CNPJ");
        
                cliente = new Cliente( nome, endereco, email, dataNascimento, sexo, telefone, cpf, cnpj, tipo, status );
                cliente.setIdBanco(idDB);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
   
   public static boolean deletar(String id) {
        System.out.println("Deletar ID:" + id);
        boolean ok = true;
        String query = "UPDATE CLIENTE SET STATUS='Inativo' WHERE ID=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
   
   public static boolean atualizar(Cliente cliente) {
        boolean ok = true;
        String query = "UPDATE CLIENTE SET NOME=?, ENDERECO=?, EMAIL=?, DATA_NASCIMENTO=?, SEXO=?, TELEFONE=?, CPF=?, CNPJ=?, TIPO=? WHERE ID=?";            
            
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getEmail());
            ps.setDate(  4, cliente.getDataNascimento());
            ps.setString(5, cliente.getSexo());
            ps.setString(6, cliente.getTelefone());
            ps.setString(7, cliente.getCpf());
            ps.setString(8, cliente.getCnpj());
            ps.setString(9, cliente.getTipo());
            ps.setInt(  10, cliente.getIdBanco());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    
    
}
