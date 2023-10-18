package com.globant.bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        ArrayList<User> bank = new ArrayList<>();
        User user1 = new User("r4vc31", "r456", 500);
        User user2 = new User("peter", "p123");
        User user3 = new User("helen", "h789", 100);
        Collections.addAll(bank, user1, user2, user3);

        String[] principalOptions = {"Print all clients", "Make a withdraw",
                "Add money", "Transfer money", "Exit"};

        Scanner scanner = new Scanner(System.in);
        String option;

        String username;
        String password;

        User usuario1;
        User usuario2;

        boolean exit = false;
        while (!exit){
            showMenu(principalOptions, "Globant Bank");
            System.out.println("Seleccione una opción: ");
            option = scanner.nextLine();
            switch (option){
                case "1":
                    showElements(bank.toArray());
                    break;
                case "2":
                    System.out.print("Ingrese el nombre de usuario: ");
                    username = scanner.nextLine();
                    usuario1 = null;
                    for (User user :
                            bank) {
                        if (user.getUsername().equals(username)){
                            usuario1 = user;
                        }
                    }
                    if(usuario1 == null){
                        System.out.println("El usuario no existe.");
                    }else{
                        System.out.println("Ingrese la contraseña");
                        password = scanner.nextLine();
                        if (usuario1.getPassword().equals(password)){
                            System.out.println("Ingrese la cantidad a retirar: ");
                            double cantidad = Double.parseDouble(scanner.nextLine());
                            usuario1.makeWithdraw(cantidad);
                        }else{
                            System.out.println("Datos Incorrectos");
                        }
                    }
                    break;
                case "3":
                    System.out.print("Ingrese el nombre de usuario: ");
                    username = scanner.nextLine();
                    usuario1 = null;
                    for (User user :
                            bank) {
                        if (user.getUsername().equals(username)){
                            usuario1 = user;
                        }
                    }
                    if(usuario1 == null){
                        System.out.println("El usuario no existe.");
                    }else{
                        System.out.println("Ingrese la contraseña");
                        password = scanner.nextLine();
                        if (usuario1.getPassword().equals(password)){
                            System.out.println("Ingrese la cantidad a depositar: ");
                            double cantidad = Double.parseDouble(scanner.nextLine());
                            usuario1.addMoney(cantidad);
                        }else{
                            System.out.println("Datos Incorrectos");
                        }
                    }
                    break;
                case "4":
                    System.out.print("Ingrese el nombre de usuario: ");
                    username = scanner.nextLine();
                    usuario1 = null;
                    usuario2 = null;
                    for (User user :
                            bank) {
                        if (user.getUsername().equals(username)){
                            usuario1 = user;
                        }
                    }
                    if(usuario1 == null){
                        System.out.println("El usuario no existe.");
                    }else{
                        System.out.println("Ingrese la contraseña");
                        password = scanner.nextLine();
                        if (usuario1.getPassword().equals(password)){
                            System.out.println("Ingrese el número de cuenta de destino: ");
                            String numeroCuenta = scanner.nextLine();
                            for (User user :
                                    bank) {
                                if (user.getBankAccount().getAccountNumber().equals(numeroCuenta)){
                                    usuario2 = user;
                                }
                            }
                            if (usuario2 == null){
                                System.out.println("El número de cuenta no es correcto");
                            }else {
                                System.out.println("Ingrese la cantidad a depositar: ");
                                double cantidad = Double.parseDouble(scanner.nextLine());
                                usuario1.transferMoney(usuario2.getBankAccount(), cantidad);
                            }
                        }else{
                            System.out.println("Datos Incorrectos");
                        }
                    }
                    break;
                case "5":
                    exit = true;
            }
        }


    }

    public static void showMenu(String[] menuOptions, String menuTitle){
        System.out.println(" ");
        System.out.println("*** " + menuTitle + " ***");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i+1) + ". " + menuOptions[i]+ ".");
        }
        System.out.println("*** *-*-*-*-* ***");
        System.out.println(" ");
    }

    public static void showElements(Object[] objects ){
        for (int i = 0; i < objects.length; i++) {
            Object obj = objects[i];
            System.out.println((i+1) + ". " + obj.toString());
        }
    }

}