using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace AssigmentPRNWinForm
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
        }
        private void button1_Click(object sender, EventArgs e)
        {
            string user = textBox1.Text;
            string pass = textBox2.Text;
            try
            {
            Account a = Account.GetAccountByUserPassWord(user, pass,2);
                if (a != null)
                {                                      
                    Form1 f = new Form1(Convert.ToInt32(a.TeacherID),this);
                    f.Show();         
                }
                else
                {
                    label4.Text = "Login failed!";
                }
            }
            catch
            {
                
            }           
        }
    }
}
