<%-- 
    Document   : debt
    Created on : 15-Mar-2021, 20:23:08
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">
              <jsp:include page="Menu_1.jsp"></jsp:include>
        
        <h1>Quản Lý Công Nợ</h1>
        <form action="debt" method="post">

            <div class="">
                 <h2>Loại Đơn: Xuất kho</h2>
            </div>
           

            <table class="table">
                <thead>

                    <tr>
                        <th scope="col">Ngày xuất hàng</th>

                        <th scope="col">Mã đơn hàng</th>
                        <th scope="col">Thành tiền</th>
                        <th scope="col">Đã thanh toán</th>
                        <th scope="col">Chi tiết đơn</th>            


                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listbr}" var="o">

                        <tr> 
                            <th scope="row">${o.date}</th>
                            <td>${o.id}</td>

                            <td>
                                ${o.money}
                            </td>
                            <td>
                                ${o.paidMoney}
                            </td>


                            <td><a href="viewbillline?id=${o.id}&&cusid=${o.customerId}" class="btn btn-primary">Xem chi tiết</a></td>

                        </tr> 

                    </c:forEach>    


                </tbody>
            </table>
            <div class="clearfix">
                <div class="hint-text">Có tổng cộng <b>${count}</b> đơn hàng</div>
                <ul class="pagination">
                    <c:if test="${tag>1}">
                        <li class="page-item "><a href="debt?index=${tag-1}"class="page-link">Previous</a></li>
                        </c:if>
                        <c:forEach begin="1" end="${end}" var="i">
                        <li class="page-item ${tag == i?"active":""}"><a href="debt?index=${i}" class="page-link">${i}</a></li>
                        </c:forEach>
                        <c:if test="${tag<end}">
                        <li class="page-item"><a href="debt?index=${tag+1}" class="page-link">Next</a></li>
                        </c:if>
                </ul>
            </div>
                <b>Tổng công nợ xuất: ${debt} VNĐ</b>
        </form>
        <form action="debt" method="post">


            <h2>Loại Đơn: Nhập kho</h2>

            <table class="table">
                <thead>

                    <tr>
                        <th scope="col">Ngày nhập hàng</th>

                        <th scope="col">Mã đơn hàng</th>
                        <th scope="col">Thành tiền</th>
                        <th scope="col">Đã thanh toán</th>
                        <th scope="col">Chi tiết đơn</th>            


                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listbr1}" var="o">

                        <tr> 
                            <th scope="row">${o.date}</th>
                            <td>${o.id}</td>

                            <td>
                                ${o.money}
                            </td>
                            <td>
                                ${o.paidMoney}
                            </td>


                            <td><a href="viewbillline?id=${o.id}&&cusid=${o.customerId}" class="btn btn-primary">Xem chi tiết</a></td>

                        </tr> 

                    </c:forEach>    


                </tbody>
            </table>
            <div class="clearfix">
                <div class="hint-text">Có tổng cộng <b>${count1}</b> đơn hàng</div>
                <ul class="pagination">
                    <c:if test="${tag1>1}">
                        <li class="page-item "><a href="debt?index1=${tag1-1}"class="page-link">Previous</a></li>
                        </c:if>
                        <c:forEach begin="1" end="${end1}" var="i">
                        <li class="page-item ${tag1 == i?"active":""}"><a href="debt?index1=${i}" class="page-link">${i}</a></li>
                        </c:forEach>
                        <c:if test="${tag1<end1}">
                        <li class="page-item"><a href="debt?index1=${tag1+1}" class="page-link">Next</a></li>
                        </c:if>
                </ul>
            </div>
                 <b>Tổng công nợ nhập: ${debt1} VNĐ</b>
        </form>
                </div>
    </body>
</html>
