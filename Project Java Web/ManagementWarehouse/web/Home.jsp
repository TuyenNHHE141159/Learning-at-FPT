<%-- 
    Document   : Home
    Created on : 08-Feb-2021, 16:29:29
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    #container{
        min-height: 100%;
    }
    #main{
        overflow: auto;
        padding-bottom: 300px;
    }
    #footer{
        position: relative;
        height: 100px;
        margin-top:  -100px;


        clear: both;
    }


</style>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>

        <jsp:include page="Menu.jsp"></jsp:include>
            <div id="container" class="container">


                <div id="main">
                    <h3>Tìm kiếm khách hàng</h3>
                    <h6>Tên khách hàng</h6>
                    <form action="list" method="post">


                        <input type="text" name="txt">
                        <button type="submit">Tìm kiếm</button>
                        <h4>THÔNG TIN KHÁCH HÀNG</h4>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th scope="col">Mã khách hàng</th>
                                    <th scope="col">Tên khách hàng</th>
                                    <th scope="col">Địa chỉ</th>
                                    <th scope="col">Số điện thoại</th>

                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${customer}" var="o">
                                <tr> 
                                    <th scope="row">${o.id}</th>
                                    <td>${o.name}</td>
                                    <td>
                                        ${o.address}

                                    </td>
                                    <td>
                                        ${o.phone}
                                    </td>

                                    <td><a href="viewbill?id=${o.id}" class="btn btn-primary">Hóa đơn</a></td>
                                    <td><a href="feedback?id=${o.id}" class="btn btn-success">Phản hồi </a></td>
                                </tr> 

                            </c:forEach>    


                        </tbody>
                    </table>
                        
                          <div class="clearfix">
                        <div class="hint-text">Có tổng cộng <b>${count}</b> khách hàng</div>
                        <ul class="pagination">
                            <c:if test="${tag>1}">
                            <li class="page-item "><a href="list?index=${tag-1}&&txt=${txt}"class="page-link">Previous</a></li>
                            </c:if>
                                <c:forEach begin="1" end="${end}" var="i">
                                 <li class="page-item ${tag == i?"active":""}"><a href="list?index=${i}&&txt=${txt}" class="page-link">${i}</a></li>
                                </c:forEach>
                                 <c:if test="${tag<end}">
                            <li class="page-item"><a href="list?index=${tag+1}&&txt=${txt}" class="page-link">Next</a></li>
                            </c:if>
                        </ul>
                    </div>
                        
                   
                </form>

            </div>
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
