import java.util.Date;

public class BankAccount {
    private int number;
    private String openingDate;
    private double balance;

    public BankAccount(int number, String openingDate, double balance) {
        this.number = number;
        this.openingDate = openingDate;
        this.balance = balance;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
