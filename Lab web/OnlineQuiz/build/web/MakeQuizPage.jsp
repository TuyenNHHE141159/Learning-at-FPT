<%-- 
    Document   : MakeQuizPage
    Created on : 15-Jul-2021, 15:25:32
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
         <script src="javascript/js.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div class="header"></div>
            <jsp:include page="Menu.jsp"/>
             <jsp:include page="Menu_1.jsp"/>
            <div class="main main_makeQuiz">
                <form action="make-quiz" method="post">
                    <table class="make_quiz">
                        <tr>
                            <td>Question:</td>
                            <td><textarea name="question" class="question"></textarea></td>
                        </tr>
                        <tr>
                            <td>Option 1: </td>
                            <td><textarea name="option1"></textarea></td>
                        </tr>
                        <tr>
                            <td>Option 2: </td>
                            <td><textarea name="option2"></textarea></td>
                        </tr>
                        <tr>
                            <td>Option 3: </td>
                            <td><textarea name="option3"></textarea></td>
                        </tr>
                        <tr>
                            <td>Option 4: </td>
                            <td><textarea name="option4"></textarea></td>
                        </tr>
                        <tr>
                            <td>Answers(s): </td>
                            <td>
                                <input type="checkbox" value="1" name="answer"> Option 1                  
                                <input type="checkbox" value="2" name="answer"> Option 2
                                <input type="checkbox" value="3" name="answer"> Option 3
                                <input type="checkbox" value="4" name="answer"> Option 4
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <button type="submit" class="save">Save</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </body>
</html>

