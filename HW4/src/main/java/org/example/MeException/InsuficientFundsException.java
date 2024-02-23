package org.example.MeException;

public class InsuficientFundsException extends IllegalArgumentException{

    @Override
    public String getMessage() {
        return "Не достаточно денег на счёте!";
    }
}
