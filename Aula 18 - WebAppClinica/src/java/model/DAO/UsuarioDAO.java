/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;
import config.ConectaDB;
import java.sql.*;

/**
 *
 * @author alunocmc
 */
public class UsuarioDAO {
    public boolean logar(String usuario, String senha) throws ClassNotFoundException{
        Connection conn = null;        
        try{           
            conn = ConectaDB.conectar();
            Statement stmt = conn.createStatement();
            //            SELECT * FROM usuarios WHERE email='admin@umc.br' and senha='987654'
            String sql = "SELECT * FROM usuarios WHERE email='" + usuario + "' and senha='" + senha + "'";
            ResultSet rs = stmt.executeQuery(sql);
            
            // Apresentar o resultado do "rs"
            int n_reg = 0;
            while (rs.next()){                                                                            
                n_reg++;
            }            
            conn.close();
            
            if (n_reg > 0){
                return true;
            }else{             
                return false;
            }            
        }catch(SQLException ex){
            return false;
        }        
    }
}
