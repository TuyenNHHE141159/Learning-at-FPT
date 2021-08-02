<%-- 
    Document   : HomePage
    Created on : 13-Jun-2021, 16:33:32
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photographer</title>    
         <script src="./js/javascript.js" type="text/javascript"></script>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
       <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="image">
                        <img src="images/${ct.image}">
                    </div>
                    <div class="description">
                        Lorem ipsum dolor sit amet
                    </div>
                    <div class="content">
                        <ul > 
                            <c:forEach items="${listP}" var="o" >
                                <li class="span4">
                                    <div class="image">
                                        <img src="images/${o.img.url}" alt="">
                                    </div>
                                    <h4>
                                        <a href="detail?id=${o.id}">${o.title}</a>
                                    </h4>
                                    <p>
                                        ${o.description}
                                    </p>
                                </li>
                            </c:forEach>
                        </ul>
                        <c:if test="${totalPage>1}">                                                
                        <div class="paging">
                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <a class="${tag == i?"active":""}"  href="home?index=${i}">${i}</a>
                            </c:forEach>
                        </div>
                         </c:if>
                    </div>
                    <div class="about">
                        <h3>About me</h3>
                    </div>
                    <div class="about-detail">
                       ${ct.about}
                    </div>
                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
    </body>
</html>
