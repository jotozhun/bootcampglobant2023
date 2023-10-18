package com.globant.bank;

public class User {
    private BankAccount bankAccount;
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        bankAccount = new BankAccount();
    }

    public User(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        bankAccount = new BankAccount(balance);
    }

    public void makeWithdraw(double amount){
        double tax = (amount < 1000) ? 200 : 200 + .15*amount;
        double total = amount + tax;
        bankAccount.setBalance(bankAccount.getBalance() - total);
    }

    public void addMoney(double amount){
        bankAccount.setBalance(bankAccount.getBalance() + amount);
    }

    public void transferMoney(BankAccount destinationAccount, double amount){
        double tax = 100;
        double total = amount + tax;
        bankAccount.setBalance(bankAccount.getBalance() - total);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "bankAccount=" + bankAccount +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
