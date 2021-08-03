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
    
    public partial class Form1 : Form
    {
        int tid=1;
        Login login;
        public Form1(int teacherID, Login l)
        {
          
            InitializeComponent();
            comboBox1.DataSource = DAO.GetSubjectByTeacherIDPro(teacherID);
            comboBox1.DisplayMember = "mashupname";
            comboBox1.ValueMember = "mashupid";
            label1.Text = "Teacher: "+ Teacher.getTeacherByID(teacherID).TeacherName;
            label2.Text +="("+ DAO.GetSubjectByTeacherIDPro(teacherID).Rows.Count.ToString()+")";
            button1.Visible = false;
            login = l;
            login.Hide();
            this.FormClosed += form_close;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            
            checkBox1.Checked = false;
            List<Mark> list = ListMark.GetMarkBySubjectCode(comboBox1.SelectedValue.ToString());
        
            checkedListBox1.Items.Clear();
            checkedListBox1.Items.Add("Lab1");
            checkedListBox1.Items.Add("Lab2");
            checkedListBox1.Items.Add("Lab3");
            checkedListBox1.Items.Add("Lab4");
            checkedListBox1.Items.Add("PT1");
            checkedListBox1.Items.Add("PT2");
            checkedListBox1.Items.Add("Assignment");
            checkedListBox1.Items.Add("PE");
            checkedListBox1.Items.Add("FE");
            LoadData();

        }
        private void LoadData()
        {
            string key = comboBox1.SelectedValue.ToString();
            string[] arr = key.Split('-');
            DataTable dt = DAO.GetMarkBySubjectCodePro(arr[0],arr[1]);
            dataGridView1.AutoGenerateColumns = false;           
            object[] o = new object[checkedListBox1.CheckedItems.Count];
            checkedListBox1.CheckedItems.CopyTo(o, 0);
            dataGridView1.Columns.Clear();
            dataGridView1.Columns.Add("StudentRollNo", "StudentRollNo");
            dataGridView1.Columns["StudentRollNo"].DataPropertyName = "StudentRollNo";
            dataGridView1.Columns["StudentRollNo"].Visible = false;
            dataGridView1.Columns.Add("SubjectCode", "SubjectCode");
            dataGridView1.Columns["SubjectCode"].DataPropertyName = "SubjectCode";
            dataGridView1.Columns["SubjectCode"].Visible = false;
            dataGridView1.Columns.Add("Roll", "Roll");
            dataGridView1.Columns["Roll"].DataPropertyName = "StudentCode";
            dataGridView1.Columns.Add("FullName", "FullName");
            dataGridView1.Columns["FullName"].DataPropertyName = "FullName";
            
            foreach (object item in o)
            {
                {
                    if (o != null)
                    {
                    dataGridView1.Columns.Add(item.ToString(), item.ToString());
                    dataGridView1.Columns[item.ToString()].DataPropertyName = item.ToString();
                    }                                    
                }
            }
            dataGridView1.DataSource = dt;
            foreach (DataGridViewRow row in dataGridView1.Rows)
            {
                row.HeaderCell.Value = String.Format("{0}", row.Index + 1);
            }
        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            LoadData();
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox1.Checked)
            {
                for (int i = 0; i < checkedListBox1.Items.Count; i++)
                {
                    checkedListBox1.SetItemChecked(i, true);
                }
                button1.Visible = true;
            }
            else
            {
                for (int i = 0; i < checkedListBox1.Items.Count; i++)
                {
                    checkedListBox1.SetItemChecked(i, false);
                }
                button1.Visible = false;
            }
            LoadData();
        }       
        private void checkedListBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            LoadData();
        }

        private void checkedListBox1_ItemCheck(object sender, ItemCheckEventArgs e)
        {
            LoadData();
        }
        public bool checkVisible()
        {
            for (int i = 2; i < dataGridView1.Columns.Count; i++)
            {
                if (dataGridView1.Columns[i].Visible) return true;
               
            }
                return false;
        }
        public bool validateData()
        {

            for(int i = 0; i < dataGridView1.Rows.Count; i++)
            {
                if (Convert.ToDouble(dataGridView1.Rows[i].Cells["Lab1"].Value.ToString()!=""? dataGridView1.Rows[i].Cells["Lab1"].Value.ToString():"11") > 10
                    || Convert.ToDouble(dataGridView1.Rows[i].Cells["Lab2"].Value.ToString() != "" ? dataGridView1.Rows[i].Cells["Lab2"].Value.ToString() : "11") > 10
                    || Convert.ToDouble(dataGridView1.Rows[i].Cells["Lab3"].Value.ToString() != "" ? dataGridView1.Rows[i].Cells["Lab3"].Value.ToString() : "11") > 10
                    || Convert.ToDouble(dataGridView1.Rows[i].Cells["Lab4"].Value.ToString() != "" ? dataGridView1.Rows[i].Cells["Lab4"].Value.ToString() : "11") > 10
                    || Convert.ToDouble(dataGridView1.Rows[i].Cells["PT1"].Value.ToString() != "" ? dataGridView1.Rows[i].Cells["PT1"].Value.ToString() : "11") > 10
                    || Convert.ToDouble(dataGridView1.Rows[i].Cells["PT2"].Value.ToString() != "" ? dataGridView1.Rows[i].Cells["PT2"].Value.ToString() : "11") > 10
                    || Convert.ToDouble(dataGridView1.Rows[i].Cells["Assignment"].Value.ToString() != "" ? dataGridView1.Rows[i].Cells["Assignment"].Value.ToString() : "11") > 10
                    || Convert.ToDouble(dataGridView1.Rows[i].Cells["PE"].Value.ToString() != "" ? dataGridView1.Rows[i].Cells["PE"].Value.ToString() : "11") > 10
                    || Convert.ToDouble(dataGridView1.Rows[i].Cells["FE"].Value.ToString() != "" ? dataGridView1.Rows[i].Cells["FE"].Value.ToString() : "11") > 10
                    )
                {
                    return false;
                }
            }
            return true;
        }
        private void button1_Click(object sender, EventArgs e)
        {
            //checkBox1.Checked=true;
            DataGridViewRow dv = dataGridView1.CurrentRow;
            //if(dv.Cells["Lab1"].Visible)
            if(!validateData())
            {
                MessageBox.Show("0=<Mark<=10", "500");
                LoadData();
                return;
               
            }
            else
            {
                string message = "Do you want to save?";
                string title = "Save Mark";
                MessageBoxButtons buttons = MessageBoxButtons.YesNo;
                DialogResult result = MessageBox.Show(message, title, buttons);
                if (result == DialogResult.Yes)
                {
                    try
                    {
                        for(int i = 0; i < dataGridView1.Rows.Count; i++) {
                        DAO.UpdateMark(dataGridView1.Rows[i].Cells["StudentRollNo"].Value.ToString(),
                        dataGridView1.Rows[i].Cells["SubjectCode"].Value.ToString(),
                         dataGridView1.Rows[i].Cells["Lab1"].Value.ToString(),
                         dataGridView1.Rows[i].Cells["Lab2"].Value.ToString(),
                         dataGridView1.Rows[i].Cells["Lab3"].Value.ToString(),
                         dataGridView1.Rows[i].Cells["Lab4"].Value.ToString()
                        , dataGridView1.Rows[i].Cells["PT1"].Value.ToString(),
                         dataGridView1.Rows[i].Cells["PT2"].Value.ToString(),
                         dataGridView1.Rows[i].Cells["Assignment"].Value.ToString()
                        , dataGridView1.Rows[i].Cells["PE"].Value.ToString(),
                         dataGridView1.Rows[i].Cells["FE"].Value.ToString());
                        }
                       
                    }
                    catch
                    {

                    }
                    LoadData();
                }

                else
                {
                    // Do something  
                }
             
            }
            
        }
        private void form_close(object sender, EventArgs e)
        {
            login.Close();
        }
            private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
            login.Close();
            
        }

        private void dataGridView1_CellValueChanged(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
