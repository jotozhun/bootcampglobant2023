package Globant_Bank;

import java.time.LocalDate;

public class Bank_account {
    private int account_number;
    private LocalDate opening_date;
    private double balance;

    public Bank_account(int account_number, LocalDate opening_date, double balance) {
        this.account_number = account_number;
        this.opening_date = opening_date;
        this.balance = balance;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }


    @Override
    public String toString() {
        return "Account number=" + account_number + "\n" +
                "Opening date=" + opening_date + "\n" +
                "Balance = " + balance;
    }
}
