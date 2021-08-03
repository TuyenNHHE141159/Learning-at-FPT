using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace AssigmentPRNWebForm.dal
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
        public static int ExecuteSqlWithParameters(string sql, SqlParameter[] parameters)
        {
            SqlCommand command = new SqlCommand(sql, GetConnection());
            command.Parameters.AddRange(parameters);
            command.Connection.Open();
            int count = command.ExecuteNonQuery();
            command.Connection.Close();
            return count;
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
            return GetDataBySqlWithParameters(sql, parameter, parameter1, parameter2);
        }
        public static DataTable LoginStudent(string user, string password, int roleID)
        {
            string sql = @"select s.RollNo,s.ClassCode,s.StudentCode,a.AccountID,
            a.Username,a.[Password],ar.RoleID,r.RoleName from Student s 
            join Account a on s.AccountID=a.AccountID 
            join Acc_Role ar on a.AccountID=ar.AccountID
            join Role r on r.RoleID=ar.RoleID 
            where a.Username=@user and a.[Password]=@password and r.RoleID=@roleid";
            SqlParameter parameter = new SqlParameter("@user", SqlDbType.NVarChar);
            parameter.Value = user;
            SqlParameter parameter1 = new SqlParameter("@password", SqlDbType.NVarChar);
            parameter1.Value = password;
            SqlParameter parameter2 = new SqlParameter("@roleid", SqlDbType.Int);
            parameter2.Value = roleID;
            return GetDataBySqlWithParameters(sql, parameter, parameter1, parameter2);
        }
        public static DataTable GetListMarkForStudent(int rollno)
        {
            string sql = @"select s.RollNo,s.ClassCode,s.FullName,s.StudentCode,m.SubjectCode,c.ClassName
            ,m.lab1,m.lab2,m.lab3,m.lab4,m.Assignment,m.FE,m.PE, (c.ClassName+'/'+su.SubjectName+'('+m.SubjectCode+')') as mashup 
            from student s join mark m on s.RollNo=m.StudentRollNo
            join class c on c.ClassCode=s.ClassCode
			join [subject] su on su.SubjectCode=m.SubjectCode
            where RollNo=@rollno";
            SqlParameter parameter2 = new SqlParameter("@rollno", SqlDbType.Int);
            parameter2.Value = rollno;
            return GetDataBySqlWithParameters(sql, parameter2);
        }
        public static DataTable GetMarkForStudent(int rollno,string subcode)
        {
            string sql = @"select s.RollNo,s.ClassCode,s.FullName,s.StudentCode,m.SubjectCode,c.ClassName
            ,m.lab1,m.lab2,m.lab3,m.lab4,m.pt1,m.pt2,m.Assignment,m.FE,m.PE, (c.ClassName+'/'+m.SubjectCode) as mashup 
            from student s join mark m on s.RollNo=m.StudentRollNo
            join class c on c.ClassCode=s.ClassCode
            where RollNo=@rollno and m.subjectcode=@subcode";
            SqlParameter parameter2 = new SqlParameter("@rollno", SqlDbType.Int);
            parameter2.Value = rollno;
            SqlParameter parameter1 = new SqlParameter("@subcode", SqlDbType.NVarChar);
            parameter1.Value = subcode;
            return GetDataBySqlWithParameters(sql, parameter2, parameter1);
        }
        public static DataTable GetListStudentByClassCode(int classcode)
        {
            string sql = @"select * from class c 
            join student s on c.ClassCode=s.ClassCode where c.ClassCode=@classcode";
            SqlParameter parameter2 = new SqlParameter("@classcode", SqlDbType.Int);
            parameter2.Value = classcode;
            return GetDataBySqlWithParameters(sql, parameter2);
        }
        public static DataTable GetClassByClassCode(int classcode)
        {
            string sql = @"select * from class where ClassCode=@classcode";
            SqlParameter parameter2 = new SqlParameter("@classcode", SqlDbType.Int);
            parameter2.Value = classcode;
            return GetDataBySqlWithParameters(sql, parameter2);
        }
        public static DataTable GetStudentByAccountID(int aid)
        {
            string sql = @"select * from student where accountid=@aid";
            SqlParameter parameter2 = new SqlParameter("@aid", SqlDbType.Int);
            parameter2.Value = aid;
            return GetDataBySqlWithParameters(sql, parameter2);
        }
        public static DataTable GetTopNews(int top,string txt)
        {
            string sql = @"select top (@top) * from News where title like @txt";
            SqlParameter parameter = new SqlParameter("@top", SqlDbType.Int);
            parameter.Value = top;
            SqlParameter parameter1 = new SqlParameter("@txt", SqlDbType.NVarChar);
            parameter1.Value = "%" + txt + "%";
            return GetDataBySqlWithParameters(sql, parameter,parameter1);
        }
        public static DataTable GetNews( string txt)
        {
            string sql = @"select * from News where title like @txt";      
            SqlParameter parameter1 = new SqlParameter("@txt", SqlDbType.NVarChar);
            parameter1.Value = "%" + txt + "%";
            return GetDataBySqlWithParameters(sql, parameter1);
        }
        public static DataTable GetNewsPaging(string txt,int index, int size)
        {
            string sql = @"select * from News where title like @txt order by date desc
                            offset @index rows fetch next @size rows only";
            SqlParameter parameter1 = new SqlParameter("@txt", SqlDbType.NVarChar);
            parameter1.Value = "%" + txt + "%";
            SqlParameter parameter2 = new SqlParameter("@index", SqlDbType.Int);
            parameter2.Value = index;
            SqlParameter parameter3 = new SqlParameter("@size", SqlDbType.Int);
            parameter3.Value = size;
            return GetDataBySqlWithParameters(sql, parameter1, parameter2, parameter3);
        }
        public static int GetNumberOfNews(string txt)
        {
            string sql = "select count(*) from News where title like @txt ";
            SqlParameter parameter = new SqlParameter("@txt", SqlDbType.NVarChar);
            parameter.Value = "%" + txt + "%";
            DataTable dt = GetDataBySqlWithParameters(sql, parameter);
            return Convert.ToInt32(dt.Rows[0][0]);
        }
        public static DataTable GetNewsByID(string id)
        {
            string sql = @"select * from News where newsid=@id";
            SqlParameter parameter1 = new SqlParameter("@id", SqlDbType.NVarChar);
            parameter1.Value = id ;
            return GetDataBySqlWithParameters(sql, parameter1);
        }
    }
}