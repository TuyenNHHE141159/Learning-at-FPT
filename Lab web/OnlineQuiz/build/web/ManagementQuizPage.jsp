<%-- 
    Document   : ManagementQuizPage
    Created on : 15-Jul-2021, 15:25:49
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
        <div class="container manageContainer">
            <div class="header"></div>
            <jsp:include page="Menu.jsp"/>
            <jsp:include page="Menu_1.jsp"/>
            <div class="main">
                <div class="title">Number of question <span class="user">${numOfQuestion}</span></div>
                <table class="manage_quiz">
                    <tr class="manage_row">
                        <td class="mange_d"><span class="user">
                                <c:if test="${numOfQuestion!=0}">Question</c:if> 
                                </span></td>
                            <td><span class="user">
                                <c:if test="${numOfQuestion!=0}">
                                    DateCreated
                                </c:if>
                            </span></td>
                    </tr>
                    <c:forEach items="${listQuiz}" var="o">
                        <tr >
                            <td><div class="text">${o.question}</div></td>
                            <td>${o.createdDate}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>
