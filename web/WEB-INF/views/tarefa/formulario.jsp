<%-- 
    Document   : formulario
    Created on : 03/05/2018, 20:00:28
    Author     : 201310383
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Adicionar tarefas</h3>
        <form action="adicionaTarefa" method="post">
            Descrição: <br/>
            <textarea name="descricao" rows="5" cols="100"></textarea><br/>
            <input type="submit" value="Adicionar">
        </form>
    </body>
</html>
