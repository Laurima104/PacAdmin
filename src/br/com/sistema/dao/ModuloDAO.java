package br.com.sistema.dao;

import br.com.sistema.jdbc.ConnectionFactory;
import br.com.sistema.model.Modulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModuloDAO {
    static public void salvar(Modulo modulo){
        String sql = "INSERT INTO tb_modulos(titulo, conteudo) VALUES (?, ?)";
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, modulo.getTitulo());
            stmt.setString(2, modulo.getConteudo());
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    static public void atualizar(Modulo modulo){
        String sql = "UPDATE tb_modulos SET titulo = ?, conteudo = ? WHERE id = ?";
        
        try {
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, modulo.getTitulo());
            stmt.setString(2, modulo.getConteudo());
            stmt.setInt(3, modulo.getId());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    static public void excluir(int id){
        String sql = "DELETE FROM tb_modulos WHERE id = ?";
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    static public List<Modulo> listar(){
        String sql = "SELECT * FROM tb_modulos";
        
        List<Modulo> modulos = new ArrayList<>();
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Modulo modulo = new Modulo();
                modulo.setId(rs.getInt("id"));
                modulo.setTitulo(rs.getString("titulo"));
                modulo.setConteudo(rs.getString("conteudo"));
                modulos.add(modulo);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return modulos;
    } 
    
    static public Modulo modulo(int id){
        String sql = "SELECT * FROM tb_modulos WHERE id = ?";
        Modulo modulo = new Modulo();
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                modulo.setId(rs.getInt("id"));
                modulo.setTitulo(rs.getString("titulo"));
                modulo.setConteudo(rs.getString("conteudo"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return modulo;
    }
}
