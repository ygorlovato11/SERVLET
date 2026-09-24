package com.example.servlet123.model;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String tipo;

    public Usuario(int id, String nome, String email, String senha, String tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "nome: " + nome + "\n" +
                "email:" + email + "\n" +
                "senha: " + senha + "\n" +
                "tipo: " + tipo + "\n";

    }
}
