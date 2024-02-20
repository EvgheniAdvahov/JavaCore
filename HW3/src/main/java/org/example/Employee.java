package org.example;

import java.time.LocalDate;
import java.util.Comparator;

public class Employee implements Comparator<Employee> {

    private int salary;
    private String name;
    private LocalDate birthday;

    protected Employee() {
    }

    public Employee(int salary, String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.salary = salary;

    }

    public static Employee create(String name, int year, int month, int day, int salary) {
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
        return new Employee(salary, name, LocalDate.of(year, month, day));
    }

    public static Integer updateSalary(Employee employee, int percent) {
        return (employee.getSalary() * percent) / 100 + employee.getSalary();
    }

    protected int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
