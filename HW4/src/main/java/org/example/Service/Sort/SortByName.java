package org.example.Service.Sort;

import org.example.Account;

import java.util.Comparator;

public class SortByName implements Comparator<Account> {

    @Override
    public int compare(Account account1, Account account2) {
        return account1.getName().compareTo(account2.getName());
    }
}
