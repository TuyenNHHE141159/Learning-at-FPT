using AssigmentPRNWebForm.dal;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace AssigmentPRNWebForm.model
{
    public class Class
    {
        public int ClassCode { get; set; }
        public string ClassName { get; set; }
        public string Major { get; set; }

        public Class(int classCode, string className, string major)
        {
            ClassCode = classCode;
            ClassName = className;
            Major = major;
        }
        public static Class GetClass(int classcode)
        {
            DataTable dt = DAO.GetClassByClassCode(classcode);
            foreach (DataRow dr in dt.Rows)
            {
                return new Class(Convert.ToInt32(dr["classcode"]),dr["classname"].ToString(),dr["major"].ToString());
            }
            return null;
        }
    }
}