import org.globant.bank.Bank;
import org.globant.client.Client;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Setting the input
        Scanner input = new Scanner(System.in);

        Client client = new Client();
        Bank bank = new Bank();
        LocalDateTime date = LocalDateTime.now();

        byte action;
        byte internalOptions;
        do {
            System.out.println("Welcome to Bank-App!");
            System.out.println("Do you have an account?\n 1. Log in\n 2. Create an account\n 0. Exit");
            action = input.nextByte();
            switch (action) {
                case 1:
                    System.out.println("Enter your user name: ");
                    String userName = input.next();
                    System.out.println("Enter your password: ");
                    String password = input.next();
                    if (userName == client.getUser() && password == client.getPassword()) {
                        System.out.println("Welcome " + client.getUser() + " what do you want to do today?\n 1. Add money\n 2. Retrieve money\n 3. Transfer money\n 0. Exit");
                        internalOptions = input.nextByte();
                        switch (internalOptions){
                            case 1:
                                System.out.println("Enter the amount to add: ");
                                float amount_to_save = input.nextFloat();
                                bank.addMoney(amount_to_save);
                                System.out.println("The money has been deposited!");
                                break;
                        }
                    } else {
                        System.out.println("You don´t have an account yet, press option 2 to create an account.\n");
                    }
                    break;
                case 2:
                    System.out.println("Enter your name: ");
                    client.setUser(input.next());
                    System.out.println("Enter your password: ");
                    client.setPassword(input.next());
                    client.setAccountNumber(Math.random());
                    client.setSavingsAccount(0);
                    client.setOpeningDate(date);
                    System.out.println("Your account has been successfully created!");
                    break;
            }
        } while(action != 0);
    }
}