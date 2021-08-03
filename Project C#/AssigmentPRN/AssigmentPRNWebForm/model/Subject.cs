using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace AssigmentPRNWebForm.model
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
}