package org.example;

import java.io.IOException;

public class Account  {

    String name;
    String phone;

    double balance;

    public Account(String name, String phone, double balance)  {
        this.name = name;
        this.phone = phone;
        this.balance = balance;
        AccountList.accountList.add(this);
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
