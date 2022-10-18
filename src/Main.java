import org.globant.bank.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Bank bank = new Bank();

        System.out.println("Welcome to the bank");

        byte options;
        byte internalOptions;

        do {
            System.out.println("Do you have an account? \n 1. Log in. \n 2. Create an account. \n 0. Exit.");
            options = scan.nextByte();

            switch (options){
                case 1:
                    System.out.println("Enter your username:");
                    String username = scan.next();
                    System.out.println("Enter your password:");
                    String password = scan.next();
                    if(bank.userValidator(username, password)){
                        do{
                            System.out.println("Welcome to your account \n what do you want to do? \n 1. Make a withdraw. \n 2. Add money. \n 3. Transfer money to another account \n 0. Exit.");
                            internalOptions = scan.nextByte();
                            switch(internalOptions) {
                                case 1:
                                    System.out.println("How much money do you want to retrieve?");
                                    double withdraw = scan.nextDouble();
                                    bank.withDraw(withdraw);
                                    break;
                                case 2:
                                    System.out.println("How much money do you want to save?");
                                    double amount = scan.nextDouble();
                                    bank.addMoney(amount);
                                    break;
                                case 3:
                                    System.out.println("How much money do you want to transfer?");
                                    double moneyToTransfer = scan.nextDouble();
                                    System.out.println("Who do you want to send the money to?");
                                    double accountToTransfer = scan.nextDouble();
                                    break;
                            }
                        } while(internalOptions != 0);
                    } else {
                        System.out.println("This user doesn't exits. If you want to create an account press 2.");
                    }
                    break;
                case 2:
                    bank.createUser();
                    break;
            }
        }while(options != 0);
    }
}
