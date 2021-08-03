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
    public partial class listnewsfull : System.Web.UI.Page
    {
        public int PageIndex = 1;
        public string txt="";
        protected void Page_Load(object sender, EventArgs e)
        {
            Account a = (Account)Session["account"];
            if (a == null)
            {
                Response.Redirect("Login.aspx");
            }
            txt = Request.QueryString["txt"];
            //listNews.DataSource = DAO.GetNews(txt);
            //listNews.DataBind();
            if (!IsPostBack)
            {

                int PageSize, NumberOfPage;
                try
                {
                    PageIndex = (Request.QueryString["page"] != null) ? Convert.ToInt32(Request.QueryString["page"]) : 1;

                }
                catch (FormatException)
                {
                    PageIndex = 1;
                    //Response.Redirect("productlist.aspx");
                }
                PageSize = Convert.ToInt32(ConfigurationManager.AppSettings["top"]);
                NumberOfPage = (News.GetNumberOfNews(txt) - 1) / PageSize + 1;
                if (PageIndex > NumberOfPage) PageIndex = NumberOfPage;
                if (NumberOfPage > 1)
                    BuildPager(PageIndex, PageSize, NumberOfPage);
                int start = (PageIndex - 1) * PageSize;
                listNews.DataSource = DAO.GetNewsPaging(txt,start,PageSize);
                listNews.DataBind();

            }

        }
        private void BuildPager(int PageIndex, int PageSize, int NumberOfPage)
        {

            List<PageItem> pages = new List<PageItem>();
            for (int i = 1; i <= NumberOfPage; i++)
                pages.Add(new PageItem(i, ""));
            pages[PageIndex - 1].CssClass = "current";
            rpPages.DataSource = pages;
            rpPages.DataBind();
        }
    }
}