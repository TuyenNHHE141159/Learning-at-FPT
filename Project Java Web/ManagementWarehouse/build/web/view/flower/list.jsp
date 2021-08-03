<%-- 
    Document   : list
    Created on : 07-Feb-2021, 16:04:40
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flower Mangement</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <body>
        <style>
            img{
                width: 200px;
                height: 100px;
            }
        </style>
       <jsp:include page="Menu_1.jsp"></jsp:include>


        <div class="container">
            <h1 class="jumbotron text-center">Danh sách hoa</h1>
            <tr>
                <td><a href="addproduct" class="btn btn-success">Thêm mặt hàng </a></td>
            </tr>
            <form action="list" method="post">
                <table class="table table-striped">
                    <tr>
                        <td>Mã Hoa</td>
                        <td>Tên hoa</td>
                        <td>Ảnh</td>
                        <td>Mô tả</td>                       

                    </tr>

                    <c:forEach items="${listF}" var="o">
                        <tr>
                            <td>${o.id}</td>
                            <td>${o.name}</td>
                            <td><img src="${o.image}"></td>
                            <td>${o.description}</td>


                            <td><a href="edit" class="btn btn-primary">Sửa</a></td>
                            <td><a href="delete" class="btn btn-danger">Xóa</a></td>

                        </tr>

                    </c:forEach>

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
