<%-- 
    Document   : Menu
    Created on : 14-Jul-2021, 15:25:56
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu">
    <img src="images/menu_bg.gif" alt=""/>
    <div class="all_menu">
        <c:if test="${sessionScope.user.role==1}">
            <a href="#">Home</a>
            <a href="StartQuizPage.jsp">Take Quiz</a>
            <a href="MakeQuizPage.jsp">Make Quiz</a>
            <a href="manage">Manage Quiz</a>
            <a href="logout">Log out</a>
        </c:if>
        <c:if test="${sessionScope.user.role==2}">
            <a href="#">Home</a>
            <a href="StartQuizPage.jsp">Take Quiz</a>
            <a href="logout">Log out</a>
        </c:if>
    </div>
</div>