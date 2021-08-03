using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace AssigmentPRNWinForm
{
    public class DAO
    {
        public static SqlConnection GetConnection()
        {
            string conStr = ConfigurationManager.ConnectionStrings["AssigmentPRNConStr"].ToString();
            return new SqlConnection(conStr);
        }

        public static DataTable GetDataBySql(string sql)
        {
            SqlCommand command = new SqlCommand(sql, GetConnection());
            SqlDataAdapter adapter = new SqlDataAdapter(command);
            DataSet ds = new DataSet();
            adapter.Fill(ds);
            return ds.Tables[0];
        }

        public static DataTable GetDataBySqlWithParameters(string sql, params SqlParameter[] parameters)
        {
            SqlCommand command = new SqlCommand(sql, GetConnection());
            command.Parameters.AddRange(parameters);
            SqlDataAdapter adapter = new SqlDataAdapter(command);
            DataSet ds = new DataSet();
            adapter.Fill(ds);
            return ds.Tables[0];
        }

        public static DataTable GetDataByStoredProcedure(string SpName, params SqlParameter[] parameters)
        {
            SqlCommand command = new SqlCommand(SpName, GetConnection());
            command.CommandType = CommandType.StoredProcedure;
            command.Parameters.AddRange(parameters);
            SqlDataAdapter adapter = new SqlDataAdapter(command);
            DataSet ds = new DataSet();
            adapter.Fill(ds);
            return ds.Tables[0];
        }
        public static int UpdateDataByStoredProcedure(string SpName, params SqlParameter[] parameters)
        {
            SqlCommand command = new SqlCommand(SpName, GetConnection());
            command.CommandType = CommandType.StoredProcedure;
            command.Parameters.AddRange(parameters);
            command.Connection.Open();
            int count = command.ExecuteNonQuery();
            command.Connection.Close();
            return count;
        }
        public static int UpdateMark(string StudentRollNo, string SubjectCode,string lab1, string lab2, string lab3
            ,string lab4,string pt1, string pt2, string assignment, string pe, string fe)
        {
            string sql = @"MarkUpdate3";
            SqlParameter[] parameters = new SqlParameter[11];
            parameters[0] = new SqlParameter("@studentRollNo", SqlDbType.NVarChar);
            parameters[0].Value = StudentRollNo;
            parameters[1] = new SqlParameter("@subjectcode", SqlDbType.NVarChar);
            parameters[1].Value = SubjectCode;
            parameters[2] = new SqlParameter("@lab1", SqlDbType.NVarChar);
            parameters[2].Value = lab1;
            parameters[3] = new SqlParameter("@lab2", SqlDbType.NVarChar);
            parameters[3].Value = lab2;
            parameters[4] = new SqlParameter("@lab3", SqlDbType.NVarChar);
            parameters[4].Value = lab3;
            parameters[5] = new SqlParameter("@lab4", SqlDbType.NVarChar);
            parameters[5].Value = lab4;
            parameters[6] = new SqlParameter("@pt1", SqlDbType.NVarChar);
            parameters[6].Value = pt1;
            parameters[7] = new SqlParameter("@pt2", SqlDbType.NVarChar);
            parameters[7].Value = pt2;
            parameters[8] = new SqlParameter("@Assignment", SqlDbType.NVarChar);
            parameters[8].Value = assignment;
            parameters[9] = new SqlParameter("@PE", SqlDbType.NVarChar);
            parameters[9].Value = pe;
            parameters[10] = new SqlParameter("@FE", SqlDbType.NVarChar);
            parameters[10].Value = fe;   
            return UpdateDataByStoredProcedure(sql, parameters);
        }
        public static int ExecuteSqlWithParameters(string sql, SqlParameter[] parameters)
        {
            SqlCommand command = new SqlCommand(sql, GetConnection());
            command.Parameters.AddRange(parameters);
            command.Connection.Open();
            int count = command.ExecuteNonQuery();
            command.Connection.Close();
            return count;
        }
        public static DataTable GetSubjectByTeacherID(int TeacherID)
        {
            string sql = @"select * from [subject] where teacherid=@teacherid";
            SqlParameter parameter = new SqlParameter("@teacherid", SqlDbType.Int);
            parameter.Value = TeacherID;
            return GetDataBySqlWithParameters(sql, parameter);
        }
        public static DataTable GetSubjectByTeacherIDPro(int TeacherID)
        {
            string sql = @"select sb.TeacherID,sb.SubjectCode,sb.SubjectName,t.FullName,c.ClassCode,c.ClassName
,(cast(sb.SubjectCode as nvarchar )+'-' +cast(c.ClassCode as nvarchar )) as mashupid
,(cast(sb.SubjectName as nvarchar )+'/' +cast(c.ClassName as nvarchar )) as mashupname
from Subject sb join Teacher t on t.TeacherID=sb.TeacherID join class c on c.Major =sb.Major
where sb.TeacherID=@teacherid";
            SqlParameter parameter = new SqlParameter("@teacherid", SqlDbType.Int);
            parameter.Value = TeacherID;
            return GetDataBySqlWithParameters(sql, parameter);
        }
        public static DataTable Login(string user, string password, int roleID)
        {
            string sql = @"select ac.AccountID, Username, [Password],r.RoleID,r.RoleName,t.TeacherID from Account ac join Acc_Role ar on ac.AccountID=ar.AccountID 
                join Role r on r.RoleID=ar.RoleID
            join Teacher t on t.Accountid= ac.AccountID 
            where ac.Username=@user and ac.Password=@password and r.RoleID=@roleid";
            SqlParameter parameter = new SqlParameter("@user", SqlDbType.NVarChar);
            parameter.Value = user;
            SqlParameter parameter1 = new SqlParameter("@password", SqlDbType.NVarChar);
            parameter1.Value = password;
            SqlParameter parameter2 = new SqlParameter("@roleid", SqlDbType.Int);
            parameter2.Value = roleID;
            return GetDataBySqlWithParameters(sql, parameter,parameter1,parameter2);
        }
        public static DataTable GetTeacherByTeacherID(int TeacherID)
        {
            string sql = @"select * from [Teacher] where teacherid=@teacherid";
            SqlParameter parameter = new SqlParameter("@teacherid", SqlDbType.Int);
            parameter.Value = TeacherID;
            return GetDataBySqlWithParameters(sql, parameter);
        }
   
        public static DataTable GetMarkBySubjectCode(string subjectCode)
        {
            string sql = @"select * from Mark m join Student s on m.studentrollno=s.rollno where m.SubjectCode=@subjectcode";
            SqlParameter parameter = new SqlParameter("@subjectcode", SqlDbType.NVarChar);
            parameter.Value = subjectCode;
           // SqlParameter parameter1 = new SqlParameter("@classcode", SqlDbType.NVarChar);
            //parameter1.Value = classcode;
            return GetDataBySqlWithParameters(sql, parameter);
        }
        public static DataTable GetMarkBySubjectCodePro(string subjectCode,string classcode)
        {
            string sql = @"select m.StudentRollNo,m.SubjectCode,m.lab1,m.lab2,m.lab3,m.lab4,m.PT1,m.pt2,m.Assignment,m.PE,m.FE,
s.ClassCode,s.FullName,s.studentCode,sb.SubjectName,t.TeacherID,t.FullName,c.ClassName
from mark m join student s on m.StudentRollNo= s.RollNo 
join Subject sb on sb.SubjectCode=m.SubjectCode 
join teacher t on sb.TeacherID=t.TeacherID 
join Class c on c.ClassCode=s.ClassCode 
where  m.SubjectCode=@subjectcode and s.ClassCode=@classcode";
            SqlParameter parameter = new SqlParameter("@subjectcode", SqlDbType.NVarChar);
            parameter.Value = subjectCode;
             SqlParameter parameter1 = new SqlParameter("@classcode", SqlDbType.NVarChar);
            parameter1.Value = classcode;
            return GetDataBySqlWithParameters(sql, parameter, parameter1);
        }
    }
}