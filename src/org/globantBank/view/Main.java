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
                displayAdminView();
            } else {
                Client loggedClient = myBank.authenticateClient(username, password);
                if (loggedClient.getName() != null) {
                    displayClientView();
                } else {
                    System.out.println("Los datos de inicio de sesión no son válidos");
                }
            }
        } while (!isAuthValid);
    }

    public static void displayAdminView(){

    }

    public static void displayClientView(){

    }

}
