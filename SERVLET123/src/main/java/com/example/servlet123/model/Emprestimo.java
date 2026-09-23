package com.example.servlet123.model;

import java.util.Date;

public class Emprestimo {

    private int id;
    private long usuario_id;
    private long livro_id;
    private Date data_devolucao_prevista;
    private Date data_emprestimo;
    private String status;

    public Emprestimo(int id, long usuario_id, long livro_id, Date data_devolucao_prevista, Date data_emprestimo, String status) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.livro_id = livro_id;
        this.data_devolucao_prevista = data_devolucao_prevista;
        this.data_emprestimo = data_emprestimo;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public long getLivro_id() {
        return livro_id;
    }

    public void setLivro_id(long livro_id) {
        this.livro_id = livro_id;
    }

    public Date getData_devolucao_prevista() {
        return data_devolucao_prevista;
    }

    public void setData_devolucao_prevista(Date data_devolucao_prevista) {
        this.data_devolucao_prevista = data_devolucao_prevista;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "id usuario: " + usuario_id + "\n" +
                "id livro: " + livro_id + "\n" +
                "data prevista pra devolucao: " + data_devolucao_prevista + "\n" +
                "status: " + status + "\n";

    }
}
