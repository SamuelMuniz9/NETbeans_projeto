/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Usuarios;
import util.Conexao;
import java.sql.*;
import java.util.ArrayList;



//crirar para o LOGIN
public class UsuarioDAO {

  private final String URL = "jdbc:mysql://localhost:3306/estoque";
    private final String USER = "root";
    private final String PASSWORD = "";

    public boolean validarLogin(Usuarios usuario) {
        boolean autenticado = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT * FROM usuarios WHERE username=? AND senha=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getSenha());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                autenticado = true;
                usuario.setTipo(rs.getString("tipo"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return autenticado;
    }
}
