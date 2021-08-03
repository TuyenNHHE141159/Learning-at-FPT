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
    public partial class StudentGrade : System.Web.UI.Page
    {
        public int rollno = 0;

        public string name = "";

        public string status = "";
        public string subcode = "";
        public Mark m=null;
        public string tb = "";
        public string tblab="";
        public string tbpt="";
   

        protected void Page_Load(object sender, EventArgs e)
        {
            Account a = (Account)Session["account"];
            if (a == null)
            {
                Response.Redirect("Login.aspx");
            }
            try
            {
                  rollno = Convert.ToInt32(Request.QueryString["rollno"]);
                  List<Mark> list = Mark.GetListMark(rollno);

                try { } catch { }
                string subjectcode = Request.QueryString["subcode"];
            
            if (rollno==null ||subjectcode==null)
                    {                       
                        m = Mark.GetMark(rollno, list[0].SubjectCode);
                    subcode = list[0].SubjectCode;
                }
                    else
                    {          
                        m = Mark.GetMark(rollno, subjectcode);
                    subcode = subjectcode;
                }
               
                Student s = Student.GetAccountByUserPassWord(a.AccountID);
                name = s.FullName + "(" + s.MemberCode + ")";
                rpListSubject.DataSource = DAO.GetListMarkForStudent(rollno);
                rpListSubject.DataBind();
            }
            catch {
                Response.Redirect("home.aspx");
            }
            if (m.lab1 != "" & m.lab2 != "" & m.lab3 != "" & m.lab4 != ""
                & m.PT1 != "" & m.PT2 != "" & m.Assign != "" & m.PE != "" & m.FE != "")
            {
                double lab = 0.038 * (Convert.ToDouble(m.lab1) + Convert.ToDouble(m.lab2) +
                    Convert.ToDouble(m.lab3) + Convert.ToDouble(m.lab4));
                lab= Math.Round(lab, 1);
                String.Format("{0:0.0}", lab);
                tblab = lab.ToString();
                double pt = 0.075 * (Convert.ToDouble(m.PT1) + Convert.ToDouble(m.PT2));
                double tbs = (lab + pt + Convert.ToDouble(m.FE) * 0.3 + Convert.ToDouble(m.Assign) * 0.2
                    + Convert.ToDouble(m.PE) * 0.2);
                tbs = Math.Round(tbs, 1);
                tb = (lab + pt + Convert.ToDouble(m.FE) * 0.3 + Convert.ToDouble(m.Assign) * 0.2
                    + Convert.ToDouble(m.PE) * 0.2).ToString();
                String.Format("{0:0.0}", tbs);
                tb = tbs.ToString();
               
                
                tblab = ((Convert.ToDouble(m.lab1) + Convert.ToDouble(m.lab2) +
                    Convert.ToDouble(m.lab3) + Convert.ToDouble(m.lab4))/4).ToString();
                tbpt = ((Convert.ToDouble(m.PT1) + Convert.ToDouble(m.PT2))/2).ToString();
                if (Convert.ToDouble(tb) >= 5& Convert.ToDouble(m.lab1)>0 & Convert.ToDouble(m.lab2) > 0 & Convert.ToDouble(m.lab3) > 0
                    & Convert.ToDouble(m.lab4) > 0 & Convert.ToDouble(m.PT2) > 0 & Convert.ToDouble(m.PT1) > 0 & Convert.ToDouble(m.Assign) > 0
                    & Convert.ToDouble(m.PE) > 0 & Convert.ToDouble(m.FE) > 0)
                {
                    status = "PASSED";
                    Label1.Text = "PASSED";
                    Label1.ForeColor = System.Drawing.Color.Green;
                }
                else
                {
                    status = "NOT PASSED";
                    Label1.Text = "NOT PASSED";
                    Label1.ForeColor = System.Drawing.Color.Red;
                }
            }
            else
            {
                status = "STUDYING";
                Label1.Text = "STUDYING";
                Label1.ForeColor = System.Drawing.Color.Green;
            }



        }
    }
}