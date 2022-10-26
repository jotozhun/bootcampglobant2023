package org.globantBank.view;

import org.globantBank.data.Admin;
import org.globantBank.data.Bank;
import org.globantBank.data.Client;
import org.globantBank.persistence.DataInitializer;

import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Bank myBank = DataInitializer.loadBank();
        Scanner scan = new Scanner(System.in);
        boolean isAuthValid = false;

        do {
            System.out.println("Bienvenido a " + myBank.getName());
            System.out.println("Ingrese su nombre de usuario");
            String username = scan.nextLine();
            scan = new Scanner(System.in);
            System.out.println("Ingrese su contraseña");
            String password = scan.nextLine();
            scan = new Scanner(System.in);

            Admin loggedAdmin = myBank.authenticateAdmin(username, password);
            if (loggedAdmin.getUsername() != null) {
                displayAdminView(myBank);
            } else {
                Client loggedClient = myBank.authenticateClient(username, password);
                if (loggedClient.getName() != null) {
                    displayClientView(myBank, loggedClient);
                } else {
                    System.out.println("Los datos de inicio de sesión no son válidos");
                }
            }
        } while (!isAuthValid);
    }

    public static void displayAdminView(Bank bank){
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        do{
            System.out.println("Bienvenido al menú de administrador");
            System.out.println("Ingrese 1 para imprimir los clientes");
            System.out.println("Ingrese 2 para cerrar sesión");
            String option = scan.nextLine();
            scan = new Scanner(System.in);
            switch (option){
                case "1":
                    printClientList(bank);
                    break;
                case "2":
                    exit = true;
                    break;
                default:
                    System.out.println("Por favor ingrese una opción válida");
                    break;
            }
        } while(!exit);
    }

    public static void displayClientView(Bank bank, Client client){
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        do{
            System.out.println("Bienvenido al menú de Cliente");
            System.out.println("Ingrese 1 para hacer depósito");
            System.out.println("Ingrese 2 para hacer retiro");
            System.out.println("Ingrese 3 para hacer transferencia");
            System.out.println("Ingrese 4 para hacer cerrar sesión");
            String option = scan.nextLine();
            scan = new Scanner(System.in);
            switch (option){
                case "1":
                    addMoney(client);
                    break;
                case "2":
                    withdrawMoney();
                    break;
                case "3":
                    transferMoney();
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Por favor ingrese una opción válida");
                    break;
            }
        } while(!exit);
    }

    public static void printClientList(Bank bank){
        if(bank.getClientsAmount() == 0){
            System.out.println("No hay clientes registrados en el sistema");
        } else{
            for (int i = 0; i < bank.getClientsAmount(); i++){
                System.out.println(bank.getClientByIndex(i));
            }
        }
    }

    public static void addMoney(Client client){
        System.out.println("Ingrese la cantidad de dinero que desea depositar");
        Scanner scan = new Scanner(System.in);
        double moneyToAdd = scan.nextDouble();
        boolean result = client.addMoneyIntoAccount(moneyToAdd);
        if (result){
            System.out.println("Se completó la transacción exitosamente, el nuevo saldo es de: " + client.getAccountBalance());
        } else {
            System.out.println("No se pudo completar la transacción, la cantidad a depositar no es válida");
        }
    }

    public static void withdrawMoney(){

    }

    public static void transferMoney(){

    }

}
