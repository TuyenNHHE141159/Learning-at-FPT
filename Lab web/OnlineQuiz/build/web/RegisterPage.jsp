<%-- 
    Document   : RegisterPage
    Created on : 15-Jul-2021, 15:26:18
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
         <script src="javascript/js.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div class="header"></div>
            <jsp:include page="Menu.jsp"/>
            <jsp:include page="Menu_1.jsp"/>
            <div class="main">
                <h3>Register form</h3>
                <span>${mess}</span>
                <form action="register" method="post">
                    <table>
                        <tr>
                            <td class="items">User Name:</td>
                            <td><input type="text" name="user" class="input_account"></td>
                        </tr>
                        <tr>
                            <td class="items">Password:</td>
                            <td><input type="password" name="pass"></td>
                        </tr>
                        <tr>
                            <td class="items">User Type:</td>
                            <td>
                                <select class="selectItem" name="role">
                                    <option value="1">Teacher</option>
                                    <option value="2">Student</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="items">Email:</td>
                            <td><input type="text" name="email"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <button type="submit" class="sign_in">Register</button>
                            </td>
                        </tr>
                    </table>
                </form>

            </div>
        </div>
    </body>
</html>
