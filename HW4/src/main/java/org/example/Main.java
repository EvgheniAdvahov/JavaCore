package org.example;

import org.example.MyException.InsuficientFundsException;
import org.example.Service.Operations.Depozit;
import org.example.Service.Operations.Operation;
import org.example.Service.Operations.Withdrawal;
import org.example.Service.Transaction;

public class Main {

    public static void main(String[] args) {
        Account account = null;
        Account account1 = null;
        Account account2 = null;
        Account account3 = null;

        //Account exception
        try {
            account = Account.create("Evgheni", "44-55-666", 23000);
            account1 = Account.create("Sergey", "55-66-777", 35000);
            account2 = Account.create("Vladimir", "77-88-999", -15000);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        //Operation exceptions
        try {
            Operation operation1 = Withdrawal.createWithdraw(account1, 1000000);
            Operation operation2 = Depozit.createDepozit(account1, -5000);
        } catch (InsuficientFundsException e) {
            e.printStackTrace();
        }

        //Transaction exceptions
        try {
            Transaction.SendMoney(account, account1, 30000);
            Transaction.SendMoney(account, account1, -3000);
        } catch (InsuficientFundsException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }


    }
}
