using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AssigmentPRNWinForm
{
    public class Student
    {
        public int RollNo { get; set; }
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

    }
}