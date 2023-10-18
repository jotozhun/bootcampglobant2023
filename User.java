
package org.globant.bank.bootcampglobant2023;

/**
 * User
 */
public class User {
    private int id;
    private String user;
    private String password;
    private BankAccount bankAccount;

    public User(int id, String user, String password, BankAccount bankAccount) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.bankAccount = bankAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "id: " + id + " Account Number: " + bankAccount.getAccountNumber() + ", user: " + user + ", Balance:"
                + bankAccount.getBalance()
                + ", Date apen account: " + bankAccount.getOpenAccount_date();
    }

}