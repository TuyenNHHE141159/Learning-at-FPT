<%-- 
    Document   : PlaceOrder
    Created on : 04-Feb-2021, 22:48:26
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <jsp:include page="Menu_1.jsp"></jsp:include>
        <%int i=1;%>
        <div class="container">
              <a href="viewbill?id=${customer.id}">Trở lại danh sách hóa đơn</a>
        </div>
         
      
        <form action="addbillline" method="post">
            <div class="container">
                
                <table>
                    <tr>
                        <td >
                            Mã khách hàng
                        </td>
                        <td>
                            <input type="text" name="customerid" readonly="" value="${customer.id}">
                            <input type="hidden" name="bid" readonly="" value="${bid}">
                        </td>
                    </tr>
                    <tr>
                        <td >
                            Tên khách hàng
                        </td>
                        <td>
                            <input type="text" name="customername" readonly="" value="${customer.name}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Địa chỉ
                        </td>
                        <td>
                            <input type="text" name="address" readonly=""value="${customer.address}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Điện thoại
                        </td>
                        <td>
                            <input type="text" name="phone"readonly="" value="${customer.phone}">
                        </td>
                    </tr>


                    <tr>
                        <td>Tên hàng</td>
                        <td>
                            <select name="fid">
                                <c:forEach items="${listF}" var="o">
                                    <option value="${o.id}"> ${o.name}</option>
                                </c:forEach>
                            </select>
                        </td>

                    </tr>


                    <tr>
                        <td>Số lượng</td>
                        <td><input type="text" name="quantity"></td>
                    </tr>
                    <tr>
                        <td>Đơn giá</td>
                        <td><input type="text" name="unitprice"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Thêm vào đơn hàng">
                        </td>

                    </tr>

                </table>
                <br>
                <div id="bill" class="container">
                    <div id="top" class="jumbotron text-center">
                        <h2 class="jumbotron-heading">Cửa hàng hoa tươi</h2>
                        <h4>Chuyên doanh: CÁC LOẠI HOA TƯƠI</h4>
                        <h4>ĐC: Tổ dân phố Trung - P.Tây Tựu - Q.Bắc Từ Liêm - HN</h4>
                        <h4>ĐT: 0977.131 399 - 038.6530558</h4>
                        <h4>Ngày đặt hàng: ${date} </h4>
                        <h4>Tên khách hàng:${customer.name} Địa chỉ:${customer.address} </h4>  
                         <h4>Mã hóa đơn: ${bid}</h4>
                    </div>




                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">STT</th>
                                <th scope="col">Tên hàng</th>
                                <th scope="col">Số lượng</th>
                                <th scope="col">Đơn giá</th>
                                <th scope="col">Thành tiền</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listB}" var="o">
                                <tr> 
                                    <th scope="row"><%=i%></th>
                                    <%i++;%>
                                    <td>${o.flower.name}</td>
                                    <td>
                                        ${o.quantity}

                                    </td>
                                    <td>
                                        ${o.price}
                                    </td>
                                    <td>
                                        ${o.total}
                                    </td>
                                    <td>
                                       <a href="deletebillline?fid=${o.flower.id}&&bid=${o.billid}&&cid=${customer.id}&&q=${o.quantity}" class="btn btn-primary">Xóa</a>
                                    </td>
                                </tr> 
                            </c:forEach>    
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>Tổng cộng</td>
                                <td>${money}</td>
                            </tr>

                        </tbody>
                    </table>
                    </form>
                </div>
                <button onclick="printContent('bill')" class="btn btn-primary">In hóa đơn</button>
                <script>
                    function printContent(el) {
                        var restorepage = document.body.innerHTML;
                        var printcontent = document.getElementById(el).innerHTML;
                        document.body.innerHTML = printcontent;
                        window.print();
                        document.body.innerHTML = restorepage;
                    }
                </script>
            </div>

    </body>
</html>
