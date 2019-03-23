<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exemplo JSP + JSTL</h1>
        <%
            String nome = request.getParameter("nome");
            String dtNasc = request.getParameter("nascimento");
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(dtNasc, formatter);
            LocalDate outro = LocalDate.now().minusYears(date.getYear());
            
            request.setAttribute("nomeAttr", nome);
            request.setAttribute("idadeAttr", outro.getYear());
        %>
        <h2>Welcome <span style="text-decoration: underline"><c:out value="${nomeAttr}" /></span>  sua idade é <c:out value="${idadeAttr}" /> anos</h2>
        
        <c:forEach begin="0" end="99" var="contador">
            <h2>Teste <c:out value="${contador}" /></h2>
        </c:forEach>
    </body>
</html>
