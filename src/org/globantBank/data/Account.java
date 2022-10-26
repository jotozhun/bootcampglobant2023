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

    public double getBalance() {
        return this.balance;
    }

    public boolean addMoney(double money){
        boolean result = false;
        if (money > 0){
            this.balance = this.balance + money;
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        return "Cuenta #" + this.number + " balance : " + this.balance + " Creada en : " + this.openingDate;
    }

}
