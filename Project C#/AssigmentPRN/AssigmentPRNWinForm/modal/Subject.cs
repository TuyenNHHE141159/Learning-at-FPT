using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace AssigmentPRNWinForm
{
    public class Subject
    {
        public int TeacherID { get; set; }
        public string SubjectCode { get; set; }
        public string SubjectName { get; set; }

        public Subject()
        {
        }

        public Subject(int teacherID, string subjectCode, string subjectName)
        {
            TeacherID = teacherID;
            SubjectCode = subjectCode;
            SubjectName = subjectName;
        }
    }
    public class ListSubject
    {
      
    }
}