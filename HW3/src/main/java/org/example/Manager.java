package org.example;

import java.time.LocalDate;

public class Manager extends Employee{


    private Manager(int salary, String name, LocalDate birthday) {
        super(salary, name, birthday);
    }

    public static Manager create(String name, int year, int month, int day, int salary) {
        if (name.length() < 2) {
            throw new RuntimeException("Не корректный ввод имени");
        }
        if (year > 2024) {
            throw new RuntimeException("Не корректный ввод года");
        }
        if (month > 12 || month < 1) {
            throw new RuntimeException("Не корректный ввод месяца");
        }
        if (day > 31 || day < 1) {
            throw new RuntimeException("Не корректный ввод даты");
        }
        if (salary < 7000) {
            throw new RuntimeException("Не корректный ввод зарплаты");
        }
        return new Manager(salary, name, LocalDate.of(year, month, day));
    }

    public static Integer updateSalary(Manager manager) {
        return manager.getSalary();
    }
}
