using AssigmentPRNWebForm.dal;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace AssigmentPRNWebForm.model
{
    public class Mark
    {
        public int StudentRollNo { get; set; }
        public string SubjectCode { get; set; }
        public string lab1 { get; set; }
        public string lab2 { get; set; }
        public string lab3 { get; set; }
        public string lab4 { get; set; }
        public string PT1 { get; set; }
        public string PT2 { get; set; }
        public string Assign { get; set; }
        public string PE { get; set; }
        public string FE { get; set; }

        public Mark()
        {
        }

        public Mark(int studentRollNo, string subjectCode, string lab1, string lab2, string lab3,
            string lab4, string pT1
            , string pT2, string assign, string pE, string fE)
        {
            StudentRollNo = studentRollNo;
            SubjectCode = subjectCode;
            this.lab1 = lab1;
            this.lab2 = lab2;
            this.lab3 = lab3;
            this.lab4 = lab4;
            PT1 = pT1;
            PT2 = pT2;
            Assign = assign;
            PE = pE;
            FE = fE;
        }

        public Mark(string lab1, string lab2, string lab3, string lab4,
            string pT1, string pT2, string assign, string pE, string fE)
        {
            this.lab1 = lab1;
            this.lab2 = lab2;
            this.lab3 = lab3;
            this.lab4 = lab4;
            PT1 = pT1;
            PT2 = pT2;
            Assign = assign;
            PE = pE;
            FE = fE;
        }

        public Mark(string subjectCode)
        {
            SubjectCode = subjectCode;
        }

        public static Mark GetMark(int rollno,string subcode)
        {
            DataTable dt = DAO.GetMarkForStudent(rollno,subcode);
            foreach (DataRow dr in dt.Rows)
            {
                return new Mark((dr["lab1"].ToString()), (dr["lab2"].ToString()),
                  (dr["lab3"].ToString()), (dr["lab4"].ToString()),
                   (dr["pt1"].ToString()), (dr["pt2"].ToString())
                    , (dr["Assignment"].ToString()), (dr["pe"].ToString()), (dr["fe"].ToString()));
            }
            return null;
        }
        public static List<Mark> GetListMark(int rollno)
        {
            DataTable dt = DAO.GetListMarkForStudent(rollno);
            List<Mark> list = new List<Mark>();
            foreach (DataRow dr in dt.Rows)
            {
                list.Add( new Mark(dr["SubjectCode"].ToString()));

            }
            return list;
        }
    }
}