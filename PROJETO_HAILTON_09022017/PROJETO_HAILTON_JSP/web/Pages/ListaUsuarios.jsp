

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        
        <title>Lista de Usuarios</title>
    </head>
    <body>
        <c:import  url="menu.jsp" ></c:import>
         <table border="1">

            <tr bgcolor="#CCCCCC">
               
                <td> NOME </td>
                <td> FUNÇÃO </td>               
                <td> LOGIN </td>
                <td> CURSO </td>
                <td> LATTES </td>   
                     
            </tr>
            
            
            <c:forEach items="${requestScope.lista}" var="usu">
            <tr>
                <td>${usu.pessNome}</td>
                <td>${usu.cafuDescricao}</td>
                <td>${usu.pessLogin}</td>
                <td>${usu.cursoDescricao}</td>
                <td>${usu.pessLattes}</td>
                  
            </tr>
            </c:forEach>
           
       <!--
            <button><a href="Pessoa.do?acao=lis"> Lista</a></button>
            <button><a href="Pessoa.do?acao=cadPessoa"> Cadastro</a></button>  
            <button><a href="Login.do?acao=sair"> Sair</a></button>  
       -->
            
         </table>
         
         <button><a href="Pessoa.do?acao=cadPessoa"> Cadastrar</a></button>  
    </body>
</html>

