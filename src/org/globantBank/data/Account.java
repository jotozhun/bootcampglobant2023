package org.globantBank.data;

import java.util.Date;

public class Account {

    private int number;
    private double balance;
    private Date openingDate;

    public Account(){
        this.number = (int)(100000 * Math.random());
        this.balance = 0;
        this.openingDate = new Date();
    }

    @Override
    public String toString() {
        return "Cuenta #" + this.number + " balance : " + this.balance + " Creada en : " + this.openingDate;
    }

}
