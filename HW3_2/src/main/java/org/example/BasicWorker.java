package org.example;

public abstract class BasicWorker implements Comparable<BasicWorker> {

    String name;
    int age;
    String city;

    public BasicWorker(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    abstract double monthSalary();

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(BasicWorker o) {
        return Integer.compare(this.getAge(), o.getAge());
    }
}
