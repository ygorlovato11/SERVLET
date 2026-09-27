<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.example.servlet123.model.Livro"%>
<%@ page import="java.util.ArrayList"%>
<%
    ArrayList<Livro> listar = (ArrayList<Livro>) request.getAttribute("Livros");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Resultado do Servlet</title>
    <link rel="icon" href="Imagem/livraria.png">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<h1>LIVROS</h1>
<a href="livro.html" class="Botao1">Criar livro</a>
<table id="tabela">
    <thead>
        <tr>
            <th>ID</th>
            <th>Titulo</th>
            <th>Autor</th>
            <th>ISBN</th>
            <th>Ano de Publicação</th>
            <th>Disponível</th>

        </tr>
    </thead>
    <tbody>
        <%for(int i =0; i<listar.size(); i++){%>
            <tr>
                <td><%=listar.get(i).getId()%></td>
                <td><%=listar.get(i).getTitulo()%></td>
                <td><%=listar.get(i).getAutor()%></td>
                <td><%=listar.get(i).getIsbn()%></td>
                <td><%=listar.get(i).getAno_publicacao()%></td>
                <td><%=listar.get(i).isDisponivel()%></td>
            </tr>
        <%}%>
    </tbody>
</table>




</body>
</html>