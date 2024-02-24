package org.example;

public class Account {

    String name;
    String phone;

    double balance;

    protected Account(String name, String phone, double balance) {
        this.name = name;
        this.phone = phone;
        this.balance = balance;
    }

    public static Account create(String name, String phone, double balance) throws IllegalArgumentException {
        try {
            if (balance < 0) {
                throw new IllegalArgumentException("Аккаунт " + name + " не может быть отрицательным " + balance);
            }
            return new Account(name, phone, balance);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }


    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }
}
