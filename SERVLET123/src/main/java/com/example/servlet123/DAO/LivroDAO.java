package com.example.servlet123.DAO;

import com.example.servlet123.conexaoBD.Conexao;
import com.example.servlet123.model.Livro;

import java.sql.*;
import java.util.ArrayList;

public class LivroDAO {
    //insert
    public boolean inserir(Livro livro){
        Conexao conexao = new Conexao();
        Connection connection = null;

        try {
            connection = conexao.conectar();

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO livro (titulo, autor, isbn, ano_publicacao, disponivel) VALUES (?,?,?,?,?)");
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setString(3, livro.getIsbn());
            pstmt.setInt(4, livro.getAno_publicacao());
            pstmt.setBoolean(5, livro.isDisponivel());

            if(pstmt.executeUpdate() > 0){
                return true;
            }
            return false;

        } catch (SQLException e) {
            System.out.println("O erro foi: " +e);
            return false;
        }finally {
            conexao.desconectar(connection);
        }
    }
    //read
    public ArrayList<Livro> buscar(){
        Conexao conexao = new Conexao();
        Connection conn = null;
        ArrayList<Livro> busca = new ArrayList<>();
        try{
            conn = conexao.conectar();
            Statement pstmt = conn.createStatement();
            ResultSet rs = pstmt.executeQuery("SELECT * FROM livro ORDER BY 1");
        while(rs.next()){
            busca.add(new Livro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6)));
        }
    }catch (SQLException sqlE){
        System.out.println(sqlE.getMessage());
    }finally {
        conexao.desconectar(conn);
        return busca;}
    }
    //update
    public int alterar(Livro livro){
        Conexao conexao = new Conexao();
        Connection conn = null;

        try{
            conn = conexao.conectar();

            PreparedStatement pstmt = conn.prepareStatement("UPDATE livro set titulo = ?, autor = ?, isbn = ?, ano_publicacao =?, disponivel=? WHERE id = ? ");

            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setString(3, livro.getIsbn());
            pstmt.setInt(4,livro.getAno_publicacao());
            pstmt.setBoolean(5, livro.isDisponivel());
            pstmt.setInt(6, livro.getId());

            if (pstmt.executeUpdate() > 0){
                return 0;
            }
            return 1;
        }catch (SQLException sqlE){
            System.out.println(sqlE.getMessage());
            return -1;
        }finally {
            conexao.desconectar(conn);
        }
    }
    //delete
    public int remover(int idlivro) {
        Conexao conexao = new Conexao();
        Connection conn = null;
        try {
            conn = conexao.conectar();
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM livro WHERE id = ?");
            pstmt.setInt(1, idlivro);
            if (pstmt.executeUpdate() > 0) {
                return 1;
            }
            return 0;

        } catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
            return -1;
        } finally {
            conexao.desconectar(conn);
        }
    }
}//a