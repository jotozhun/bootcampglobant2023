package org.globant.client;

import java.time.LocalDateTime;

public class Client {
    private String user;
    private String password;
    private double savingsAccount;
    private Double accountNumber;
    private LocalDateTime openingDate;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(double savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public Double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public Client(String user, String password, double savingsAccount, Double accountNumber, LocalDateTime openingDate) {
        this.user = user;
        this.password = password;
        this.savingsAccount = savingsAccount;
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
    }
    public Client() {
    }
}
