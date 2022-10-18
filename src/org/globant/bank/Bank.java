package org.globant.bank;

import org.globant.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List <Client> clients = new ArrayList<Client>();
    Client client = new Client();

    public double addMoney(float amount){
        double adder = client.getSavingsAccount() + amount;
        client.setSavingsAccount(adder);
        return client.getSavingsAccount();
    }
    public double withdrawMoney(float amount){
        double retriever = client.getSavingsAccount() - amount;
        client.setSavingsAccount(retriever);
        return client.getSavingsAccount();
    }
    public double transferMoney(double accountNumber, double amount){
        for (int i = 0; i < clients.size(); i++) {
            if(accountNumber == clients.get(i).getAccountNumber()){
                return clients.get(i).getSavingsAccount() + amount;
            }
        }
        return 0;
    }
    public void getClientsLists(){
        for (int i = 0; i < clients.size(); i++) {
            System.out.println("List of clients: ");
            System.out.println("User: " + clients.get(i).getUser());
            System.out.println("Account number: " + clients.get(i).getAccountNumber());
            System.out.println("Date: " + clients.get(i).getOpeningDate());
        }
    }
}
