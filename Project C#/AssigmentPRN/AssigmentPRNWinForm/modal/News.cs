using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AssigmentPRNWinForm
{
    public class News
    {
        public int NewID { get; set; }
        public string Title { get; set; }
        public string Content { get; set; }
        public DateTime Date { get; set; }

        public News()
        {
        }

        public News(int newID, string title, string content, DateTime date)
        {
            NewID = newID;
            Title = title;
            Content = content;
            Date = date;
        }
    }
}