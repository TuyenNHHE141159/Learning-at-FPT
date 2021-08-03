<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="StudentGrade.aspx.cs" Inherits="AssigmentPRNWebForm.StudentGrade" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style>
         .current{background-color: yellow;
    margin: 4px;
    border-radius: 15px}
        .sub tr td a{
            text-decoration: none;
    font-weight: bold;
    color: blue;
        }
        .home a{
              text-decoration: none;
    background-color: blue;
    border-radius: 5px;
    color: white;
    width:70px;
        }
        .hi{
            display:flex;
        }
          .title{
            font-size:30px;
            font-weight:bold;
        }
          .main{
              margin-left:200px;
          }
          .logout a{
     
    text-decoration: none;
    background-color: blue;
    border-radius: 5px;
    color: white;
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
       
        <div class="row">
            <div class="col-md-12">
                <table>
                    <tr style="border-bottom: 0 none">
                        <td>
                            <div class="main">
                            <h2>Grade report for <span><%=name %></span></h2>
                                <table>
                                    <tr>
                                        <td>
                                            <h3>Select a term, course ...</h3>
                                            <table>
                                                <thead>
                                                    <tr>
                                                        <th style="color:forestgreen; font-weight:bold">Course current: <%=subcode %></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td >
                                                            <div class="sub">
                                                                <table>
                                                                    <asp:Repeater ID="rpListSubject" runat="server">
                                                                        <ItemTemplate>
                                                                            <tr>
                                                                                <td><a href="StudentGrade.aspx?rollno=<%=rollno %>&subcode=<%# DataBinder.Eval(Container.DataItem, "Subjectcode") %>"
                                                                                    >
                                                                                    <%# DataBinder.Eval(Container.DataItem, "mashup") %>
                                                                                    </a></td>
                                                                            </tr>
                                                                        </ItemTemplate>
                                                                    </asp:Repeater>
                                                                </table>
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </td>
                                        <td >
                                            <div>
                                                <table >
                                                    <caption>... then see report</caption>
                                                    <thead>
                                                        <tr>
                                                            <th>Grade category</th>
                                                            <th>Grade item</th>
                                                            <th>Weight</th>
                                                            <th>Value</th>
                                                            <th>Comment</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td rowspan="5">Lab</td>
                                                            <td>Lab 1</td>
                                                            <td>3.8 %</td>
                                                            <td><%=this.m.lab1 %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Lab 2</td>
                                                            <td>3.8 %</td>
                                                            <td><%=this.m.lab2 %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Lab 3</td>
                                                            <td>3.8 %</td>
                                                            <td><%=this.m.lab3 %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Lab 4</td>
                                                            <td>3.8 %</td>
                                                            <td><%=this.m.lab4 %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total</td>
                                                            <td>15.0 %</td>
                                                            <td><%=this.tblab %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td rowspan="3">Progress test</td>
                                                            <td>Progress test 1</td>
                                                            <td>7.5 %</td>
                                                            <td><%=this.m.PT1 %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Progress test 2</td>
                                                            <td>7.5 %</td>
                                                            <td><%=this.m.PT1 %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total</td>
                                                            <td>15.0 %</td>
                                                            <td><%=this.tbpt %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td rowspan="2">Group Project</td>
                                                            <td>Group Project</td>
                                                            <td>20.0 %</td>
                                                            <td><%=this.m.Assign %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total</td>
                                                            <td>20.0 %</td>
                                                            <td><%=this.m.Assign %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td rowspan="2">Practical exam</td>
                                                            <td>Practical exam</td>
                                                            <td>20.0 %</td>
                                                            <td><%=this.m.PE %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total</td>
                                                            <td>20.0 %</td>
                                                            <td><%=this.m.PE %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td rowspan="2">Final Exam</td>
                                                            <td>Final Exam</td>
                                                            <td>30.0 %</td>
                                                            <td><%=this.m.FE %> </td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total</td>
                                                            <td>30.0 %</td>
                                                            <td><%=this.m.FE %></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td rowspan="2">Final Exam Resit</td>
                                                            <td>Final Exam Resit</td>
                                                            <td>30.0 %</td>
                                                            <td></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Total</td>
                                                            <td>30.0 %</td>
                                                            <td></td>
                                                            <td></td>
                                                        </tr>
                                                    </tbody>
                                                    <tfoot>
                                                        <tr>
                                                            <td rowspan="2">Course total</td>
                                                            <td>Average</td>
                                                            <td colspan="3"><%=tb %></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Status</td>
                                                            <td colspan="3"><asp:Label ID="Label1" runat="server" Text="Label"></asp:Label></td>
                                                        </tr>
                                                    </tfoot>
                                                </table>
                                            </div>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
  
    </form>
</body>
</html>
