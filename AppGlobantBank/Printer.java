package org.globant.bank.bootcampglobant2023.AppGlobantBank;

public class Printer {

    public static void requestPrinter(int option, double mount, Bank bank, String client, int account) {

        if (option == 1) {
            System.out.println("You withdrew $" + mount + " and has a remaining balance of $"
                    + bank.balanceToUser(client));
        } else if (option == 2) {
            System.out.println("You added $" + mount + " and has a remaining balance of $"
                    + bank.balanceToUser(client));
        } else {
            System.out.println("You transferred $" + mount + " to the destination account" + account
                    + ". Your balance is now $"
                    + bank.balanceToUser(client));
        }

    }

    public static void showMenu() {
        System.out.println("Manu");
        System.out.println("1. Withdraw");
        System.out.println("2. Add Money");
        System.out.println("3. Transfer Money");
        System.out.println("4. List All Clients and Their Information");
        System.out.println("5. Exit");
    }
}
