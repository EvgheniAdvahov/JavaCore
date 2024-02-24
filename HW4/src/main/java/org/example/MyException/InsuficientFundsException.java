package org.example.MyException;

public class InsuficientFundsException extends Exception{
    double balance;
    double withdraw;

    public InsuficientFundsException(double balance, double withdraw) {
        this.balance = balance;
        this.withdraw = withdraw;
    }

    @Override
    public String getMessage() {
        return "На счёте " + balance + ", сумма которую хотите снять " + withdraw;
    }
}
