
import java.util.Date;

public class BankAccount {
    private int accountNumber;
    private Date openingDate;
    private double balance;
    public BankAccount(int accountNumber, Date openingDate, double initialBalance) {
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        double withdrawalAmount = amount;
        if (withdrawalAmount < 1000) {
            withdrawalAmount += 200;
        } else {
            withdrawalAmount += 200 + 0.15 * amount;
        }
        if (withdrawalAmount <= balance) {
            balance -= withdrawalAmount;
            return true;
        }
        return false;
    }


}
