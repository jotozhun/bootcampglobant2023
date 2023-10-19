
package org.globant.bank.bootcampglobant2023.AppGlobantBank;

import java.time.LocalDate;

/**
 * BankAccount
 */
public class BankAccount {
    private int accountNumber;
    private LocalDate openAccount_date;
    private double balance;

    public BankAccount(int accountNumber, LocalDate openAccount_date, double balance) {
        this.accountNumber = accountNumber;
        this.openAccount_date = openAccount_date;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDate getOpenAccount_date() {
        return openAccount_date;
    }

    public void setOpenAccount_date(LocalDate openAccount_date) {
        this.openAccount_date = openAccount_date;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}