/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bia
 */
public class RegistrarUsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String nome = request.getParameter("USUARIO");
            String senha = request.getParameter("SENHA");

            int id = BancoDados.registar(nome, senha);
            
            if(id > 0) {
                Cookie ckID=new Cookie("userID",String.valueOf(id));
                response.addCookie(ckID);
                response.sendRedirect("pagInicial.jsp");
            } else {
                request.setAttribute("msgErro", "Erro ao registrar usuario");
                request.getRequestDispatcher("registrar.jsp").forward(request, response);
            }
    }
}
