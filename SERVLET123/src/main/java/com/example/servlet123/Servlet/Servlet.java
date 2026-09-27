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
/// request = tudo que o navegador enviou pro servidor (os dados do formulário, a URL acessada, etc.)
/// response = a ferramenta que você usa pra devolver algo pro navegador (redirecionar pra outra página, mandar HTML de volta, etc.)
import java.io.*;
import java.util.ArrayList;

import com.example.servlet123.DAO.LivroDAO;
import com.example.servlet123.conexaoBD.Conexao;
import com.example.servlet123.model.Livro;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns = {"/Servlet", "/paginaInicio", "/criarLivro"})
public class Servlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Ygor🆖🆖🆖🆖🆖";
    }
    Conexao conexao = new Conexao();
    Livro livro = new Livro();
    LivroDAO livroDAO = new LivroDAO();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath(); //direciona para a paginaInicio, pois
        System.out.println(action); // action vale /paginaInicio
        if(action.equals("/paginaInicio")){
            verLivro(request,response);
        } else if(action.equals("/criarLivro")) {
            criaLivro(request,response);
        } else {
            response.sendRedirect("index.html");
        }
    }
    //Listar livros
    public void verLivro(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //response.sendRedirect("pagina.jsp"); //direciona pra pagina do jsp

        //criando um objeto q vai reeber os dados da classe livro(os dados vao vir dentro do arraylist)
        ArrayList<Livro> listar = livroDAO.buscar();

        //encaminhar a listagem p documento jsp
        request.setAttribute("Livros", listar);
        RequestDispatcher rd = request.getRequestDispatcher("pagina.jsp");//classe que trabalha requisições e respostas no servlet, até por isso, ali em cima eu importei o metodo de erro ServletException
        rd.forward(request,response); //encaminha o objeto lista pro documento pagina.jsp






//        //teste de recebimento dos dados
//        for (int i = 0; i < listar.size(); i++) {
//            System.out.println(listar.get(i).getId());
//            System.out.println(listar.get(i).getTitulo());
//            System.out.println(listar.get(i).getAutor());
//            System.out.println(listar.get(i).getIsbn());
//            System.out.println(listar.get(i).getAno_publicacao());
//            System.out.println(listar.get(i).isDisponivel());
//        }
    }
    //Criar livro
    public void criaLivro(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //temq fazer isso pra conseguir ver os dados boolean
        String disponivelTexto = request.getParameter("disponivel");
        boolean disponivel = disponivelTexto.equalsIgnoreCase("S");

        livro.setTitulo(request.getParameter("titulo"));
        livro.setAutor(request.getParameter("autor"));
        livro.setIsbn(request.getParameter("isbn"));
        livro.setAno_publicacao(Integer.parseInt(request.getParameter("ano_publicacao")));
        livro.setDisponivel(disponivel);

        livroDAO.inserir(livro);//inserir os parametros enviados direto no banco

        //após isso, vou redirecionar ele pra pagina.jsp
        response.sendRedirect("paginaInicio");
















        //        //teste de recebimento dos dados
//        System.out.println("titulo: "+ request.getParameter("titulo"));
//        System.out.println("autor: " + request.getParameter("autor"));
//        System.out.println("isbn: " + request.getParameter("isbn"));
//        System.out.println("ano_publicacao: " + request.getParameter("ano_publicacao"));
//        System.out.println("disppnivel? " + request.getParameter("disponivel"));
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