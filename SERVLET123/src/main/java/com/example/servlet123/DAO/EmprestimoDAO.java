package com.example.servlet123.DAO;

import com.example.servlet123.conexaoBD.Conexao;
import com.example.servlet123.model.Emprestimo;
import com.example.servlet123.model.Livro;

import java.sql.*;
import java.util.ArrayList;

public class EmprestimoDAO {

    //insert
    public boolean inserir(Emprestimo emprestimo){
        Conexao conexao = new Conexao();
        Connection conn = null;

        try{
            conn = conexao.conectar();

            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO emprestimo(usuario_id, livro_id, data_emprestimo, data_devolucao_prevista, status) values (?, ?, ?, ? ,?)");;

            pstmt.setLong(1, emprestimo.getUsuario_id());
            pstmt.setLong(2, emprestimo.getLivro_id());
            pstmt.setDate(3, (Date) emprestimo.getData_emprestimo());
            pstmt.setDate(4, (Date) emprestimo.getData_devolucao_prevista());
            pstmt.setString(5, emprestimo.getStatus());

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
    public ArrayList<Emprestimo> buscar(){
        Conexao conexao = new Conexao();
        Connection conn = null;
        ArrayList<Emprestimo> busca = new ArrayList<>();

        try{
            conn = conexao.conectar();

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM emprestimo");

            while (rs.next()){
                busca.add(new Emprestimo(rs.getInt(1), rs.getLong(2), rs.getLong(3), rs.getDate(4), rs.getDate(5), rs.getString(6)));
            }

        }catch (SQLException sqlE){
            System.out.println(sqlE.getMessage());
        }finally {
            conexao.desconectar(conn);
            return busca;}
    }
    //update
    public int alterar(Emprestimo emprestimo){
        Conexao conexao = new Conexao();
        Connection conn = null;

        try {
            conn = conexao.conectar();
            PreparedStatement pstmt = conn.prepareStatement("UPDATE emprestimo set usuario_id = ?, livro_id = ?, data_emprestimo = ?, data_devolucao_prevista=?, status=? where id=?");

            pstmt.setLong(1, emprestimo.getUsuario_id());
            pstmt.setLong(2, emprestimo.getLivro_id());
            pstmt.setDate(3, (Date) emprestimo.getData_emprestimo());
            pstmt.setDate(4, (Date) emprestimo.getData_devolucao_prevista());
            pstmt.setString(5, emprestimo.getStatus());

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
    public int remover(int idEmprestimo){
        Conexao conexao = new Conexao();
        Connection conn = null;
        try {
            conn = conexao.conectar();

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM emprestimo WHERE id = ?");

            pstmt.setInt(1, idEmprestimo);

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
