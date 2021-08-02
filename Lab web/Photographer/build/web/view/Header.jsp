<%-- 
    Document   : Header
    Created on : 18-Jun-2021, 22:16:31
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
         <div class="nav">
            <div class= "nav-inner">
                <div class="abc">
                   <ul>
                    <li> <a class="${clickHome}" href="home">My front page</a></li>
                    <c:forEach items="${gallery}" var="o" >
                        <li><a class="${activeG == o.id?"activeMenu":""}" href="detail?id=${o.id}">${o.name}</a> </li>
                        </c:forEach>
                    <li> <a class="${clickContact}"  href="contact">Contact</a> </li>
                </ul> 
                </div>
                
            </div>
        </div>
                <div class="header-nav-dropdown">
            <button class="btn-menu" onclick="dropDown()">Menu</button>
            <ul class="nav-link">
                <li><a class="${clickHome}" href="home">My front page</a></li>
                <c:forEach var="o" items="${gallery}">
                <li><a class="${activeG == o.id?"activeMenu":""}" href="detail?id=${o.id}">${o.name}</a></li>
                </c:forEach>
            <li><a class="${clickContact}" href="contact">Contact</a></li>
            </ul>
        </div>
        <div class="header">
            <div class="header-inner">
                <div class="img"> </div>
                <div class="title">
                    PHOTOGRAPHER
                </div>
                <div class="subtitle">
                    Welcome to this website
                </div>
            </div>
        </div>
    </body>
</html>
