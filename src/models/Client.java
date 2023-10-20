package models;

public class Client {
    private SavingsAccount account;
    private String user;
    private String password;
    private String firstName;
    private String lastName;

    public Client(int accountNumber, double balance, String firstName, String lastName, String user, String password) {
        account = new SavingsAccount(accountNumber, balance);
        this.user = user;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Funciones del Usuario
    public void deposit(double amount) {
        if (amount > 0) {
            account.setBalance(account.getBalance() + amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Deposit failed. Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        double tax = 0;

        if (amount > 0 && amount <= account.getBalance()) {
            if (amount < 1000) {
                tax = 200;
            } else {
                tax = 200 + (0.15 * (amount - 1000));
            }

            double totalWithdrawal = amount + tax;

            if (account.getBalance() >= totalWithdrawal) {
                account.setBalance(account.getBalance() - totalWithdrawal);
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                System.out.println("Tax applied: " + tax);
            } else {
                System.out.println("Withdrawal failed. Insufficient balance. Current balance: " + account.getBalance());
            }
        } else {
            System.out.println("Withdrawal failed. Invalid amount or insufficient balance. Current balance: " + account.getBalance());
        }
    }

    public void transfer(Client recipient, double amount) {
        double tax = 100;

        if (amount > 0 && amount <= account.getBalance()) {
            if (recipient != this) {
                if (account.getBalance() >= amount + tax) {
                    account.setBalance(account.getBalance() - amount - tax);
                    recipient.getAccount().setBalance(recipient.getAccount().getBalance() + amount);
                    System.out.println("Transfer successful. New balance: " + account.getBalance());
                    System.out.println("Tax applied: " + tax);
                } else {
                    System.out.println("Transfer failed. Insufficient balance. Current balance: " + account.getBalance());
                }
            } else {
                System.out.println("Transfer failed. You cannot transfer money to yourself.");
            }
        } else {
            System.out.println("Transfer failed. Invalid amount or insufficient balance. Current balance: " + account.getBalance());
        }
    }


    //GETTERS & SETTERS

    public SavingsAccount getAccount() {
        return account;
    }

    public void setAccount(SavingsAccount account) {
        this.account = account;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
