<%-- 
    Document   : Home
    Created on : 18-May-2021, 11:46:50
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <% int i=1;%>
        <div class="container">
            <div class="preheader">
            </div>
            <div class="header">
                <div class="header_title">
                    My digital news
                </div>
            </div>
            <div class="menu">
                <a href="home">News</a>
               
            </div>
            <div class="main">
                <div class="left">
                    <div class="title">
                        ${detail.title}
                    </div>
                    <div class="image">                    
                        <img src="images/${detail.image}" alt=""/>
                    </div>
                    <div class="des">
                        ${detail.content}
                    </div>
                    <div class="writter">
                        <div class="icon1">
                        </div>
                        <div class="icon2">
                        </div>                   
                        ${detail.writter} | ${detail.date1}                    
                    </div>
                </div>
                <div class="right">
                    <div class="title">
                        <a href="#">
                            Digital New
                        </a>
                    </div>
                    <div class="summary">
                        ${lastD.summary}
                    </div>
                    <div class="title">
                        Search
                    </div>
                    <form action="search" method="post">
                        <input type="text" name="txt" required >
                        <button type="submit">Go</button>
                    </form>
                    <div class="title">
                        Last Article
                    </div>
                    <c:forEach items="${top5}" var="o">
                        <a href="detail?id=${o.id}" class="lastArticle">${o.title}</a><br>
                    </c:forEach>                  
                </div>
            </div>
            <div class="footer">
            </div>
        </div>
    </body>
</html>