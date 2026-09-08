package br.com.sistema.dao;

import br.com.sistema.jdbc.ConnectionFactory;
import br.com.sistema.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {
    public Admin login(String email, String senha){
        String sql = "SELECT * FROM tb_admins WHERE email = ? AND senha = ?";
        
        try {
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet result = stmt.executeQuery();
            if(result.next()){
                Admin admin = new Admin();
                admin.setId(result.getInt("id"));
                admin.setNome(result.getString("nome"));
                admin.setEmail(result.getString("email"));
                admin.setSenha(result.getString("senha"));
                return admin;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
