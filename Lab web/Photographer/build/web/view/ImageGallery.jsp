<%-- 
    Document   : ImageGallery
    Created on : 14-Jul-2021, 14:13:25
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="./js/javascript.js" type="text/javascript"></script>
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container">
            <jsp:include page="Header.jsp"/>
            <div class="main">
                <div class="left">
                    <div class="btnBack">
                        <a href="detail?id=${image.gid}">Back</a>
                    </div>

                    <div class="bigImage">
                        <img  src="image/${image.url}" alt="">
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
