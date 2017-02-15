<%-- 
    Document   : ListaFuncao
    Created on : 05/02/2017, 19:00:25
    Author     : Patrick
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <c:import  url="menu.jsp" ></c:import>
        <h1>Lista Funcao!</h1>
        <table class="table-striped">
            <tr bgcolor="#CCCCCC">
                <td>Cod.</td>
                <td>Funcao</td>               
            </tr>

            <c:forEach items="${requestScope.lista}" var="funcao">
                <tr>
                   <td>${funcao.cafuPk}</td>
                   <td>${funcao.cafuDescricao}</td>
                </tr>
            </c:forEach>
                <button class="btn btn-danger"><a href="Funcao.do?acao=cadFuncao">Cadastro</a></button>       
                
        </table>        
    </body>
</html>
