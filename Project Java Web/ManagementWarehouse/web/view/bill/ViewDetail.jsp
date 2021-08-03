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
       
        <div class="container">
              <a href="viewbill?id=${id}">Trở lại danh sách hóa đơn</a>
        </div>
      
       
        <form>
            <div class="container">

                <table>
                    <tr>
                        <td >
                            Mã khách hàng
                        </td>
                        <td>
                            <input type="text" name="customerid" readonly="" value="${cusname.id}">
                        </td>
                    </tr>
                    <tr>
                        <td >
                            Tên khách hàng
                        </td>
                        <td>
                            <input type="text" name="customername" readonly="" value="${cusname.name}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Địa chỉ
                        </td>
                        <td>
                            <input type="text" name="address" readonly="" value="${cusname.address}">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Điện thoại
                        </td>
                        <td>
                            <input type="text" name="phone"readonly="" value="${cusname.phone}">
                        </td>
                    </tr>


                </table>
                <br>
                <div id="bill" class="container">
                    <div id="top" class="jumbotron text-center">
                        <h1 class="jumbotron-heading">Cửa hàng Hoa Tươi</h1>
                        <h3>Chuyên doanh: CÁC LOẠI HOA TƯƠI</h3>
                        <h4>ĐC: Tổ dân phố Trung - P.Tây Tựu - Q.Bắc Từ Liêm - HN</h4>
                        <h4>ĐT: 0977.131 399 - 038.6530558</h4>
                        <h5>Vai trò khách hàng: ${cusname.status}, Ngày  
                            <c:if test="${cusname.int==1}">
                                Đặt
                            </c:if>
                            <c:if test="${cusname.int==0}">
                                Giao
                            </c:if> Hàng :${date}</h5>   

                        <h4>Hà Nội,${today}  </h4>
                        <h4>Tên khách hàng: ${cusname.name} Địa chỉ: ${cusname.address}</h4>  
                        <h4>Mã hóa đơn: ${bid} Tình trạng: ${status}</h4>
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
                         <%int i = 1;%>
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
                                </tr> 
                            </c:forEach>    
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>Tổng cộng</td>
                                <td>${money} VNĐ</td>
                            </tr>
図書館(としょかん)
                        </tbody>

                    </table>
                    <br> <h4>Đã thanh toán: ${paidmoney}</h4>
                </div>
                <a href="pay?bid=${bid}&&cid=${cusname.id}&&money=${money}" class="btn btn-success">Thanh toán(chấm nợ) </a><br> 
                <a href="partialpay?bid=${bid}&&cid=${cusname.id}" class="btn btn-secondary">Thanh toán một phần </a><br> 
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
        </form>
    </body>
</html>
