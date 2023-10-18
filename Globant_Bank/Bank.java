package Globant_Bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<Client> clients = new ArrayList<>();
    private ArrayList<Bank_account> bank_accounts = new ArrayList<>();
    Client currentClient;

    public Bank(ArrayList<Client> clients, Client currentClient, ArrayList<Bank_account> bank_accounts) {
        this.clients = clients;
        this.currentClient = currentClient;
        this.bank_accounts = bank_accounts;
    }

    public void list_clients(){
        int cont = 0;
        for (Client user: clients) {
            cont++;
            System.out.println("Client #"+ cont + ": "+user.toString()+"\n");
        }
    }

    private Client findClientByUsername(String username) {
        for (Client client : clients) {
            if (client.getUser().equals(username)) {
                return client;
            }
        }
        return null; //not found
    }

    public boolean login() {
        String username;
        String password;
        int attempts = 5;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to globant bank, please enter your credentials to proceed");
        while (attempts > 0) {
            System.out.println("Enter your username: ");
            username = sc.nextLine();
            System.out.println("Enter your password: ");
            password = sc.nextLine();

            Client foundClient = findClientByUsername(username);

            if (foundClient != null && foundClient.getPassword().equals(password)) {
                currentClient = foundClient;
                return true; // Success authentication
            } else {
                System.out.println("Invalid username or password. You have " + (attempts - 1) + " attempts left.");
                attempts--;
            }
        }
        System.out.println("You exceeded the limit of attempts. Try again later.");
        return false; // Autenticación fallida
    }

    public void withdraw(){
        double tax = 200;
        double withdraw;
            Scanner sc = new Scanner(System.in);
            System.out.println("How much money are you going to withdraw from your account?");
            withdraw = sc.nextDouble();
            if(withdraw <= currentClient.getSaving_account()) {
                if(withdraw > 1000) {
                    currentClient.setSaving_account(currentClient.getSaving_account() - (withdraw * (15 / 100)) - (withdraw+tax));
                    System.out.println("$" + withdraw + " dollars were withdrawn from your account, you have " + currentClient.getSaving_account() + " left");
                    System.out.println("$" + ((withdraw * (15 / 100)) - (withdraw+tax)) + "dollars have been deducted from taxes");

                }
                currentClient.setSaving_account(currentClient.getSaving_account() - (tax + withdraw));
                System.out.println("$" + withdraw + " dollars were withdrawn from your account, you have " + currentClient.getSaving_account() + " left");
                System.out.println("$" + ((tax + withdraw)) + " dollars have been deducted from taxes");
            }
    }

    public void add(){
        double add;
        Scanner sc = new Scanner(System.in);
        System.out.println("How much money are you going to add to your account?");
        add = sc.nextDouble();
        currentClient.setSaving_account(currentClient.getSaving_account()+add);
        System.out.println("You have successfully deposited $"+ add +" dollars to your account, you have a total of $"+ currentClient.getSaving_account() +" dollars saved");
    }

    private boolean findClientByAccountNumber(int account_number) {
        for (Bank_account account : bank_accounts) {
            if (account.getAccount_number() == account_number) {
                System.out.println("User not found");
                return true;
            }
        }
        return false; //not found
    }

    public void transfer(){
        Scanner sc = new Scanner(System.in);
        int bank_account;
        double transfer;
            System.out.println("Enter the account number to which you are going to transfer the money");
            bank_account = sc.nextInt();
            if(findClientByAccountNumber(bank_account)){
                System.out.println("Enter the amount of money to transfer");
                transfer = sc.nextDouble();
                send_money(bank_account, transfer);
            }else{
                System.out.println("Account number not found");
            }
        }
    public void send_money(int account_number,double transfer){
        int cont = 0;
        for (Bank_account account: bank_accounts) {
            if(account.getAccount_number() == account_number){
                clients.get(cont).setSaving_account(currentClient.getSaving_account()+transfer);
                currentClient.setSaving_account(currentClient.getSaving_account()-(transfer-100));
                System.out.println("$"+ transfer +" dollars have been successfully transferred to "+ clients.get(cont).getUser());
                System.out.println("There are $"+ currentClient.getSaving_account() +" dollars left in your account");
            }
            cont++;
        }
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {

        this.clients = clients;
    }
}
