package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee = Employee.create("Evgheni", 1988, 7, 9, 50000);
        Employee employee2 = Employee.create("Vera", 2020, 2, 2, 35000);
        Employee employee1 = Employee.create("Alexandr", 1978, 3, 15, 45000);
        Employee manager = Manager.create("Vitalii", 1975, 6, 15, 85000);

        employeeList.add(employee);
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(manager);

        employeeList.sort(new Employee());
        System.out.println(employeeList);

        //update salary
        for (Employee object : employeeList) {
            if (object instanceof Manager) {
                object.setSalary(Manager.updateSalary((Manager) object));
            } else {
                object.setSalary(Employee.updateSalary(object, 7));
            }
        }

        System.out.println(employeeList);
    }
}