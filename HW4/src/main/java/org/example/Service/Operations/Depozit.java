package org.example.Service.Operations;

import org.example.Account;
import org.example.OperationList;
import org.example.Service.Operations.Operation;

public class Depozit extends Operation {

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
