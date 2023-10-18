
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
public class MyBank {
    private final ArrayList<BankClient> clients = new ArrayList<>();
    private final String adminPassword = "admin"; // Admin password
    private final Set<String> usernames = new HashSet<>();

    public void addClient(BankClient client) {
        clients.add(client);
    }

    public void listClients() {
        for (BankClient client : clients) {
            System.out.println("User: " + client.getUser().getUsername());
            System.out.println("Account Number: " + client.getAccount().getAccountNumber());
            System.out.println("Balance: " + client.getAccount().getBalance());
            System.out.println();
        }
    }

    public void userMenu(BankClient client) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("User Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Check Balance");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    client.getAccount().deposit(depositAmount);
                    System.out.println("Deposited successfully.");
                    break;
                case 2:
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    boolean success = client.getAccount().withdraw(withdrawalAmount);
                    if (success) {
                        System.out.println("Withdrawn successfully.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the recipient's account number: ");
                    int recipientAccountNumber = scanner.nextInt();

                    // Find the sender's client
                    BankClient senderClient = null;
                    for (BankClient currentClient : clients) {
                        if (currentClient.getUser().getUsername().equals(client.getUser().getUsername())) {
                            senderClient = currentClient;
                            break;
                        }
                    }

                    // Find the recipient's client
                    BankClient recipientClient = null;
                    for (BankClient targetClient : clients) { // Use 'targetClient' instead of 'client'
                        if (targetClient.getAccount().getAccountNumber() == recipientAccountNumber) {
                            recipientClient = targetClient;
                            break;
                        }
                    }

                    if (recipientClient == null) {
                        System.out.println("Recipient account not found.");
                    } else if (senderClient == recipientClient) {
                        System.out.println("You cannot transfer money to yourself.");
                    } else {
                        System.out.print("Enter the transfer amount: ");
                        double transferAmount = scanner.nextDouble();

                        if (senderClient.getAccount().getBalance() >= transferAmount) {
                            senderClient.getAccount().withdraw(transferAmount);
                            recipientClient.getAccount().deposit(transferAmount);
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Insufficient balance for the transfer.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Balance: " + client.getAccount().getBalance());
                    break;
            }
        } while (choice != 0);
    }

    private void createUserAndBankAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new username: ");
        String newUsername = scanner.next();

        if (usernames.contains(newUsername)) {
            System.out.println("Username is already in use. Please choose another.");
            return;
        }

        System.out.print("Enter new password: ");
        String newPassword = scanner.next();

        if (!isStrongPassword(newPassword)) {
            System.out.println("Password does not meet strong password criteria.");
            return;
        }

        User newUser = new User(newUsername, newPassword);
        usernames.add(newUsername); // Add the new username to the set

        System.out.print("Enter account number for the new bank account: ");
        int newAccountNumber = scanner.nextInt();
        System.out.print("Enter opening balance: ");
        double openingBalance = scanner.nextDouble();
        BankAccount newAccount = new BankAccount(newAccountNumber, new Date(), openingBalance);

        BankClient newClient = new BankClient(newUser, newAccount);
        clients.add(newClient);

        System.out.println("User and bank account created successfully.");
    }
    private boolean isStrongPassword(String password) {
        return password.length() >= 8;
    }

    public static void main(String[] args) {
        MyBank myBank = new MyBank();
        // Create clients, users, and accounts
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        BankAccount account1 = new BankAccount(1, new Date(), 1000);
        BankAccount account2 = new BankAccount(2, new Date(), 2000);
        BankClient client1 = new BankClient(user1, account1);
        BankClient client2 = new BankClient(user2, account2);

        myBank.addClient(client1);
        myBank.addClient(client2);

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("MyBank Menu:");
            System.out.println("1. Administrator");
            System.out.println("2. Client");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter admin password: ");
                String adminInput = scanner.next();
                if (adminInput.equals(myBank.adminPassword)) {
                    int adminChoice;
                    do {
                        System.out.println("Administrator Menu:");
                        System.out.println("1. Create Bank Client");
                        System.out.println("2. List All Clients");
                        System.out.println("0. Exit");
                        System.out.print("Enter your choice: ");
                        adminChoice = scanner.nextInt();

                        switch (adminChoice) {
                            case 1:
                                myBank.createUserAndBankAccount();
                            case 2:
                                myBank.listClients();
                                break;
                        }
                    } while (adminChoice != 0);
                } else {
                    System.out.println("Invalid admin password.");
                }
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String username = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();
                boolean userFound = false;

                for (BankClient client : myBank.clients) {
                    if (client.getUser().getUsername().equals(username) && client.getUser().getPassword().equals(password)) {
                        myBank.userMenu(client);
                        userFound = true;
                        break;
                    }
                }

                if (!userFound) {
                    System.out.println("User not found or invalid credentials.");
                }
            }
        } while (choice != 0);
    }
}
