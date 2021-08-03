<%-- 
    Document   : list
    Created on : 27-Feb-2021, 16:34:09
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
    <style>
        img{
            width: 200px;
            height: 100px;
        }
    </style>
    <jsp:include page="Menu_1.jsp"></jsp:include>

        <body>
        <%int i = 1;%>
        <div class="container">
            <h1>Xuất nhập kho</h1>

            <form action="warehouse" method="post">

                <br>
                <h4>Loại đơn hàng: Đơn xuất</h4>

                <table class="table">
                    <thead>
                        <tr><th scope="col">Mã đơn hàng</th>
                            <th scope="col">Ngày xuất hàng</th>                          
                            <th scope="col">Tên mặt hàng </th>  
                            <th scope="col">Đơn giá </th> 
                            <th scope="col">Số lượng xuất</th>  
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="o">
                            <c:forEach items="${o.lines}" var="i"> 
                                <tr> 
                                    <td>
                                        ${o.id}
                                    </td>
                                    <td>
                                        <b>${o.date}</b>   
                                    </td>      
                                    <td>
                                        ${i.flower.name}   
                                    </td>
                                    <td>
                                        ${i.price}   
                                    </td> 
                                    <td>
                                        ${i.quantity}   
                                    </td>  
                                </c:forEach>
                            </tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><a href="viewbillline?id=${o.id}&&cusid=${o.customerId}" class="btn btn-primary"> Chi tiết nhập</a></td>
                    </c:forEach>    
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Có tổng cộng <b>${count}</b> đơn hàng</div>
                    <ul class="pagination">
                        <c:if test="${tag>1}">
                            <li class="page-item "><a href="warehouse?index=${tag-1}"class="page-link">Previous</a></li>
                            </c:if>
                            <c:forEach begin="1" end="${end}" var="i">
                            <li class="page-item ${tag == i?"active":""}"><a href="warehouse?index=${i}" class="page-link">${i}</a></li>
                            </c:forEach>
                            <c:if test="${tag<end}">
                            <li class="page-item"><a href="warehouse?index=${tag+1}" class="page-link">Next</a></li>
                            </c:if>
                    </ul>
                </div>


                <br>
                <h4>Loại đơn hàng: Đơn nhập</h4>

                <table class="table">
                    <thead>
                        <tr><th scope="col">Mã đơn hàng</th>
                            <th scope="col">Ngày xuất hàng</th>                          
                            <th scope="col">Tên mặt hàng</th>
                            <th scope="col">Số lượng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list1}" var="o">
                            <c:forEach items="${o.lines}" var="i">  
                                <tr> 
                                    <td >
                                        ${o.id}
                                    </td>

                                    <td>
                                        <b> ${o.date}</b>   
                                    </td> 
                                    <td>
                                        ${i.flower.name}   
                                    </td>
                                    <td>
                                        ${i.quantity}   
                                    </td>  
                                </tr>
                            </c:forEach>



                        <td></td>
                        <td></td>
                        <td></td>
                        <td><a href="viewbillline?id=${o.id}&&cusid=${o.customerId}" class="btn btn-primary"> Chi tiết nhập</a></td>
                    </c:forEach>    
                    </tbody>
                </table>
                <div class="clearfix">
                    <div class="hint-text">Có tổng cộng <b>${count1}</b> đơn hàng</div>
                    <ul class="pagination">
                        <c:if test="${tag1>1}">
                            <li class="page-item "><a href="warehouse?index1=${tag1-1}"class="page-link">Previous</a></li>
                            </c:if>
                            <c:forEach begin="1" end="${end1}" var="i">
                            <li class="page-item ${tag1 == i?"active":""}"><a href="warehouse?index1=${i}" class="page-link">${i}</a></li>
                            </c:forEach>
                            <c:if test="${tag1<end1}">
                            <li class="page-item"><a href="warehouse?index1=${tag1+1}" class="page-link">Next</a></li>
                            </c:if>
                    </ul>
                </div>
            </form>


        </div>
    </body>
</html>
