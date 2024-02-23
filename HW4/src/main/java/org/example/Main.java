package org.example;

import org.example.MeException.InsuficientFundsException;
import org.example.Service.*;

public class Main {

    public static void main(String[] args) {
        Account account = new Account("Evgheni", "44-55-666", 23000);
        Account account1 = new Account("Sergey", "55-66-777", 35000);
        Account account2 = new Account("Vladimir", "77-88-999", 5000);

        Operation opeartion = new Depozit(account, -5000);
        Operation opeartion1 = new Withdrawal(account, 100000);

        for (Operation bankOperation : OperationList.operationList) {
            try{
                OperationService.operationCheck(bankOperation);
            } catch (InsuficientFundsException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

//        System.out.println(AccountList.accountList);
//
//        for (Account bankaccount : AccountList.accountList) {
//            try {
//                AccountCreationService.checkAccount(bankaccount);
//            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
//            }
//        }


    }
}