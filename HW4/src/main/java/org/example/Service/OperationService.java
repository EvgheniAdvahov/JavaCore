package org.example.Service;

import org.example.MyException.InsuficientFundsException;
import org.example.Service.Operations.Depozit;
import org.example.Service.Operations.Operation;

public class OperationService {

    public static void operationCheck(Operation operation) {
        double balance = operation.getAccount().getBalance();
        double withdraw = operation.getAmount();
        if(operation instanceof Depozit){
            if (operation.getAmount() < 0)
                throw new IllegalArgumentException("Депозит не может быть отрицательным " + operation.getAmount());
        } else {
            if (operation.getAmount() > operation.getAccount().getBalance())
                throw new InsuficientFundsException(balance, withdraw);
        }
    }
}
