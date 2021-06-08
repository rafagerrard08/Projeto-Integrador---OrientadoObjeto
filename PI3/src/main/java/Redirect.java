
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;


public class Redirect {
    
    public static void sendRedirect(boolean ok, HttpServletResponse response) throws IOException {
        if (ok) {
            response.sendRedirect("sucesso.jsp");
        } else {
            response.sendRedirect("erro.jsp");
        }
    }
}
