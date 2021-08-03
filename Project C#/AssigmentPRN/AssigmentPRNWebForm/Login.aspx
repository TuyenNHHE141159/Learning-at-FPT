<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="AssigmentPRNWebForm.Login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Login</title>
    <style>
        .main{
            margin-left:500px;
          
        }
        .container{
            margin-left:50px;
        }
        .title{
            color: blue;
        }
    </style>
</head>
<body>
    <div class="main">
        <div class="title"> <h1>The FAP Of Only Student</h1></div>
   <div class="container">
    <p>
        <br />Please enter your <i>username</i> and <i>password</i>.
    </p>
    <form id="form1" runat="server">

        <table >
            <tr>
                <td>UserName:</td>
             
                <td>   <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>   <asp:TextBox ID="TextBox2" runat="server" TextMode="Password"></asp:TextBox></td>
            </tr>
        </table>
        <p ><input id="remember" type="checkbox" name="remember" value="Remember me" runat="server"/>Remember me</p>
        <p >
            <asp:Button ID="Button1" runat="server" Text="Login" OnClick="Button1_Click"/>
            <asp:Button ID="Button2" runat="server" Text="Reset" OnClick="Button2_Click"/>
        </p>
    </form>
        </div>
        </div>
</body>
</html>
