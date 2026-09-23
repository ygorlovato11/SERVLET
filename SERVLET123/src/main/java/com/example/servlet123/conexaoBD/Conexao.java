package com.example.servlet123.conexaoBD;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    Dotenv dotenv = Dotenv.load();

    public Connection conectar(){
        Connection conn = null;

        try{
            Class.forName("org.postgresql.Driver");

            String user = dotenv.get("DB_USER");
            String pswrd = dotenv.get("DB_PASSWORD");
            String url = dotenv.get("DB_URL");

            conn = DriverManager.getConnection(user,pswrd,url);
            System.out.println("Conexxao realizada");
        } catch (SQLException | ClassNotFoundException  e) {
            System.out.println("Erro: " + e);
        }
        return conn;
    }

    public static void desconectar(Connection conn) throws SQLException{
        conn.close();
    }


}
