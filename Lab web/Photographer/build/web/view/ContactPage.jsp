<%-- 
    Document   : ContactPage
    Created on : 15-Jun-2021, 14:15:49
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
                        <h3>Contact</h3>
                    </div>
                    <div class="content-contact">
                        <h4>PHOTOGRAPHER</h4>
                        <div class="country">
                            <p>Address: ${ct.address}<br>City:${ct.city}
                                <br>Country: ${ct.country}</p>
                        </div>
                        <div class="infor">
                            <table>
                                <tr>
                                    <td>Tel: </td>
                                    <td>${ct.tel}</td>
                                </tr>
                                <tr>
                                    <td>Email: </td>
                                    <td>${ct.email}</td>
                                </tr>

                            </table>
                        
                        </div> 
                        <div class="map">
                            <iframe src="${ct.map}" width="450" height="300" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
                        </div>
                    </div>

                </div>
                <div class="right">
                    <jsp:include page="Right.jsp"/>
                </div>
            </div>
        </div>
        <jsp:include page="Footer.jsp"/>
        </div>
    </body>
</html>
