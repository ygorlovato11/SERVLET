package com.example.servlet123.model;

import java.util.Date;

public class Livro {

    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int ano_publicacao;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor, String isbn, int ano_publicacao, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.ano_publicacao = ano_publicacao;
        this.disponivel = disponivel;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAno_publicacao() {
        return ano_publicacao;
    }

    public void setAno_publicacao(int ano_publicacao) {
        this.ano_publicacao = ano_publicacao;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "titulo: " + titulo + "\n" +
                "autor: " + autor + "\n" +
                "isbn: " + isbn + "\n" +
                "ano publicacao: " + ano_publicacao + "\n" +
                "disponivel: " + disponivel + "\n";
    }
}
