<%-- 
    Document   : Search
    Created on : 20-May-2021, 21:54:25
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
                    <h2>
                         ${notify}  
                    </h2>
                     
                    
                    
                    <c:forEach items="${listS}" var="o">
                        <div class="per_article">
                            <div class="title">
                                <a href="detail?id=${o.id}">
                                    ${o.title}
                                </a>
                            </div>
                            <div class="image">
                                <img src="images/${o.image}" alt=""/>    
                            </div>

                            <div class="summary">
                                ${o.summary}
                            </div>
                        </div>
                    </c:forEach>
                    <div class="paging">
                        <c:if test="${totalPage>1}">
                              <c:forEach begin="1" end="${totalPage}" var="i">
                            <a class="${indexPage==i?"active":""}" href="search?indexPage=${i}&txt=${txt}">${i}</a>
                        </c:forEach>
                        </c:if>
                      
                    </div>
                </div>
                <div class="right">
                    <div class="title">
                        <a href="home">
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
                        <input type="text" value="${txt}" name="txt">
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
