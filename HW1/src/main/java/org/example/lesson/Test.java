package org.example.lesson;

import org.example.service.Service;
import org.example.student.Student;

/**
 * Точка входа
 * 1.компиляция и создание директории с расширенями .class
 * $ javac -sourcepath ./java -d out ./java/org/example/lesson/Test.java
 * 2. запускаем из командной строки после компиляции
 * java -classpath ./out org.example.lesson.Test
 * 3. cделать документаци с помощью команды
 * java doc(через консоль погуглить) либо через Intellij Idea
 */


public class Test {

    public static void main(String[] args) {

        Service lesson = new Service();

        Student student1 = new Student("Popov Vasilii");
        Student student2 = new Student("Ivanov Ivan");
        Student student3 = new Student("Sidorov Sergey");
        Student student4 = new Student("Petrova Olga");
        Student student5 = new Student("Konenkova Natalya");

        lesson.presence();
        lesson.test();

        System.out.println(Student.userRepository.getStudentList1());
        System.out.println(Student.getStudentList());


    }

}
