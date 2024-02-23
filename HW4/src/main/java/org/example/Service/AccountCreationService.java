package org.example.Service;

import org.example.Account;

public class AccountCreationService {
    public static void checkAccount(Account account) throws IllegalArgumentException {
        if(account.getBalance() < 0)
            throw new IllegalArgumentException("Баланс аккаунта " + account.getName() + " не может быть отрицательным " + account.getBalance());
    }

}
