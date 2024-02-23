package org.example.Service.Operations;

import org.example.Account;
import org.example.OperationList;
import org.example.Service.Operations.Operation;

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
