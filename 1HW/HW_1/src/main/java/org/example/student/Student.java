package org.example.student;

import java.util.ArrayList;
import java.util.List;

/**
 * класс Студент
 * При создании добавляет студента в ArrayList
 */
public class Student {
    String name;
    public static List<Student> studentList = new ArrayList<>();

    public Student(String name) {
        this.name = name;
        studentList.add(this);
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
