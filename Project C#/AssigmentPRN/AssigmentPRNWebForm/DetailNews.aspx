<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="DetailNews.aspx.cs" Inherits="AssigmentPRNWebForm.DetailNews" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style>
        .title1{
            font-weight: bold;
    font-size: 20px;
        }
        .dm{
            font-size: 20px;
    font-weight: bold;
    color: green;
    font-family: arial;
        }
        .hi{
            display:flex;
        }
        .hi a{
             font:bold;
            color:white;
            background-color:blue;
            margin-left:5px;
            text-decoration:none;
            border-radius:4px;
        }
          .title{
            font-size:30px;
            font-weight:bold;
        }
          .container{
              text-align:center;
          }
          .another li a{
                  text-decoration: none;
    font-weight: bold;
    color: blue;
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
        <div class="title1">
             <%=title%>
        </div>
        <div>
         author:  <%=author%>
        </div>
        <div>
 <%=Date%>
        </div>
        <div>
<%=content%>
        </div>
</div>
        <div class="another">
           <div class="dm">Another news:</div> 
             <asp:Repeater ID="listNews" runat="server">
                    <ItemTemplate>
                        <li>
                            <a href="DetailNews.aspx?NewsID=<%# DataBinder.Eval(Container.DataItem, "NewsID") %>"
                                class="news">
                                <%# DataBinder.Eval(Container.DataItem, "Title") %>
                            </a>
                        </li>
                    </ItemTemplate>
                </asp:Repeater>
        </div>
            
    </form>
</body>
</html>
