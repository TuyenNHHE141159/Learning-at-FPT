  <%@ Page Language="C#" AutoEventWireup="true" CodeBehind="home.aspx.cs" Inherits="AssigmentPRNWebForm.home" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Home</title>
    <style>
        .left{
            display:70%;
        }
        .right{
            display:40%;
        }
        .home{
            display:flex;
        }
        .information ul li a{
                    text-decoration: none;
    color: blue;
    font-weight: bold;
        }
        .report ul li a{
                    text-decoration: none;
    color: blue;
    font-weight: bold;
        }
       
        .component h2{
            text-align:center;
                font-weight: bold;
    background-color: orange;
    border-radius: 10px;
    color: white;
        }
        .top-news ul li a{
                text-decoration: none;
    color: blue;
    font-weight: bold;
        }
        .top-news a{
                    text-decoration: none;
    color: blue;
    font-weight: bold;
        }
        .menu {
            display: flex;
        }
        .menu .link a{
            margin-left: 500px;
                text-decoration: none;
        }
        .title{
            font-size:30px;
            font-weight:bold;
        }
        .news-title{
            color: white;
    font-size: 20px;
    width: 70px;
    background-color: blue;
    border-radius: 5px;
    text-align: center;
        }
        .top-news{
            width: 70%;
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
             <div class="code"><a href="Profile.aspx">Hello <%=name %></a></div>
             <div class="logout"><a href="logout.aspx">Logout</a></div>
            
              
        </div>
        </div>
        
         <div class="home">
             <div class="right">
        <div class="top-news">
            <div class="news-title">News</div>
            <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
            <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Search" />
            <ul>
                <asp:Repeater ID="listNews" runat="server">
                    <ItemTemplate>
                        <li>
                            <a href="DetailNews.aspx?NewsID=<%# DataBinder.Eval(Container.DataItem, "NewsID") %>"
                                class="news">
                           <%# DataBinder.Eval(Container.DataItem, "Date","{0:dd/MM/yyyy}") %>-<%# DataBinder.Eval(Container.DataItem, "Title") %>
                            </a>
                        </li>
                    </ItemTemplate>
                </asp:Repeater>
            </ul>
            <a href="listnewsfull.aspx?txt=<%=TextBox1.Text%>">
                More
             </a>
        </div>
                 </div>
             <div class="left">
             <div class="component">
                 <h2>Academic Information</h2>
        <div class="information">
            <div class="title">Information Access</div>
            <ul>
                <li><a href="viewClass.aspx?classcode=<%=classcode%>">List Student In Class</a></li>                    
            </ul>
        </div>
              <div class="report">
            <div class="title">Reports</div>
            <ul>                     
                <li><a href="StudentGrade.aspx?rollno=<%=rollno%>">Mark Report</a> (Báo cáo điểm)</li>
            </ul>
        </div>
             </div>
        </div>
    </div>
    </form>
</body>
</html>
