using AssigmentPRNWebForm.dal;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace AssigmentPRNWebForm.model
{
    public class News
    {
        
            
        public int NewID { get; set; }
        public string Title { get; set; }
        public string Content { get; set; }
        public DateTime Date { get; set; }
        public string Date1 { get {return Date.ToString("dd/MM/yyy"); } set {value=Date1; } }
        public string Author { get; set; }
        public News()
        {
        }

        public News(int newID, string title, string content, DateTime date, string author) : this(newID, title, content, date)
        {
            Author = author;
        }

        public News(int newID, string title, string content, DateTime date)
        {
            NewID = newID;
            Title = title;
            Content = content;
            Date = date;
        }
        public static int GetNumberOfNews(string txt)
        {
            return DAO.GetNumberOfNews(txt);
        }
        public static News GetNewsByID(string id)
        {
            DataTable dt = DAO.GetNewsByID(id);
           
            foreach (DataRow dr in dt.Rows)
            {
                try  //chua chinh xac, can viet lai ky hon - sinh vien lam
                {
                    return new News(Convert.ToInt32(dr["newsid"]),dr["title"].ToString()
                        ,dr["content"].ToString(),Convert.ToDateTime(dr["date"]),dr["author"].ToString()) ;                 
                }
                catch
                { }
            }
            return null;
        }
    }
}