package br.com.sistema.dao;

import br.com.sistema.jdbc.ConnectionFactory;
import br.com.sistema.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    static public void cadastrar(Usuario usuario){
        String sql = "INSERT INTO tb_usuarios (nome, email, senha) VALUES (?, ?, ?)";
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    static public List<Usuario> listar(){
        String sql = "SELECT * FROM tb_usuarios ORDER BY id";
        
        List<Usuario> usuarios = new ArrayList<>();
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setNivel(rs.getInt("nivel"));
                usuarios.add(usuario);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return usuarios;
    }
    
    static public void atualizar(Usuario usuario){
        String sql = "UPDATE tb_usuarios SET nome = ?, email = ?, senha = ?, nivel = ? WHERE id = ?";
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getNivel());
            stmt.setInt(5, usuario.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    static public void excluir(int id){
        String sql = "DELETE FROM tb_usuarios WHERE id=?";
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
