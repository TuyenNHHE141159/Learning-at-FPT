<%-- 
    Document   : GalleryPage
    Created on : 15-Jun-2021, 14:57:22
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Photographer</title>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
        <script src="./js/javascript.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="about">
                        <h3>${g.name}</h3>
                    </div>             

                    <div class="imageGaler" onclick="change()">   

                        <c:forEach items="${listImg}" var="o">
                            <div class="slideImg" >
                                <img src="images/${o.url}" alt="">  
                            </div>
                        </c:forEach>  
                        <div class="icon-right1" onclick="nextImage()"></div>
                    </div>
                    <div class="move">
                        <div class="icon-left" onclick="backImage()"></div>
                        <div class="icon-right" onclick="nextImage()"></div>
                    </div>

                    <div class="contentGalery">
                        <ul >
                            <c:forEach items="${listImg}" var="o">
                                <li class="span4">
                                    <a href="showImage?id=${o.id}">  <img class="listImg" src="images/${o.url}"></a>
                                </li>
                            </c:forEach>

                        </ul>
                        <c:if test="${totalPage>1}">
                            <div class="paging">
                                <c:forEach begin="1" end="${totalPage}" var="i">
                                    <a class="${tag == i?"active":""}" href="detail?index=${i}&id=${galleryid}">${i}</a>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>

                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
        <script>display();</script>
    </body>
</html>
