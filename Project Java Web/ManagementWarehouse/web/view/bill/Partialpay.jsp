<%-- 
    Document   : Partialpay
    Created on : 16-Mar-2021, 23:11:10
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="partialpay" method="post">
            Mã khách hàng <input type="text" readonly="" value="${cid}" name="cid"><br>
            Mã đơn hàng   <input type="text" readonly="" value="${bid}" name="bid"><br>
            Số tiền muốn thanh toán trước:<br><input type="text" name="money" placeholder="nhập số tiền">
            <button type="submit">
                Save
            </button>
        </form>
    </body>
</html>
