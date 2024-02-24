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
    public static Account create(String name, String phone, double balance) throws IllegalArgumentException {
        try{
            if (balance < 0){
                throw new IllegalArgumentException(name + " не может быть отрицательным!!");
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
