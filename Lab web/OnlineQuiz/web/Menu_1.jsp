<%-- 
    Document   : Menu
    Created on : 14-Jul-2021, 15:25:56
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="menu1">
    <div onclick="dropDown()">Menu</div>
    <div class="all_menu1">

        <c:if test="${sessionScope.user.role==1}">
            <div ><a href="#">Home</a></div>
            <div>    <a href="StartQuizPage.jsp">Take Quiz</a></div>
            <div>  <a href="MakeQuizPage.jsp">Make Quiz</a></div>
            <div> <a href="manage">Manage Quiz</a></div>
            <div><a href="logout">Log out</a></div>




        </c:if>
        <c:if test="${sessionScope.user.role==2}">
            <div> <a href="#">Home</a></div>
            <div> <a href="StartQuizPage.jsp">Take Quiz</a></div>
            <div><a href="logout">Log out</a></div>


        </c:if>
    </div>
</div>