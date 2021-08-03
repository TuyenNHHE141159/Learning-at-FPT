<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Profile.aspx.cs" Inherits="AssigmentPRNWebForm.Profile" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Profile</title>
    <style>
        .title{
            font-weight:bold;
            font-size:30px;
        }
        a{    text-decoration: none;
    color: white;
    background-color: blue;
    font-size: 15px;
    font-weight: bold;
    border-radius: 5px;

        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
          <div class="menu">
            <div class="title">
           FPT University Academic Portal
        </div>
         <div class="link">
                <div>
            <a href="home.aspx">Home</a>
        </div> 
          
             <div class="logout"><a href="logout.aspx">Logout</a></div>
            
           
        </div>
        </div>
        <div>
            <div class="title">User Detail</div>
            <table>
        <tbody>
            <tr>
                <td><b>Login</b></td>
                <td><%=login %></td>
            </tr>
            <tr>
                <td><b>Full name</b></td>
                <td><%=fullname %></td>
            </tr>
            <tr>
                <td><b>Image</b></td>
                <td>
                    <img  src="images/<%=img %>" style="height: 150px; width: auto; border-width: 0px;" /></td>
            </tr>
            <tr>
                <td><b>Email</b></td>
                <td><span><%=email%></span></td>
            </tr>
        </tbody>
    </table>
        </div>
    </form>
</body>
</html>
