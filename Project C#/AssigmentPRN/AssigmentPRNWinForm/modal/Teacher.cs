using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;

namespace AssigmentPRNWinForm
{
    public class Teacher
    {
        public int TeacherID { get; set; }
        public string TeacherName { get; set; }

        public Teacher(int teacherID, string teacherName)
        {
            TeacherID = teacherID;
            TeacherName = teacherName;
        }
        public static Teacher getTeacherByID(int teacherid)
        {
            DataTable dt = DAO.GetTeacherByTeacherID(teacherid);
            foreach (DataRow dr in dt.Rows)
            {
            
                return new Teacher(teacherid, dr["FullName"].ToString());
            }
            return null;
        }
    }
    public class TeacherList
    {
        public Teacher GetTeacherByID(int teacherid)
        {
            DataTable dt = DAO.GetTeacherByTeacherID(teacherid);
            foreach (DataRow dr in dt.Rows)
            {

                return new Teacher(teacherid, dr["FullName"].ToString());
            }
            return null;
        }
    }
}
