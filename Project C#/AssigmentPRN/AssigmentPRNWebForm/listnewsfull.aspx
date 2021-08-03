<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="listnewsfull.aspx.cs" Inherits="AssigmentPRNWebForm.listnewsfull" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style>
        .hi{
            display:flex;
            
        }
        a {margin: 4px; padding:2px;text-decoration:none;font-weight:bold; color:blue}
        .current{background-color: yellow;
    margin: 4px;
    border-radius: 15px}
       
          .title{
            font-size:30px;
            font-weight:bold;
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
        <div>
            <ul>
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
            </ul>
        </div>
        <div>
            <asp:Repeater ID="rpPages" runat="server">
                <ItemTemplate>
                    <a href="listnewsfull.aspx?page=<%#DataBinder.Eval(Container.DataItem, "PageNumber") %>&txt=<%=txt%>"
                        class ="<%#DataBinder.Eval(Container.DataItem, "CssClass") %>"
                        >
                        <%#DataBinder.Eval(Container.DataItem, "PageNumber") %>
                    </a>
                </ItemTemplate>
            </asp:Repeater>
        </div>
    </form>
</body>
</html>
