package br.com.sistema.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() {
        try {
            //Laura: configurei a senha para ser puxada pelas variaveis de sistema
            String senhaBD = System.getenv("pgAdmin");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/PacAdmin", "postgres", senhaBD);
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }
}
