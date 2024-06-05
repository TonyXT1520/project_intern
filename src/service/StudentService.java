package service;

import dao.DataImplement;
import model.StudentInfo;

import java.util.List;

public class StudentService {
    private DataImplement dataImplement;

    public StudentService() {
        this.dataImplement = new DataImplement();
    }

    public List<StudentInfo> getAllStudents() {
        return dataImplement.getAllStudents();
    }

    public void addStudent(StudentInfo studentInfo){
        dataImplement.addStudent(studentInfo);
    }

    public void deleteStudent(int studentId){
        dataImplement.deleteStudent(studentId);
    }

    public void updateStudent(StudentInfo studentInfo){
        dataImplement.updateStudent(studentInfo);
    }
}

