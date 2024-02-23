package org.example.Service.Sort;

import org.example.Account;

import java.util.Comparator;

public class SortByBalance implements Comparator<Account> {

    @Override
    public int compare(Account account1, Account account2) {
        if(account1.getBalance() == account2.getBalance()){
            return 0;
        } else if (account1.getBalance() < account2.getBalance()) {
            return -1;
        } else return 1;
    }
}
