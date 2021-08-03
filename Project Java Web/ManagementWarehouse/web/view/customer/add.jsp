<%-- 
    Document   : add
    Created on : 18-Feb-2021, 16:03:02
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add customer</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <body>
         <jsp:include page="Menu_1.jsp"></jsp:include>
        <div class="container">
            <h1 class="jumbotron text-center">Thêm khách hàng</h1>

            <form action="addcustomer" method="post">




                <table class="table table-striped">
                    <tr>
                        <td>Vai trò</td> 
                        <td>
                            <select name="department">

                                <c:forEach  items="${listD}" var="d">
                                    <option value="${d.id}">${d.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                    <tr>

                        <td>Tên khách hàng</td>
                        <td><input type="text" name="name"></td>
                    </tr>  
                    <tr>
                        <td>Số điện thoại</td> 
                        <td><input type="text" name="phone"></td>
                    </tr>
                    <tr>
                        <td>Địa chỉ</td> 
                        <td><input type="text" name="address"></td>
                    </tr>
                    <tr>

                        <td>
                            <button type="submit"class="btn btn-success" >  
                                Lưu
                            </button>    
                        </td>

                    </tr>






                </table>
            </form>
        </div>
   <footer id="footer" class="container">


            <div id="container">
                <h5>THÔNG TIN LIÊN HỆ<br>
                    Địa chỉ: Tây Tựu<br>
                    Điện thoại: 024 382 93179 - 024 371 63611</h5>
            </div>
        </footer>
    </body>
</html>
