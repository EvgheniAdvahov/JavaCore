package org.example.MeException;

public class InsuficientFundsException extends IllegalArgumentException{
    double balance;
    double withdraw;

    public InsuficientFundsException(double balance, double withdraw) {
        this.balance = balance;
        this.withdraw = withdraw;
    }

    @Override
    public String getMessage() {
        return "На счёте " + balance + " сумма которую хотите снять " + withdraw;
    }
}
