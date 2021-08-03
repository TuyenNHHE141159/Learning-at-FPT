using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace AssigmentPRNWinForm
{
    public class Mark
    {
        public int StudentRollNo { get; set; }
        public string SubjectCode { get; set; }
        public string Lab1 { get; set; }
        public string Lab2 { get; set; }
        public string Lab3 { get; set; }
        public string Lab4 { get; set; }
        public string PT1 { get; set; }
        public string PT2 { get; set; }
        public string Assignment { get; set; }
        public string PE { get; set; }
        public string FE { get; set; }

        public Mark()
        {
        }

        public Mark(int studentRollNo, string subjectCode, string lab1, string lab2, string lab3, string lab4, string pT1, string pT2, string assign, string pE, string fE)
        {
            StudentRollNo = studentRollNo;
            SubjectCode = subjectCode;
            this.Lab1 = lab1;
            this.Lab2 = lab2;
            this.Lab3 = lab3;
            this.Lab4 = lab4;
            PT1 = pT1;
            PT2 = pT2;
            Assignment = assign;
            PE = pE;
            FE = fE;
        }
        
    }
    public class ListMark
    {
        public static List<Mark> GetMarkBySubjectCode(string subjectcode)
        {
            List<Mark> employees = new List<Mark>();
            DataTable dt = DAO.GetMarkBySubjectCode(subjectcode);
            foreach (DataRow dr in dt.Rows)
            {
                Mark c = new Mark(Convert.ToInt32(dr["StudentRollNo"]),dr["subjectcode"].ToString(),(dr["lab1"].ToString())
                    , (dr["lab2"].ToString()), (dr["lab3"].ToString()), (dr["lab4"].ToString())
                    , (dr["pt1"].ToString()), (dr["pt2"].ToString()),(dr["assignment"].ToString())
                    , (dr["pe"].ToString()), (dr["fe"].ToString())
                    );
                employees.Add(c);
            }
            return employees;
        }
    }
}
   