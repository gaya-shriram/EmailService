<%-- 
    Document   : Result
    Created on : Aug 20, 2016, 7:45:01 PM
    Author     : Gaya
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="Include/Styles/default.css" type="text/css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
    <center>
        <div class="page-header">
            <h1>Email-Message Board Service</h1>
        </div>
        <h2>${action}</h2>
        <c:if test="${param.action=='create'}">
            <form action ="MessageBoard" method="post">
                <input type="hidden" name="action" value="create">
                <input type="hidden" name="username" value="${param.username}" />
                <table>
                    <tr>
                        <td><b>Message</b></td>
                        <td><textarea rows="10" cols="39" name="message"></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Create" /></td>
                    </tr>
                </table>
            </form>
        </c:if>
        <c:if test="${param.action=='update'}">
            <form action ="MessageBoard" method="post">
                <input type="hidden" name="action" value="update"> 
                <input type="hidden" name="id" value="${param.id}">
                <input type="hidden" name="username" value="${param.username}" />
                <table>
                    <tr>
                        <td><b>Message</b></td>
                        <td><textarea rows="10" cols="39" name="message" >${param.message}</textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Update" /></td>
                    </tr>
                </table>
            </form>
        </c:if>
    </center>
</body>
</html>
