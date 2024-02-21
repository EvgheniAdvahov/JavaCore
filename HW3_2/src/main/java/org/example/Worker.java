package org.example;

public class Worker extends BasicWorker{

    private int monthlyWage;

    public Worker(String name, int age, String city, int monthlyWage) {
        super(name, age, city);
        this.monthlyWage = monthlyWage;
    }

    @Override
    double monthSalary() {
        return monthlyWage;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", monthlyWage=" + monthlyWage +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
