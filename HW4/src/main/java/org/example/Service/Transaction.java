package org.example.Service;

import org.example.Account;
import org.example.CreditAccount;
import org.example.DebitAccount;

public class Transaction {

    Account account;

    public static void SendMoney(Account account, Account account1, double amount){
        account.setBalance(account.getBalance()- amount);
        account1.setBalance(account1.getBalance() + amount);
    }
}
