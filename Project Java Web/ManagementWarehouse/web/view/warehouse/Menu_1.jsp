<%-- 
    Document   : Menu
    Created on : 08-Feb-2021, 15:39:43
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
    /* Footer */
    footer {
        padding: 20px;
        text-align: center;
        background: #ddd;
    } 
</style>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

    </head>
    <body>
        <div class="container">


            <nav class="navbar navbar-expand-md navbar-dark bg-dark">
                <div class="container">
                    <a class="navbar-brand" href="list">Trang chủ</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                 
                   
                    <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                        <nav id="navbar-example2" class="navbar navbar-dark bg-dark px-3">
                            <!--                            <a class="navbar-brand" href="#">Navbar</a>-->
                            <ul class="nav nav-pills">
                                <li class="nav-item">
                                    <a class="nav-link" href="#fat"></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#mdo">Xin chào</a>
                                </li>
                                <li class="nav-item dropdown">
                                                       <c:if test="${sessionScope.account != null}"> 
                                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false"> ${sessionScope.account.username}</a>
                              
                                   
                                    <ul class="dropdown-menu dropdown-menu-end">
                                        <li><a class="dropdown-item" href="logout">Đăng xuất</a></li>

                                        <li><hr class="dropdown-divider"></li>
                                        <li><a class="dropdown-item" href="#two">Đổi mật khẩu</a></li>
                                    </ul>
                                  </c:if>
                                </li>
                            </ul>
                        </nav>


                    </div>
                </div>
            </nav>
            <section class="jumbotron text-center">
                <div class="container">
                    <h1 class="jumbotron-heading">Cửa hàng hoa tươi</h1>
                    <p class="lead text-muted mb-0">Nhập khẩu từ làng nghề Hoa Tây Tựu</p>
                </div>
            </section>


        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>

    </body>
</html>
