/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.Conexao ; 
import java.sql.*;
import javax.servlet.http.HttpSession;
 
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final String URL = "jdbc:mysql://localhost:3306/estoque"; // 🔹 coloque o nome do seu BD aqui
    private static final String USER = "root";
    private static final String PASS = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recebe os dados do formulário JSP
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");

        try {
            // Carrega o driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conecta ao banco
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Query para validar login
            String sql = "SELECT * FROM usuarios WHERE username = ? AND senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Login bem-sucedido
                HttpSession session = request.getSession();
                session.setAttribute("usuario", rs.getString("username"));
                response.sendRedirect("pagina_inicial_consultaGeral.jsp"); // 🔹 página principal pós-login
            } else {
                // Login inválido
                response.sendRedirect("pagina_inicial_consultaGeral.jsp?erro=true");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3>Erro ao conectar: " + e.getMessage() + "</h3>");
        }
    }
}