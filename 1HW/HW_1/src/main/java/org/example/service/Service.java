package org.example.service;

import org.example.student.Student;

import java.util.Random;


/**
 * Класс Service
 * для обработки методов
 */
public class Service {

    public Service() {

    }

    /**
     * метод случайно выберает студента который будет отвечать
     */
    public void test(){
        Random rand = new Random();
        Student randomStudent = Student.studentList.get(rand.nextInt(Student.studentList.size()));
        System.out.println("Сегодня будет ответчать " + randomStudent.getName());
    }


    /**
     * метод который выводи кол-во студентов на уроке
     */
    public void presence(){
        System.out.println("Сегодня на уроке присутсвует " + Student.studentList.size() + " студентов");
        for (Student student : Student.studentList) {
            System.out.println(student);
        }
    }
}
