package org.example.Service;

import org.example.MeException.InsuficientFundsException;

public class OperationService {

    public static void operationCheck(Operation operation) {
        if(operation instanceof Depozit){
            if (operation.getAmount() < 0)
                throw new IllegalArgumentException("Депозит не может быть отрицательным");
        } else {
            if (operation.getAmount() > operation.getAccount().getBalance())
                throw new InsuficientFundsException();
        }

    }
}
