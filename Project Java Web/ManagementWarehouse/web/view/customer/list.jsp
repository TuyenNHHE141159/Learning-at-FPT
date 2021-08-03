<%-- 
    Document   : Customer
    Created on : 06-Feb-2021, 08:29:12
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Customer</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <body>
    <jsp:include page="Menu_1.jsp"></jsp:include>

        <div class="container">
            <h1 class="jumbotron text-center">Danh sách khách hàng</h1>
            <tr>
                <td><a href="addcustomer" class="btn btn-success">Thêm khách hàng </a></td>
            </tr>
            <form action="list" method="post">
                <div align="center">
                    Vai trò khách hàng
                    <select onchange="this.form.submit()" name="department">
                        <option value="2">---------Tất cả---------</option>
                        <c:forEach  items="${listD}" var="d">
                            <option ${deid==d.id?"selected":""} value="${d.id}">${d.name}</option>
                        </c:forEach>
                    </select>
                </div>
            </form>
            <br>

            <table class="table table-striped">
                <tr>
                    <td>Mã khách hàng</td>
                    <td>Tên khách hàng</td>
                    <td>Số điện thoại</td>
                    <td>Địa chỉ</td>
                    <td>Vai trò</td>

                </tr>

                <c:forEach items="${customer}" var="o">
                    <tr>
                        <td>${o.id}</td>
                        <td>${o.name}</td>
                        <td>${o.phone}</td>
                        <td>${o.address}</td>
                        <td>${o.status}</td>
                        <td><a href="#" class="btn btn-success">Sửa thông tin</a></td>
                        <td><a href="#" class="btn btn-danger">Xóa </a></td>

                    </tr>
                </c:forEach>

            </table>

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
