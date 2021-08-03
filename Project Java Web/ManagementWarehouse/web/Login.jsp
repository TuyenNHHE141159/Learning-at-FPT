<%-- 
    Document   : Login
    Created on : 01-Feb-2021, 16:20:49
    Author     : User
--%>

<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!--hien thi tieng viet-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!------ Include the above in your HEAD tag ---------->

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Đăng nhập</h3>
                </div>
                <div class="panel-body">
                    <form accept-charset="UTF-8" role="form" action="login" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Nhập tên đăng nhập" name="username" value="${account.username}" type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Nhập mật khẩu" name="password" type="password" value="${account.password}">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="1" checked=""> Ghi nhớ
                                </label>
                            </div>${mess}
                            <input class="btn btn-lg btn-success btn-block" type="submit" value="Đăng nhập">
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
