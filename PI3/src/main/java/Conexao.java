import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
   
    static {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public static Connection getConexao() throws SQLException {
        String url = "jdbc:derby://localhost:1527/bancoBRMT";
        String user = "root";
        String pass = "1234";
        return DriverManager.getConnection(url, user, pass);
    }
    
}
