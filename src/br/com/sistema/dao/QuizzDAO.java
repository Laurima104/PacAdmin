package br.com.sistema.dao;

import br.com.sistema.jdbc.ConnectionFactory;
import br.com.sistema.model.Quizz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizzDAO {
    static public void salvar(Quizz quizz){
        String sql = "INSERT INTO tb_quizzes(pergunta, modulo) VALUES (?, ?)";
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, quizz.getPergunta());
            stmt.setInt(2, quizz.getModulo());
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    static public void atualizar(Quizz quizz){
        String sql = "UPDATE tb_quizzes SET pergunta = ? AND modulo = ? WHERE id = ?";
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, quizz.getPergunta());
            stmt.setInt(2, quizz.getModulo());
            stmt.setInt(3, quizz.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    static public void excluir(int id){
        String sql = "DELETE FROM tb_quizzes WHERE id = ?";
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    static public List<Quizz> listar(){
        String sql = "SELECT * FROM tb_quizzes ORDER BY id";
        
        List<Quizz> quizzes = new ArrayList<>();
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Quizz quizz = new Quizz();
                quizz.setId(rs.getInt(rs.getInt("id")));
                quizz.setPergunta(rs.getString("pergunta"));
                quizz.setModulo(rs.getInt("modulo"));
                quizzes.add(quizz);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return quizzes;
    }
    
    static public Quizz quizz(int id){
        String sql = "SELECT * FROM tb_quizzes WHERE id = ?";
        Quizz quizz = new Quizz();
        
        try{
            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                quizz.setId(rs.getInt("id"));
                quizz.setPergunta(rs.getString("pergunta"));
                quizz.setModulo(rs.getInt("modulo"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        
        return quizz;
    }
}
