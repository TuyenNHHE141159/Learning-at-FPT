using AssigmentPRNWebForm.dal;
using AssigmentPRNWebForm.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AssigmentPRNWebForm
{
    public partial class Login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if(Request.Cookies["user"]!=null &&
                  Request.Cookies["pass"] != null)
                {
                    TextBox1.Text = Request.Cookies["user"].Value;
                    TextBox2.Attributes["value"] = Request.Cookies["pass"].Value;
                }
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string user = TextBox1.Text;
            string pass = TextBox2.Text;
            Account a = Account.GetAccountByUserPassWord(user, pass, 3);
            if (a != null)
            {
                Session["account"] = a;
                if (remember.Checked)
                {
                    Response.Cookies["user"].Value = user;
                    Response.Cookies["pass"].Value = pass;
                    Response.Cookies["user"].Expires = DateTime.Now.AddSeconds(30);
                    Response.Cookies["pass"].Expires = DateTime.Now.AddSeconds(30);
                }
                else
                {
                    Response.Cookies["user"].Expires = DateTime.Now.AddSeconds(0);
                    Response.Cookies["pass"].Expires = DateTime.Now.AddSeconds(0);
                }
                Response.Redirect("home.aspx");
            }
            else
            {
                Response.Redirect("Login.aspx");
            }
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            TextBox1.Text = "";
            TextBox2.Text = "";
        }
    }
}