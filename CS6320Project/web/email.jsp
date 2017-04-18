<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Send an e-mail</title>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="Include/Styles/default.css" type="text/css">

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="page-header">
            <h1>Email-Message Board Service</h1>
        </div>
        <form action="EmailSendingServlet" method="post">
            <input type="hidden" name="username" value="${param.username}" />
            <table border="0" width="35%" align="center">
                <caption><h2><b>Send New E-mail</b></h2></caption>
                <tr>
                    <td width="50%"><b>Recipient address</b> </td>
                    <td><input type="text" name="recipient" size="50"/></td>
                </tr>
                <tr>
                    <td><b>Subject</b> </td>
                    <td><input type="text" name="subject" size="50"/></td>
                </tr>
                <tr>
                    <td><b>Content </b></td>
                    <td><textarea rows="10" cols="39" name="content">${param.message}</textarea> </td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Send"/></td>
                </tr>
            </table>

        </form>
    </body>
</html>
