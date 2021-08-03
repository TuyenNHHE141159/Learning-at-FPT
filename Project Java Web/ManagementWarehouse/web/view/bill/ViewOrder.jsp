<%-- 
    Document   : ViewOrder
    Created on : 10-Feb-2021, 23:24:13
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>


    #vvv{
        color: red;
    }
    #vvv h5{
        color: black;
    }
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    </head>
    <body>
           <jsp:include page="Menu_1.jsp"></jsp:include>
       
        <div class="container" id="vvv">
 <a href="list">Trở lại trang chủ</a>



            <h3>DANH SÁCH HÓA ĐƠN </h3>
            <h4>
                VAI TRÒ KHÁCH HÀNG: <b>${customer.status}</b><br>
                KHÁCH HÀNG ${customer.name}, 
                ĐỊA CHỈ: ${customer.address}
            </h4>
            <h5>Tìm kiếm đơn hàng theo mã hóa đơn</h5>
        </div>
        <div id="main" class="container">

            <form action="#" method="post">


                <input type="text" name="txt">
                <button type="submit">Tìm kiếm</button>
                <br>
                <td><a href="addbill?cid=${customer.id}" class="btn btn-success">Thêm hóa đơn</a></td>
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Mã Hóa Đơn</th>
                            <th scope="col">Ngày đặt hàng</th>


                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listB1}" var="o">
                            <tr> 
                                <th scope="row">${o.id}</th>
                                <td>${o.date1}</td>

                                <td><a href="viewbillline?id=${o.id}&&cusid=${o.customerId}" class="btn btn-success">Xem chi tiết </a></td>
                                <c:if test="${o.paid==0}">
                                <td><a href="placeorder?bid=${o.id}&&cusid=${o.customerId}" class="btn btn-primary">Thêm,sửa hóa đơn </a></td>
                                </c:if>
                                  <c:if test="${o.paid==1}">
                                <td>Đã thanh toán</td>
                                </c:if>
                            </tr> 

                        </c:forEach>    


                    </tbody>
                </table>
                <div class="clearfix">
                        <div class="hint-text">Có tổng cộng <b>${count}</b> đơn hàng</div>
                        <ul class="pagination">
                            <c:if test="${tag>1}">
                            <li class="page-item "><a href="viewbill?id=${id}&&index=${tag-1}"class="page-link">Previous</a></li>
                            </c:if>
                                <c:forEach begin="1" end="${end}" var="i">
                                 <li class="page-item ${tag == i?"active":""}"><a href="viewbill?id=${id}&&index=${i}" class="page-link">${i}</a></li>
                                </c:forEach>
                                 <c:if test="${tag<end}">
                            <li class="page-item"><a href="viewbill?id=${id}&&index=${tag+1}" class="page-link">Next</a></li>
                            </c:if>
                        </ul>
                    </div>
            </form>

        </div>
    </body>
</html>
