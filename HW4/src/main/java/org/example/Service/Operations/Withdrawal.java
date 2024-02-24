package org.example.Service.Operations;

import org.example.Account;
import org.example.MyException.InsuficientFundsException;

public class Withdrawal extends Operation {

    private Withdrawal(Account account, double amount) {
        super(account, amount);
        account.setBalance(account.getBalance() - amount);
    }

    public static Withdrawal createWithdraw(Account account, double amount) throws InsuficientFundsException {
        try {
            if (account.getBalance() < amount) {
                throw new InsuficientFundsException(account.getBalance(), amount);
            } else {
                return new Withdrawal(account, amount);
            }
        } catch (InsuficientFundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Withdrawal{" +
                "account=" + getAccount() +
                ", amount=" + getAmount() +
                '}';
    }
}
