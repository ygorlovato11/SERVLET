package com.example.servlet123.Servlet;
//doGet deve ser usado apenas para buscar e ler informaoces, sem alterar nada no banco de dados
// (ex: carregar a lista de livros, pesquisar um autor, etc).
//
//doPost deve ser usado para enviar e processar acoes
// (ex: cadastrar um usuario, registrar um empréstimo, fazer login).
//
//O comando request carrega os dados que o cliente enviou para o servidor
// (exemplo: formulário prenchido)
// O comando response devolve o resultado final ao navegador após a requisição

import java.io.*;

import com.example.servlet123.conexaoBD.Conexao;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = {"/Servlet", "/paginaInicio"})
public class Servlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Ygor🆖🆖🆖🆖🆖" +
                "Scott";
    }
    Conexao conexao = new Conexao();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String action = request.getServletPath(); //direciona para a paginaInicio, pois
        System.out.println(action); // action vale /paginaInicio
        if(action.equals("/paginaInicio")){
            Contatos(request,response);
        }
    }
    //Listar contatos
    public void Contatos(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("pagina.jsp"); //direciona pra pagina do jsp
    }



    public void destroy() {
    }
}














//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        response.setContentType("text/html");
//        PrintWriter outFile = response.getWriter();
//        //coiso inicial do html
//        outFile.println("<!DOCTYPE html>");
//        outFile.println("<html lang=\"pt-BR\">\n");
//        outFile.println("<head>");
//        outFile.println("<meta charset=\"UTF-8\">\n");
//        outFile.println("<title>🦣🦣🦣🦣</title>\n");
//        outFile.println("</head>");
//
//        outFile.println("<body>");
//        outFile.println("SIGMA BOY🫡🫡😶‍🌫️😶‍🌫️😶‍🌫️💣💣🗿🗿😎");
//
//        outFile.println("</body>");
//    }


//----------------------------------------------------------------------------------------------------
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<p>" + "THIAGO ESPARRINHA LENTO JULIANO GASPART" + "</p>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }