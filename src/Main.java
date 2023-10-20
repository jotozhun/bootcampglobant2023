    import models.Bank;
    import models.Client;
    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int option;
            Bank bank = new Bank();

            do {
                System.out.println("[1] Client Menu");
                System.out.println("[2] Admin Menu");
                System.out.println("[0] Exit");
                option = sc.nextInt();
                switch (option){
                    case 1:
                        clearConsole();
                        clientMenu(sc, bank);
                        break;
                    case 2:
                        clearConsole();
                        adminMenu(sc, bank);
                        break;
                    case 0:
                        clearConsole();
                        System.out.println("Closing program, goodbye!");
                        break;
                    default: System.out.println("Invalid option, please try again");
                }
            }while(option != 0);
        }

        public static void adminMenu(Scanner sc, Bank bank){
            int option;

            System.out.println("!--GLOBANT BANK for Admins--!");
            do {
                clearConsole();
                System.out.println("[1] Show list of Clients");
                System.out.println("[0] Exit");
                option = sc.nextInt();
                switch(option) {
                    case 1:
                        clearConsole();
                        bank.printAllUsersInfo();
                        break;
                    case 0:
                        clearConsole();
                        System.out.println("Getting back to Main Menu");
                        break;
                    default: System.out.println("Invalid option, please try again");
                }
            }while(option!=0);
        }

        public static void clientMenu(Scanner sc, Bank bank){
            int option;
            System.out.println("!--GLOBANT BANK for Clients--!");
            Client loggedInClient = null;
            String username;
            String password;

            do{
                clearConsole();
                System.out.println("[1] Log in");
                System.out.println("[2] Register");
                System.out.println("[3] Withdraw money");
                System.out.println("[4] Deposit money");
                System.out.println("[5] Transfer Money");
                System.out.println("[0] Exit");
                option = sc.nextInt();
                switch(option) {
                    case 1: //LogIn option
                        System.out.print("Enter username: ");
                        username = sc.next();
                        System.out.print("Enter password: ");
                        password = sc.next();

                        loggedInClient = bank.loginUser(username, password);

                        if (loggedInClient != null) {
                            System.out.println("Login successful. Welcome, " + loggedInClient.getFirstName() + "!");
                        } else {
                            System.out.println("Login failed. Invalid username or password.");
                        }
                        break;
                    case 2: //Register option
                        System.out.print("Enter first name: ");
                        String firstName = sc.next();
                        System.out.print("Enter last name: ");
                        String lastName = sc.next();
                        System.out.print("Enter username: ");
                        username = sc.next();
                        System.out.print("Enter password: ");
                        password = sc.next();
                        bank.createUser(0, firstName, lastName, username, password);
                        System.out.println("User registered successfully.");
                        break;
                    case 3: // Withdraw money
                        if(loggedInClient==null){
                            System.out.println("You haven't log in!");
                            break;
                        }
                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmount = sc.nextDouble();
                        loggedInClient.withdraw(withdrawAmount);
                        break;
                    case 4: // Deposit money
                        if(loggedInClient==null){
                            System.out.println("You haven't log in!");
                            break;
                        }
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = sc.nextDouble();
                        loggedInClient.deposit(depositAmount);
                        break;
                    case 5: // Transfer money
                        if(loggedInClient==null){
                            System.out.println("You haven't log in!");
                            break;
                        }
                        System.out.print("Enter the recipient's account number: ");
                        int recipientAccountNumber = sc.nextInt();
                        Client recipientClient = bank.findClientByAccountNumber(recipientAccountNumber);

                        if (recipientClient != null) {
                            System.out.print("Enter the amount to transfer: ");
                            double transferAmount = sc.nextDouble();
                            loggedInClient.transfer(recipientClient, transferAmount);
                        } else {
                            System.out.println("Recipient not found.");
                        }
                        break;
                    case 0:
                        System.out.println("Getting back to Main Menu");
                        break;
                    default: System.out.println("Invalid option, please try again");
                }
            }while(option!=0);
        }

        public static void clearConsole() {
            for(int i=0; i<25; i++) {
                System.out.println("\n");
            }
        }
    }