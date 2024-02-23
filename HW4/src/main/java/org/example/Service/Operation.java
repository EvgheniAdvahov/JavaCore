package org.example.Service;

import org.example.Account;

public abstract class Operation {

    private Account account;
    private double amount;

    public Operation(Account account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }
}
