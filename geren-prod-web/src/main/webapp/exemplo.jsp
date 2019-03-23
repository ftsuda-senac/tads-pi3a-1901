<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exemplo JSP</h1>
        <%
            String nome = request.getParameter("nome");
            String dtNasc = request.getParameter("nascimento");
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dtNasc, formatter);
            LocalDate outro = LocalDate.now().minusYears(date.getYear());
        %>
        <h2>Welcome <span style="text-decoration: underline"><%= nome %></span>  sua idade é <%= outro.getYear() %> anos</h2>
        <%
            for (int i = 0; i < 100; i++) {
            %>
        <h2>Teste <%= i%></h2>
        <%
            }
            %>
    </body>
</html>
