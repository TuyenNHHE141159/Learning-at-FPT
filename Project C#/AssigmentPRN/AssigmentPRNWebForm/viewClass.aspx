<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="viewClass.aspx.cs" Inherits="AssigmentPRNWebForm.viewClass" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style>
        a{
            font:bold;
            color:white;
            background-color:blue;
            margin-left:5px;
            text-decoration:none;
            border-radius:4px;

        }
        .hi{
            display:flex;
        }
          .title{
            font-size:30px;
            font-weight:bold;
        }
          .container{
              margin-left:300px;
          }
    </style>
</head>
<body>
    <form id="form1" runat="server">
           <div class="title">
           FPT University Academic Portal
        </div>
           <div class="hi"> <div class="home">
            <a href="home.aspx">Home</a>
        </div>
         <div class="logout">
            <a href="logout.aspx">Logout</a>
        </div></div>
        <div class="container">
            <table>
        <caption>... then see student list in class: <%=classname %> (<a href="#">Export data</a>)</caption>
                
        <thead>
            <tr>
                <th>STT</th>
                <th>Student Code</th>
                <th>FullName</th>
                <th>Image</th>                   
            </tr>
        </thead>
        <tbody>
          
            <asp:Repeater ID="listStudent" runat="server">
                <ItemTemplate>
                    <tr>
                        <td><%=i++%></td>
                        <td><%# DataBinder.Eval(Container.DataItem, "StudentCode") %></td>
                        <td><%# DataBinder.Eval(Container.DataItem, "FullName") %></td>
                        <td>
                            <img src="images/<%# DataBinder.Eval(Container.DataItem, "Image") %>" style="height:146px;border-width:0px;">
                        </td>                                     
                    </tr>
                </ItemTemplate>

            </asp:Repeater>
            
        </tbody>
    </table>
        </div>
    </form>
</body>
</html>
