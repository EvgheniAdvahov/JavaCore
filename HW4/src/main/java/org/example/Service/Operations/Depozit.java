package org.example.Service.Operations;

import org.example.Account;

public class Depozit extends Operation {

    private Depozit(Account account, double amount) {
        super(account, amount);
        account.setBalance(account.getBalance() + amount);
    }

    public static Depozit createDepozit(Account account, double amount) {
        try {
            if (amount < 0)
                throw new IllegalArgumentException("Депозит не может быть отрицательным " + amount);
            return new Depozit(account, amount);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public String toString() {
        return "Depozit{" +
                "account=" + getAccount() +
                ", amount=" + getAmount() +
                '}';
    }
}
