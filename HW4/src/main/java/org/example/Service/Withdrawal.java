package org.example.Service;

import org.example.Account;
import org.example.OperationList;

public class Withdrawal extends Operation {

    public Withdrawal(Account account, double amount) {
        super(account, amount);
        account.setBalance(account.getBalance() - amount);
        OperationList.operationList.add(this);
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "account=" + getAccount() +
                ", amount=" + getAmount() +
                '}';
    }
}
