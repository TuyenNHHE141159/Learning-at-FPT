using AssigmentPRNWebForm.model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace AssigmentPRNWebForm
{
   
    public partial class Profile : System.Web.UI.Page
    {
        public string login = "";
        public string fullname="";
        public string img = "";
        public string email = "";
        public string name="";
        protected void Page_Load(object sender, EventArgs e)
        {
            Account a = (Account)Session["account"];
            if (a == null)
            {
                Response.Redirect("Login.aspx");
            }
            int aid = a.AccountID;
            Student s = Student.GetAccountByUserPassWord1(aid);
            login = s.MemberCode;
            fullname = s.FullName;
            img = s.Image;
            email = s.Email;
            name = s.MemberCode;
        }
    }
}