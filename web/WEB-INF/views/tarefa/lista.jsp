<%-- 
    Document   : formulario
    Created on : 03/05/2018, 20:00:28
    Author     : 201310383
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Lista de tarefas</h3>
        <a href="novaTarefa">adicionar tarefa</a>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Descrição</th>
                    <th>Finalizada</th>
                    <th>Data finalização</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${tarefas}" var="tarefa">
                    <tr>
                        <td>${tarefa.id}</td>
                        <td>${tarefa.descricao}</td>
                        <c:if test="${tarefa.finalizado eq false}">
                            <td>Não finalizada</td>
                        </c:if>
                        <c:if test="${tarefa.finalizado eq true}">
                            <td>Finalizada</td>
                        </c:if>
                        <td>
                            <fmt:formatDate
                                value="${tarefa.dataFinalizacao}"
                                pattern="dd/MM/yyy"/>
                        </td>
                        <td>
                            <a href="removeTarefa?id=${tarefa.id}">remover</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
