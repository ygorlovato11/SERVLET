package com.example.servlet123.DAO;

import com.example.servlet123.conexaoBD.Conexao;
import com.example.servlet123.model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {

    //insert
    public boolean inserir(Usuario usuario){
        Conexao conexao = new Conexao();
        Connection conn = null;

        try{
            conn = conexao.conectar();

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO usuario(nome, email, senha, tipo) values (?, ?, ?, ?)");;

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setString(4, usuario.getTipo());

            if(pstmt.executeUpdate() > 0){
                return true;
            }
            return false;
        }catch (SQLException e) {
            System.out.println("O erro foi: " +e);
            return false;
        }finally {
            conexao.desconectar(conn);
        }





    }
    //read
    public ArrayList<Usuario> buscar(){
        Conexao conexao = new Conexao();
        Connection conn = null;
        ArrayList<Usuario> busca = new ArrayList<>();

        try{
            conn = conexao.conectar();

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM usuario");

            while (rs.next()){
                busca.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }

        }catch (SQLException sqlE){
            System.out.println(sqlE.getMessage());
        }finally {
            conexao.desconectar(conn);
            return busca;}
    }
    //update
    public int alterar(Usuario usuario){
        Conexao conexao = new Conexao();
        Connection conn = null;

        try {
            conn = conexao.conectar();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE usuario set nome = ?, email = ?, senha = ?, tipo =? where id=?");

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getEmail());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setString(4, usuario.getTipo());
            pstmt.setInt(5, usuario.getId());

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
    public int remover(int idUsuario){
        Conexao conexao = new Conexao();
        Connection conn = null;
        try {
            conn = conexao.conectar();

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM usuario where id = ?");

            pstmt.setInt(1, idUsuario);

            if (pstmt.executeUpdate() > 0) {
                return 1;
            }
            return 0;

        }catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
            return -1;
        } finally {
            conexao.desconectar(conn);
        }
    }
}
