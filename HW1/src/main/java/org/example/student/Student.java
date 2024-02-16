package org.example.student;

import org.example.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * класс Студент
 * При создании добавляет студента в ArrayList
 */
public class Student {
    String name;
    public static List<Student> studentList = new ArrayList<>();
    public static UserRepository userRepository = new UserRepository() {
    };

    public static List<Student> getStudentList() {

        return studentList;
    }

    public Student(String name) {
        this.name = name;
        studentList.add(this);
        userRepository.addToStudentList(this);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    @Override
    public String toString() {

        return "Student " + name;
    }
}
