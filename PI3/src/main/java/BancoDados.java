import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BancoDados {

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
        String query = "INSERT INTO PRODUTO( ID_LOJA, NOME, QTD_PRODUTO, VALOR, CATEGORIA, COR, MARCA, STATUS ) VALUES (?,?,?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, produto.getId_loja());
            ps.setString(2, produto.getNome());
            ps.setInt(3, produto.getQtd_produto());
            ps.setDouble(4, produto.getValor());
            ps.setString(5, produto.getCategoria());
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
                String categoria = rs.getString("CATEGORIA");
                String cor = rs.getString("COR");
                String marca = rs.getString("MARCA");
                Produto produto = new Produto( Integer.parseInt( id_loja ), nome, qtd_produto, valor, categoria, cor, marca );
                produto.setId_produto( id_produto );
                
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
                String categoria = rs.getString("CATEGORIA");
                String cor = rs.getString("COR");
                String marca = rs.getString("MARCA");
                Produto produto = new Produto( id_loja, nome, qtd_produto, valor, categoria, cor, marca );
                produto.setId_produto( id_produto );
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
                String categoria = rs.getString("CATEGORIA");
                String cor = rs.getString("COR");
                String marca = rs.getString("MARCA");

                produto = new Produto( id_loja, nome, qtd_produto, valor, categoria, cor, marca);
                produto.setId_produto( id_produto );
            }
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
        }
        return produto;
    }

    public static boolean atualizarProduto(Produto produto) {
        boolean ok = true;
        String query = "UPDATE PRODUTO SET ID_LOJA=?, NOME=?, QTD_PRODUTO=?, VALOR=?, CATEGORIA=?, COR=?, MARCA=? WHERE ID=?";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
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
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }

    public static boolean deletarProduto(Integer id_produto) {
        boolean ok = true;
        String query = "UPDATE PRODUTO SET STATUS='Inativo' WHERE ID_PRODUTO=?";
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

    public static boolean cadastrarVenda( Venda venda ) {
        boolean ok = true;
        String query = "INSERT INTO VENDA(NOME_VENDEDOR, ID_CLIENTE, ID_LOJA, ID_PRODUTO, VALOR_DESCONTO, VALOR_FINAL, ID_FORMA_PGTO ) VALUES (?,?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, venda.getNomeVendedor());
            ps.setInt(2, venda.getId_cliente());
            ps.setInt(3, venda.getId_loja());
            ps.setInt(4, venda.getId_produto());
            ps.setDouble(5, venda.getValor());
            ps.setDouble(6, venda.getDesconto());
            ps.setInt(7, venda.getId_formaPagamento());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BancoDados.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        return ok;
    }
    

}


