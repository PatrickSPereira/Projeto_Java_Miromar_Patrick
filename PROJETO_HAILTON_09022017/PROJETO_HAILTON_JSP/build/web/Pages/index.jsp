<%-- 
    Document   : index
    Created on : 13/02/2017, 23:05:03
    Author     : miromar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
    </head>
    <body>        
        <ul class="nav nav-pills">
          <li role="presentation" class="active"><a href="Pessoa.do?acao=home">Home</a></li>
          <li role="presentation"><a href="Pessoa.do?acao=lis"> Usuarios</a></li>
          <li role="presentation"><a href="Funcao.do?acao=lis"> Funcao</a></li>
          <li role="presentation"><a href="Login.do?acao=sair">Sair</a></li>
        </ul>                                  
        <h3>Seja bem vindo </h3>
    </body>
</html>
