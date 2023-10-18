package Globant_Bank;

import java.util.Scanner;


public class Client {
    private int id;
    private double saving_account;
    private String user;
    private String password;
    private Bank_account bank_account;
    private Bank bank;
    private int id_bank;

    public Client(int id,double saving_account, String user, String password, Bank_account bank_account) {
        this.id = id;
        this.saving_account = saving_account;
        this.user = user;
        this.password = password;
        this.bank_account = bank_account;
    }

    public Client(){
    }

    public double getSaving_account() {
        return saving_account;
    }

    public void setSaving_account(double saving_account) {
        this.saving_account = saving_account;
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

    @Override
    public String toString() {
        return "\nId= " + id + "\n" +
                "Saving account= " + saving_account + "\n" +
                "User= " + user + "\n"+
                bank_account.toString();
    }
}
