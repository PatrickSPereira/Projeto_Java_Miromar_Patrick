<%-- 
    Document   : menu
    Created on : 14/02/2017, 22:51:23
    Author     : miromar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
        <title>Menu</title>
    </head>
    <body>
        <ul class="nav nav-pills">
          <li role="presentation" class="active"><a href="Pessoa.do?acao=home">Home</a></li>
          <li role="presentation"><a href="Pessoa.do?acao=lis"> Usuarios</a></li>
          <li role="presentation"><a href="Funcao.do?acao=lis"> Funcao</a></li>
          <li role="presentation"><a href="Login.do?acao=sair">Sair</a></li>
        </ul>    
    </body>
</html>
