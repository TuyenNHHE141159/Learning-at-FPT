<%-- 
    Document   : TakeQuizPage
    Created on : 15-Jul-2021, 15:27:29
    Author     : User
--%>

<%@page import="java.util.List"%>
<%@page import="modal.Quiz"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="container">
            <div class="header"></div>
            <div class="menu">
                <img src="images/menu_bg.gif" alt=""/>
                <div class="all_menu">
                    <c:if test="${sessionScope.user.role==1&&sessionScope.list==null}">
                        <a href="home">Home</a>
                        <a href="StartQuizPage.jsp">Take Quiz</a>
                        <a href="MakeQuizPage.jsp">Make Quiz</a>
                        <a href="manage">Manage Quiz</a>
                        <a href="logout">Log out</a>
                    </c:if>
                    <c:if test="${sessionScope.user.role==2&&sessionScope.list==null}">
                        <a href="home">Home</a>
                        <a href="StartQuizPage.jsp">Take Quiz</a>
                        <!--                        <a href="#">Make Quiz</a>
                                                <a href="#">Manage Quiz</a>-->
                        <a href="logout">Log out</a>
                    </c:if>
                    <c:if test="${sessionScope.user.role==1&&sessionScope.list!=null}">
                        <a href="#">Home</a>
                        <a href="#">Take Quiz</a>
                        <a href="#">Make Quiz</a>
                        <a href="#">Manage Quiz</a>
                        <a href="#">Log out</a>
                    </c:if>
                    <c:if test="${sessionScope.user.role==2&&sessionScope.list!=null}">
                        <a href="#">Home</a>
                        <a href="#">Take Quiz</a>
                        <!--                        <a href="#">Make Quiz</a>
                                                <a href="#">Manage Quiz</a>-->
                        <a href="#">Log out</a>
                    </c:if>
                </div>
            </div>
            
            <div class="main">
                <div class="title">Welcome <span class="user">${sessionScope.user.name}</span></div>
                <div class="title timer">Time Remaining <span id="t"></span></div><br>
                    <c:forEach items="${list}" var="item">
                    <div class="perQuestion">
                        <div  class="questionx">${item.question}</div>
                        <form id="form" action="start-quiz" method="post">
                            <table>
                                <tr>
                                    <td><input type="checkbox" name="choice" value="1"></td>
                                    <td>${item.option1}</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" name="choice" value="2"></td>
                                    <td>${item.option2}</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" name="choice" value="3"></td>
                                    <td>${item.option3}</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" name="choice" value="4"></td>
                                    <td>${item.option4}</td>
                                </tr>
                            </table>
                            <button id="btn" onclick="nextQuestion(${item.id})" type="button">Next</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </div>
        <script src="javascript/js.js" type="text/javascript"></script>
        <script>
                                setValue(${tag}, '${txt}',${total});
                                display();
                                timer();
                                setInterval(function () {
                                    timer();
                                }, 1000);
        </script>
    </body>
</html>
