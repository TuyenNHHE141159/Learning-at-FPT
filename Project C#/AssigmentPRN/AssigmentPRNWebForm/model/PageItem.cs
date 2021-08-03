using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AssigmentPRNWebForm.model
{
    public class PageItem
    {
        public int PageNumber { get; set; }
        public string CssClass { get; set; }

        public PageItem(int pageNumber, string cssClass)
        {
            PageNumber = pageNumber;
            CssClass = cssClass;
        }
    }
}