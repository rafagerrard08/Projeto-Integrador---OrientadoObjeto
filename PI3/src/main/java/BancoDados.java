import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mindrot.jbcrypt.BCrypt;

public class BancoDados {

    public static int registar( String usuario, String senha ){
        int id = 0;
        String query = "INSERT INTO USUARIO( USUARIO, SENHA ) VALUES( ?, ? )";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            String geradoSenha = BCrypt.gensalt();
            String senhaCrypt = BCrypt.hashpw( usuario, geradoSenha);
            
            ps.setString(1, usuario);
            ps.setString(2, senhaCrypt);
            
            ps.executeUpdate( );
            
            id = login( usuario, senha );
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public static int login( String usuario, String senha ){
        int id = 0;
        String query = "SELECT * FROM USUARIO WHERE USUARIO = ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            String geradoSenha = BCrypt.gensalt();
            String senhaCrypt = BCrypt.hashpw( usuario, geradoSenha);
            
            ps.setString(1, usuario);
            
            System.out.println("senhaCrypt:"+ senhaCrypt);
                    
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                String senhaCripto = rs.getString("SENHA");
                
                if (BCrypt.checkpw(senha, senhaCripto)) {
                    id = rs.getInt("ID");
                } else {
                    id = 0;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
   public static List<Loja> getLoja() {
        List<Loja> ljs = new ArrayList<>();
        String query = "select * from LOJA";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("ID");
                String nome = rs.getString("NOME");
                
                Loja lj = new Loja( id, nome );
                
                ljs.add(lj);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ljs;
    }
        
   public static List<FormasPgto> getFormasPgto() {
        List<FormasPgto> formasPgto = new ArrayList<>();
        String query = "select * from FORMA_PGTO";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                int id = rs.getInt("ID");
                String nome = rs.getString("FORMA");
                
                FormasPgto forma = new FormasPgto( id, nome );
                
                formasPgto.add(forma);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formasPgto;
    }
    
   public static boolean cadastrarCliente( Cliente cliente ) {
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
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
   
   public static boolean deletarCliente(String id) {
        boolean ok = true;
        String query = "UPDATE CLIENTE SET STATUS='Inativo' WHERE ID=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
   
   public static boolean atualizarCliente(Cliente cliente) {
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
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
   
   public static boolean cadastrarProduto(Produto produto) {
        boolean ok = true;
        String query = "INSERT INTO PRODUTO( ID_LOJA, NOME, QTD_PRODUTO, VALOR, ID_CATEGORIA_PRODUTO, COR, MARCA, STATUS ) VALUES (?,?,?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, produto.getId_loja());
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getQtd_produto());
            ps.setDouble(4, produto.getValor());
            ps.setInt(5, produto.getId_categoria());
            ps.setString(6, produto.getCor());
            ps.setString(7, produto.getMarca());
            ps.setString(8, "Ativo");
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
   
   public static List<Produto> getProdutosEmEstoque( String id_loja ) {
        List<Produto> produtos = new ArrayList<>();
        String query = "select * from produto where status = 'Ativo' AND QTD_PRODUTO > 0 AND ID_LOJA=" + id_loja;
        Connection con;

        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id_produto = rs.getInt("ID");
                String nome = rs.getString("NOME");
                Integer qtd_produto = rs.getInt("QTD_PRODUTO");
                Double valor = rs.getDouble("VALOR");
                Integer id_categoria = rs.getInt("ID_CATEGORIA_PRODUTO");
                String cor = rs.getString("COR");
                String marca = rs.getString("MARCA");
                
                String categoria = getNomeCategoria( id_categoria );
                
                Produto produto = new Produto( Integer.parseInt( id_loja ), nome, qtd_produto, valor, id_categoria, cor, marca );
                produto.setId_produto( id_produto );
                produto.setCategoria(categoria);
                
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
    
    public static Loja getLoja( int id ) {
        Loja loja = null;
        String query = "select * from LOJA WHERE id = ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                String nome = rs.getString("NOME");
                
                loja = new Loja( id, nome );
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loja;
    }
    
    public static List<CategoriaProduto> getCategorias() {
        List<CategoriaProduto> categorias = new ArrayList<>();
        String query = "select * from CATEGORIA_PRODUTO";
        Connection con;

        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id_cat = rs.getInt("ID");
                String nome = rs.getString("NOME");
                
                CategoriaProduto cat = new CategoriaProduto( nome );
                cat.setIdBanco( id_cat );
                
                categorias.add(cat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorias;
    }
    
    public static String getNomeCategoria( int id ) {
        String nomeCategoria = null;
        String query = "select * from CATEGORIA_PRODUTO WHERE id = ?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                String nome = rs.getString("NOME");
                nomeCategoria = nome;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nomeCategoria;
    }
    
    public static List<Produto> getProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String query = "select * from produto where status = 'Ativo'";
        Connection con;

        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id_produto = rs.getInt("ID");
                Integer id_loja = rs.getInt("ID_LOJA");
                String nome = rs.getString("NOME");
                Integer qtd_produto = rs.getInt("QTD_PRODUTO");
                Double valor = rs.getDouble("VALOR");
                Integer id_categoria = rs.getInt("ID_CATEGORIA_PRODUTO");
                String cor = rs.getString("COR");
                String marca = rs.getString("MARCA");
                
                String categoria = getNomeCategoria( id_categoria );
                
                Produto produto = new Produto( id_loja, nome, qtd_produto, valor, id_categoria, cor, marca );
                produto.setId_produto( id_produto );
                produto.setCategoria(categoria);
                
                if( getLoja( id_loja ) != null )
                {
                    produto.setNome_loja( getLoja( id_loja ).getNome( ) );
                }
                
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produtos;
    }
    
    public static Produto getProduto(Integer id_produto) {
        Produto produto = null;
        String query = "select * from produto where id=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_produto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Integer id_loja = rs.getInt("ID_LOJA");
                String nome = rs.getString("NOME");
                Integer qtd_produto = rs.getInt("QTD_PRODUTO");
                Double valor = rs.getDouble("VALOR");
                Integer id_categoria = rs.getInt("ID_CATEGORIA_PRODUTO");
                String cor = rs.getString("COR");
                String marca = rs.getString("MARCA");

                String categoria = getNomeCategoria( id_categoria );
                
                produto = new Produto( id_loja, nome, qtd_produto, valor, id_categoria, cor, marca);
                produto.setId_produto( id_produto );
                produto.setCategoria(categoria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    public static boolean atualizarProduto(Produto produto) {
        boolean ok = true;
        String query = "UPDATE PRODUTO SET ID_LOJA=?, NOME=?, QTD_PRODUTO=?, VALOR=?, ID_CATEGORIA_PRODUTO=?, COR=?, MARCA=? WHERE ID=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, produto.getId_loja());
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getQtd_produto());
            ps.setDouble(4, produto.getValor());
            ps.setInt(5, produto.getId_categoria());
            ps.setString(6, produto.getCor());
            ps.setString(7, produto.getMarca());
            ps.setInt(8, produto.getId_produto());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    public static boolean deletarProduto(Integer id_produto) {
        boolean ok = true;
        String query = "UPDATE PRODUTO SET STATUS='Inativo' WHERE ID=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_produto);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    
    public static boolean diminuiEstoqueProduto( int id ) {
        boolean ok = true;
        String query = "UPDATE PRODUTO SET QTD_PRODUTO=QTD_PRODUTO-1 WHERE ID =?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;        
    }
    
    public static boolean cadastrarVenda( Venda venda ) {
        boolean ok = true;
        String query = "INSERT INTO VENDA(NOME_VENDEDOR, ID_CLIENTE, ID_LOJA, ID_PRODUTO, ID_CATEGORIA_PRODUTO, VALOR_DESCONTO, VALOR_FINAL, ID_FORMA_PGTO ) VALUES (?,?,?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, venda.getNomeVendedor());
            ps.setInt(2, venda.getId_cliente());
            ps.setInt(3, venda.getId_loja());
            ps.setInt(4, venda.getId_produto());
            
            ps.setInt(5, getProduto( venda.getId_produto() ).getId_categoria( ) );
            
            double valor_final = venda.getValor() - venda.getDesconto();
            
            ps.setDouble(6, valor_final);
            ps.setDouble(7, venda.getDesconto());
            ps.setInt(8, venda.getId_formaPagamento());
         
            if( diminuiEstoqueProduto( venda.getId_produto() ) == false )
            {
                ok = false;
            }
            else
            {
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    
   public static List<Venda> getVendas() {
        List<Venda> vendas = new ArrayList<>();
        String query = "select * from VENDA";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String nome_vendedor = rs.getString("NOME_VENDEDOR");
                int id_cliente = rs.getInt("ID_CLIENTE");
                int id_loja = rs.getInt("ID_LOJA");
                int id_produto = rs.getInt("ID_PRODUTO");
                double valor_desconto = rs.getDouble("VALOR_DESCONTO");
                double valor_final = rs.getDouble("VALOR_FINAL");
                int id_forma_pgto = rs.getInt("ID_FORMA_PGTO");
                Date data_venda = rs.getDate("DATA_VENDA");
                int    id     = rs.getInt("ID");
        
                Venda venda = new Venda( nome_vendedor, id_cliente, id_loja, id_produto, valor_desconto, valor_final, id_forma_pgto );
                venda.setIdBanco(id);
                venda.setData_venda(data_venda);
                venda.setNome_produto( getProduto( id_produto ).getNome( ) ); 
                venda.setNome_loja( getLoja( id_loja ).getNome( ) ); 
                
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }

   public static List<Venda> getVendas( String dataInicial, String dataFinal, String id_cat_prod, String id_cliente, String id_loja ) {
        List<Venda> vendas = new ArrayList<>();
        
        Connection con;
        try {
            String query = "select * from VENDA WHERE ";
            con = Conexao.getConexao();
            
            if( id_cliente.isEmpty( ) == false ){
                query = query + "ID_CLIENTE = " + id_cliente + " AND ";
            }

            if( id_loja.isEmpty( ) == false ){
                query = query + "ID_LOJA = " + id_loja + " AND ";
            }

            if( id_cat_prod.isEmpty( ) == false ){
                query = query + "ID_CATEGORIA_PRODUTO = " + id_cat_prod + " AND ";
            }
            
            if( dataInicial.isEmpty( ) == false &&
                dataFinal.isEmpty( ) == true ){
                query = query + "DATA_VENDA >= ? AND ";
            }
            else if( dataInicial.isEmpty( ) == true &&
                     dataFinal.isEmpty( ) == false ){
                query = query + "DATA_VENDA <= ? AND ";
            }
            else if( dataInicial.isEmpty( ) == false &&
                     dataFinal.isEmpty( ) == false ){
                query = query + "DATA_VENDA BETWEEN ? AND ?";
            }
            
            if( query.substring( query.length() - 4 ).equals( "AND " ) ){
                query = query.substring( 0, query.length() - 4 );
            }
            
            System.out.println("query[" + query + "]");
            PreparedStatement ps = con.prepareStatement(query);
            
            if( dataInicial.isEmpty( ) == false &&
                dataFinal.isEmpty( ) == true ){
                Date date = Date.valueOf(dataInicial);
                ps.setDate(1, date);
            }
            else if( dataInicial.isEmpty( ) == true &&
                     dataFinal.isEmpty( ) == false ){
                Date date = Date.valueOf(dataFinal);
                ps.setDate(1, date);
            }
            else if( dataInicial.isEmpty( ) == false &&
                     dataFinal.isEmpty( ) == false ){
                Date dateI = Date.valueOf(dataInicial);
                Date dateF = Date.valueOf(dataFinal);
                ps.setDate(1, dateI);
                ps.setDate(2, dateF);
            }
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String nome_vendedor = rs.getString("NOME_VENDEDOR");
                id_cliente = rs.getString("ID_CLIENTE");
                id_loja = rs.getString("ID_LOJA");
                int id_produto = rs.getInt("ID_PRODUTO");
                double valor_desconto = rs.getDouble("VALOR_DESCONTO");
                double valor_final = rs.getDouble("VALOR_FINAL");
                int id_forma_pgto = rs.getInt("ID_FORMA_PGTO");
                Date data_venda = rs.getDate("DATA_VENDA");
                int    id     = rs.getInt("ID");
        
                Venda venda = new Venda( nome_vendedor, Integer.parseInt( id_cliente ), Integer.parseInt( id_loja ), id_produto, valor_desconto, valor_final, id_forma_pgto );
                venda.setIdBanco(id);
                venda.setData_venda(data_venda);
                venda.setNome_produto( getProduto( id_produto ).getNome( ) ); 
                venda.setNome_loja( getLoja( Integer.parseInt( id_loja ) ).getNome( ) ); 
                
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vendas;
    }
   
    public static boolean deletarVenda(Integer id_venda) {
        boolean ok = true;
        String query = "DELETE FROM VENDA WHERE ID=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id_venda);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
}


