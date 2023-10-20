package models;
import java.util.Calendar;

public class SavingsAccount {
    private int accountNumber;
    private Calendar createdAt;
    private double balance;

    public SavingsAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.createdAt = Calendar.getInstance();
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Calendar getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Calendar createdAt) {
        this.createdAt = createdAt;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
