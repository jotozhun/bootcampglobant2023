package org.globant.bank;

import org.globant.user.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    LocalDateTime date = LocalDateTime.now();
    Scanner scan = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<User>();
    User user = new User();

    public void listClients(){
        System.out.println("Users list:");
        for (int i = 0; i < users.size(); i++) {
            System.out.println("User: " + users.get(i).name);
            System.out.println("Account number: " + users.get(i).accountNumber);
            System.out.println("Creation date: " + users.get(i).openingDate);
        }
    }

    public boolean userValidator(String username, String password){
        user.name = username;
        user.password = password;

        for (int i = 0; i < users.size(); i++) {
            if(user.name == users.get(i).name && user.password == users.get(i).password){
                return true;
            }
        }
        return false;
    }

    public void createUser(){
        System.out.println("Enter a username");
        user.name = scan.next();
        System.out.println("Enter a password");
        user.password = scan.next();
        user.accountNumber = Math.random() * 10000;
        user.balance = 0;
        user.openingDate = date;
        users.add(user);
        System.out.println("Your user has been created successfully.");
        listClients();
    }

    public void withDraw(double amount){
        double AMOUNT_WITH_TAX = amount + 200;

        if(AMOUNT_WITH_TAX > user.balance){
            System.out.println("You can't retrieve more money than you have.");
            System.out.println("Your current balance is: " + user.balance);
        } else if(AMOUNT_WITH_TAX > 1000){
            double fifteenPercent = amount * 0.15;
            user.balance = user.balance - AMOUNT_WITH_TAX - fifteenPercent;
            System.out.println("The money has been retrieved successfully");
            System.out.println("Your current balance is: " + user.balance);
        } else {
            user.balance = user.balance - AMOUNT_WITH_TAX;
            System.out.println("The money has been retrieved successfully");
            System.out.println("Your current balance is: " + user.balance);
        }
    }

    public void addMoney(double amount){
        user.balance += amount;
        System.out.println("The money has been added successfully.");
        System.out.println("Your current balance is: " + user.balance);
    }
}
