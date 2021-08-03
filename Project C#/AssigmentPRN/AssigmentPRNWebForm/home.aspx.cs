using AssigmentPRNWebForm.dal;
using AssigmentPRNWebForm.model;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AssigmentPRNWebForm
{
    public partial class home : System.Web.UI.Page
    {
        public int top=Convert.ToInt32(ConfigurationManager.AppSettings.Get("top"));
        public int classcode = 0;
        public int rollno = 0;
        public string name="" ;
        protected void Page_Load(object sender, EventArgs e)
        {
            Account a = (Account)Session["account"];
            if (a == null)
            {
                Response.Redirect("Login.aspx");
            }
            int aid = a.AccountID;
            Student s = Student.GetAccountByUserPassWord(aid);
            name = s.MemberCode;
            classcode = s.ClassCode;
            rollno = s.RollNo;
            listNews.DataSource = DAO.GetTopNews(top, "");
            listNews.DataBind();
            
        }

        protected void Button1_Click(object sender, EventArgs e)
        {         
            listNews.DataSource = DAO.GetTopNews(top, TextBox1.Text);
            listNews.DataBind();
        }
    }
}