package Globant_Bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Client client = new Client();
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Bank_account> bank_accounts = new ArrayList<>();
        Bank bank = new Bank(clients, client, bank_accounts);

        Bank_account bank_a1 = new Bank_account(1,LocalDate.of(2023,02,3), 20);
        Bank_account bank_a2 = new Bank_account(2,LocalDate.of(2023,02,3), 20);
        Bank_account bank_a3 = new Bank_account(3,LocalDate.of(2023,02,3), 20);
        Bank_account bank_a4 = new Bank_account(4,LocalDate.of(2023,02,3), 20);
        Bank_account bank_a5 = new Bank_account(5,LocalDate.of(2023,02,3), 20);

        Client client1 = new Client(1,10000 ,"David", "123a", bank_a1);
        Client client2 = new Client(2,20000 ,"Daniel", "32e1", bank_a2);
        Client client3 = new Client(3,30000 ,"Robi", "456e",bank_a3);
        Client client4 = new Client(4,40000 ,"Dan", "65a", bank_a4);
        Client client5 = new Client(5,50000 ,"Dayi", "341a",bank_a5);

        bank_accounts.add(bank_a1);
        bank_accounts.add(bank_a2);
        bank_accounts.add(bank_a3);
        bank_accounts.add(bank_a4);
        bank_accounts.add(bank_a5);

        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);

        bank.login();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Bank Menu");

            System.out.println("1. Make a Withdraw");
            System.out.println("2. Add Money");
            System.out.println("3. Transfer Money to Another Bank Account");
            System.out.println("4. List All Clients and Their Information");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bank.withdraw();
                    break;
                case 2:
                    bank.add();
                    break;
                case 3:
                    bank.transfer();
                    break;
                case 4:
                    bank.list_clients();
                    break;
                case 5:
                    System.out.println("Exiting the bank menu. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 5);
    }
}
