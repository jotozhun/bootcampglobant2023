package org.globant.user;

import java.time.LocalDateTime;

public class User {
    public String name;
    public String password;
    public double balance;
    public double accountNumber;
    public LocalDateTime openingDate;

    public User(String name, String password, double balance, int accountNumber, LocalDateTime openingDate) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
    }

    public User(){

    }

}
