package org.example.Service;

import org.example.Account;
import org.example.OperationList;

public class Depozit  extends Operation {

    public Depozit(Account account, double amount) {
        super(account, amount);
        account.setBalance(account.getBalance() + amount);
        OperationList.operationList.add(this);
    }

    @Override
    public String toString() {
        return "Depozit{" +
                "account=" + getAccount() +
                ", amount=" + getAmount() +
                '}';
    }
}
