package com.globant.bank;

import java.util.Date;

public class BankAccount {
    private static int counter;
    private String accountNumber;
    private final Date openingDate;
    private double balance;

    public BankAccount() {
        counter++;
        accountNumber = "" + counter + counter + counter;
        openingDate = new Date();
        balance = 0;
    }

    public BankAccount(double balance) {
        this();
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", openingDate=" + openingDate +
                ", balance=" + balance +
                '}';
    }
}
