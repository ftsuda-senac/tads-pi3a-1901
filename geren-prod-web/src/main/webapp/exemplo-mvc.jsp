<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Exemplo Servlet + JSP + JSTL (MVC)</h1>
        <h2>Welcome <span style="text-decoration: underline"><c:out value="${nomeAttr}" /></span>  sua idade é <c:out value="${idadeAttr}" /> anos</h2>

        <c:forEach begin="0" end="99" var="contador">
            <c:if test="${contador % 2 == 0}">
                <h2>Teste <c:out value="${contador}" /></h2>
            </c:if>
        </c:forEach>
    </body>
</html>
