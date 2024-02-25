package org.example.Service;

import org.example.Account;
import org.example.CreditAccount;
import org.example.DebitAccount;
import org.example.MyException.InsuficientFundsException;

public class Transaction {

    Account account;

    public static void SendMoney(Account account, Account account1, double amount) throws InsuficientFundsException{
        try {
        if (account.getBalance() < amount){
            throw new InsuficientFundsException(account.getBalance(), amount);
        } else if (amount < 0) {
            throw new IllegalArgumentException("Отправляемая сумма не может быть отрицательной: "+ amount);
        }
        account.setBalance(account.getBalance()- amount);
        account1.setBalance(account1.getBalance() + amount);
        } catch (InsuficientFundsException e){
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
