package org.example;

public class Freelancer extends BasicWorker{
    private int wagePerHour;

    public Freelancer(String name, int age, String city, int wagePerHour) {
        super(name, age, city);
        this.wagePerHour = wagePerHour;
    }

    @Override
    double monthSalary() {
        return 20.8 * 8 * wagePerHour;
    }

    @Override
    public String toString() {
        return "Freelancer{" +
                "name='" + name + '\'' +
                ", wagePerHour=" + wagePerHour +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }


}
