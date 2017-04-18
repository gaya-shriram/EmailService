<%-- 
    Document   : messageboard
    Created on : Aug 20, 2016, 9:32:08 PM
    Author     : Gaya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="Include/Styles/default.css" type="text/css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Email-Message Board</title>
        <style>
            table, th, td {
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <div class="page-header">
            <h1>Email-Message Board Service</h1>
        </div>

        <table style="width:100%">
            <tr>
                <th>ID</th>
                <th>Message</th> 
                <th>UserName</th>
                <th>Action</th>
                <th>Action</th>
                <th>Action</th>

            </tr>
            <tbody>
                <c:forEach items="${messages}" var="msg">
                    <tr>
                        <td><b><c:out value="${msg.id}" /></b></td>
                        <td><b><c:out value="${msg.message}" /></b></td>
                        <td><b><c:out value="${msg.username}" /></b></td>
                        <td><a href="email.jsp?action=share&message=<c:out value="${msg.message}"/>&username=<c:out value="${param.username}"/>">Share</a></td>
                        <td><a href="upsertmessage.jsp?action=update&id=<c:out value="${msg.id}"/>&message=<c:out value="${msg.message}"/>&username=<c:out value="${param.username}"/>">Update</a></td>
                        <td><a href="MessageBoard?action=delete&id=<c:out value="${msg.id}"/>&username=<c:out value="${param.username}" />">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <a href="upsertmessage.jsp?action=create&username=<c:out value="${param.username}"/>">Create</a>
    </body>
</html>
