
package org.globant.bank.bootcampglobant2023.AppGlobantBank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate localDate = LocalDate.of(2023, 10, 18);
        ArrayList<User> users = new ArrayList<>();
        Bank bank = new Bank(users);

        User user = new User(1, "edjo", "123", new BankAccount(12346, localDate, 1500));
        User user1 = new User(2, "josi", "1234", new BankAccount(12347, localDate, 1500));
        User user2 = new User(3, "rio", "12345", new BankAccount(12348, localDate, 1500));

        users.add(user);
        users.add(user1);
        users.add(user2);

        System.out.println("Welcome to Globant Bank");
        boolean validation = false;
        do {
            System.out.println(" Login ");
            System.out.println("User: ");
            String client = sc.nextLine();
            System.out.println("Password: ");
            String password = sc.nextLine();

            if (bank.login(client, password)) {
                do {

                    Printer.showMenu();
                    int option = sc.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("Enter the mount: ");
                            double mountW = sc.nextDouble();
                            bank.withDraw(mountW, client);
                            Printer.requestPrinter(option, mountW, bank, client, option);
                            validation = true;
                            break;

                        case 2:
                            System.out.println("Enter the mount: ");
                            double mountA = sc.nextDouble();
                            bank.add(mountA, client);
                            Printer.requestPrinter(option, mountA, bank, client, option);
                            validation = true;
                            break;

                        case 3:
                            System.out.println("Enter the mount: ");
                            double mountT = sc.nextDouble();
                            System.out.println("Enter the destination account:");
                            int account = sc.nextInt();
                            bank.transfering(mountT, client, account);
                            Printer.requestPrinter(option, mountT, bank, client, account);
                            validation = true;
                            break;
                        case 4:
                            System.out.println("Clients");
                            bank.informationUser();
                            validation = true;
                            break;

                        case 5:
                            validation = false;
                            System.out.println("Bye!");
                            break;
                        default:
                            System.out.println("Invalid option, please try again.");

                    }
                } while (validation);

            } else {
                System.out.println("The data entered does not match. try again!");
                validation = true;
            }

        } while (validation);
        sc.close();
    }

}