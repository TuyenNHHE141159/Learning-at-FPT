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
    public partial class DetailNews : System.Web.UI.Page
    {
        public String title;
        public String content;
        public String Date;
        public String author;
        protected void Page_Load(object sender, EventArgs e)
        {
            Account a = (Account)Session["account"];
            if (a == null)
            {
                Response.Redirect("Login.aspx");
            }
            int newsid=1 ;
            try {
                newsid = Convert.ToInt32(Request.QueryString["NewsID"]);
            } catch {
                newsid = 4;
            }
            News n = News.GetNewsByID(newsid.ToString());
            title = n.Title;
            content = n.Content;
            Date = n.Date.ToString("dd/MM/yyyy");
            author = n.Author;
            listNews.DataSource = DAO.GetTopNews(5,"");
            listNews.DataBind();
        }
    }
}