package org.globantBank.data;

import java.util.Date;

public class Account {

    private int number;
    private double balance;
    private Date openingDate;

    public Account(){
        this.number = (int)Math.random();
        this.balance = 0;
        this.openingDate = new Date();
    }
}
