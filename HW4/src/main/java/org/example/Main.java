package org.example;

import org.example.MyException.InsuficientFundsException;
import org.example.Service.*;
import org.example.Service.Operations.Depozit;
import org.example.Service.Operations.Operation;
import org.example.Service.Operations.Withdrawal;

public class Main {

    public static void main(String[] args) {
        Account account = null;
        Account account1 = null;
        Account account2 = null;
        Account account3 = null;

        try {
            account = Account.create("Evgheni", "44-55-666", 23000);
            account1 = Account.create("Sergey", "55-66-777", 35000);
            account2 = Account.create("Vladimir", "77-88-999", -15000);
            account3 = Account.create("Vasilii", "44-55-666", -3000);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }



//        Account account = new Account("Evgheni", "44-55-666", 23000);
//        Account account1 = new Account("Sergey", "55-66-777", 35000);
//        Account account2 = new Account("Vladimir", "77-88-999", -5000);
//
//
//        for (Account bankaccount : AccountList.accountList) {
//            try {
//                AccountCreationService.checkAccount(bankaccount);
//                AccountList.validatedAccountList.add(bankaccount);
//            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(AccountList.validatedAccountList);
//
//        Operation operation = new Depozit(account1, -6000);
//        Operation opeartion1 = new Withdrawal(account, 100000);
//        Operation operation2 = new Depozit(account1, 10000);
//        Operation operation3 = new Withdrawal(account1, 5000);
//
//
//        for (Operation bankOperation : OperationList.operationList) {
//            try{
//                OperationService.operationCheck(bankOperation);
//                OperationList.operationValidList.add(bankOperation);
//            } catch (InsuficientFundsException e) {
//                e.printStackTrace();
//            } catch (IllegalArgumentException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(OperationList.operationValidList);
//
//        Transaction.SendMoney(account, account1, 5000);

    }
}
