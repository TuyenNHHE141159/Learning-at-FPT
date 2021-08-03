using AssigmentPRNWebForm.dal;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace AssigmentPRNWebForm.model
{
    public class Student
    {
        public int RollNo { get; set; }
        public int ClassCode { get; set; }
        public string ClassName { get; set; }
        public string FullName { get; set; }
        public bool Gender { get; set; }
        public DateTime DOB { get; set; }
        public string CardID { get; set; }
        public string Address { get; set; }
        public string Phone { get; set; }
        public string Email { get; set; }
        public string CampusID { get; set; }
        public string MemberCode { get; set; }
        public string Image { get; set; }

        public Student(int rollNo, int classCode, string fullName, string memberCode)
        {
            RollNo = rollNo;
            ClassCode = classCode;
            FullName = fullName;
            MemberCode = memberCode;
        }

        public Student(int rollNo, string fullName, string email, string memberCode, string image)
        {
            RollNo = rollNo;
            FullName = fullName;
            Email = email;
            MemberCode = memberCode;
            Image = image;
        }

        public Student(int rollNo, string className, string fullName, bool gender, DateTime dob, string cardID, string address, string phone, string email, string campusID, string memberCode, string image)
        {
            RollNo = rollNo;
            ClassName = className;
            FullName = fullName;
            Gender = gender;
            DOB = dob;
            CardID = cardID;
            Address = address;
            Phone = phone;
            Email = email;
            CampusID = campusID;
            MemberCode = memberCode;
            Image = image;
        }
        public static Student GetAccountByUserPassWord(int aid)
        {
            DataTable dt = DAO.GetStudentByAccountID(aid);
            foreach (DataRow dr in dt.Rows)
            {
                return new Student(Convert.ToInt32(dr["rollno"]),Convert.ToInt32(dr["Classcode"])
                    ,dr["fullname"].ToString(),
                    dr["StudentCode"].ToString());
            }
            return null;
        }
        public static Student GetAccountByUserPassWord1(int aid)
        {
            DataTable dt = DAO.GetStudentByAccountID(aid);
            foreach (DataRow dr in dt.Rows)
            {
                return new Student(Convert.ToInt32(dr["rollno"]), (dr["Fullname"].ToString())
                    , dr["email"].ToString(),
                    dr["studentcode"].ToString()
                    ,
                    dr["image"].ToString());
            }
            return null;
        }
    }
}