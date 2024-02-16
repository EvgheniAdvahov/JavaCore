package org.example.repo;

import org.example.student.Student;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<Student> studentList1 = new ArrayList<>();

    public List<Student> getStudentList1() {

        return studentList1;
    }

    public void setStudentList1(List<Student> studentList1) {

        this.studentList1 = studentList1;
    }

    public List<Student> addToStudentList(Student student){
        studentList1.add(student);
        return studentList1;
    }
}
