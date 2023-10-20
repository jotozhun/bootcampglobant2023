package models;
import java.util.ArrayList;

public class Bank {
    private ArrayList<Client> clientList;
    private int accountNumberCounter = 10000000;

    public Bank() {
        clientList = new ArrayList<>();
    }

    public void createUser(double balance, String firstName, String lastName, String username, String password) {
        Client newClient = new Client(this.accountNumberCounter, balance, firstName, lastName, username, password);
        clientList.add(newClient);
        accountNumberCounter++;
    }

    public void printAllUsersInfo() {
        for (Client client : clientList) {
            System.out.println("Account Number: " + client.getAccount().getAccountNumber());
            System.out.println("First Name: " + client.getFirstName());
            System.out.println("Last Name: " + client.getLastName());
            System.out.println("Username: " + client.getUser());
            System.out.println("Balance: " + client.getAccount().getBalance() + "\n");
        }
    }

    public Client loginUser(String username, String password) {
        for (Client client : clientList) {
            if (client.getUser().equals(username) && client.getPassword().equals(password)) {
                return client;
            }
        }
        return null;
    }

    public Client findClientByAccountNumber(int accountNumber) {
        for (Client client : clientList) {
            if (client.getAccount().getAccountNumber() == accountNumber) {
                return client;
            }
        }
        return null;
    }

}