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
    public partial class viewClass : System.Web.UI.Page
    {
        public int i = 1;
        public string classname="";
        protected void Page_Load(object sender, EventArgs e)
        {
            Account a = (Account)Session["account"];
            if (a == null)
            {
                Response.Redirect("Login.aspx");
            }
            try { 
            int classcode = Convert.ToInt32(Request.QueryString["classcode"]);
                listStudent.DataSource = DAO.GetListStudentByClassCode(classcode);
                listStudent.DataBind();
                Class c = Class.GetClass(classcode);
                classname = c.ClassName;
            } catch
            {
                Response.Redirect("home.aspx");
            }
            
        }
    }
}