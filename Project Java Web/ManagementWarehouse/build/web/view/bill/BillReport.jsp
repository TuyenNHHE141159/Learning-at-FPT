<%-- 
    Document   : BillReport
    Created on : 18-Feb-2021, 21:58:58
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>
    <body>
         <jsp:include page="Menu_1.jsp"></jsp:include>
        
        <div class="container">
            <h2>Danh sách hóa đơn chưa thanh toán</h2>
            <form action="billreport" method="post">
                <div align="center">
                    Vai trò khách hàng
                    <select onchange="this.form.submit()" name="department">                      
                        <c:forEach  items="${listD}" var="d">
                            <option ${deid==d.id?"selected":""} value="${d.id}">${d.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <table class="table">
                    <thead>
                        <tr><th scope="col">Mã khách hàng</th>
                            <th scope="col">Tên khách hàng</th>
                            <th scope="col">Địa chỉ</th>
                            <th scope="col">Số điện thoại</th>
                            <th scope="col">Mã hóa đơn</th>
                            <th scope="col">Ngày đặt hàng</th>


                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listbr}" var="o">

                            <tr> 
                                <th scope="row">${o.customerid}</th>
                                <td>${o.customername}</td>
                                <td>
                                    ${o.address}
                                </td>
                                <td>
                                    ${o.phone}
                                </td>
                                <td>
                                    ${o.billid}
                                </td>
                                <td>
                                    ${o.date}
                                </td>
                               
                                <td><a href="viewbillline?id=${o.billid}&&cusid=${o.customerid}" class="btn btn-primary">Xem chi tiết</a></td>
                               
                            </tr> 

                        </c:forEach>    


                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>
