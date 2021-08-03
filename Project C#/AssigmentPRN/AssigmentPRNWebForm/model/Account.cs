using AssigmentPRNWebForm.dal;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace AssigmentPRNWebForm.model
{
    public class Account
    {
        public int AccountID { get; set; }
        public string Username { get; set; }
        public string Password { get; set; }
        public string Role { get; set; }
        public Account(string username, string password, string role)
        {
            Username = username;
            Password = password;
            Role = role;
        }

        public Account(int accountID, string username, string password, string role)
        {
            AccountID = accountID;
            Username = username;
            Password = password;
            Role = role;
        }

        public static Account GetAccountByUserPassWord(string user, string pass, int role)
        {
            DataTable dt = DAO.LoginStudent(user, pass, role);
            foreach (DataRow dr in dt.Rows)
            {
                return new Account(Convert.ToInt32(dr["accountid"]), dr["username"].ToString()
                    , dr["password"].ToString(), dr["roleID"].ToString());
            }
            return null;
        }
    }
}