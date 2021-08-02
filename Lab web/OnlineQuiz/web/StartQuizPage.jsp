<%-- 
    Document   : StartQuizPage
    Created on : 15-Jul-2021, 15:27:15
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>      
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="javascript/js.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div class="header"></div>
             <jsp:include page="Menu.jsp"/>
             <jsp:include page="Menu_1.jsp"/>
            <div class="main">
                <div class="title">Welcome <span class="user">${sessionScope.user.name}</span></div>
                <div class="title">Enter number of question:</div><br>
                <form action="start-quiz">
                    <input type="text" name="amount"><br>
                    <button type="submit">Start</button>
                </form>
            </div>
        </div>
    </body>
</html>
