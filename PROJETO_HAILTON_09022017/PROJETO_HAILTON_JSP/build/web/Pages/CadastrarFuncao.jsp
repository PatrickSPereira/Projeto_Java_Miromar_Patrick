<%-- 
    Document   : CadastrarFuncao
    Created on : 05/02/2017, 19:15:44
    Author     : Patrick
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset=UTF-8">
        <title>JSP Page</title>
    </head>
   
    <body>
         <c:import  url="menu.jsp" ></c:import>
        <h1>Cadastro de Funcao!</h1>
        <form action="./Funcao.do" method="post">
            <label>Descricao</label>
            <input type="text" name="descricaoFuncao" required="required"/>
            <input type="submit" value="Cadastrar"/>
        </form>
    </body>
</html>
