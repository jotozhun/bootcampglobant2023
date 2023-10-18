/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.homeworkbank;

import java.util.Scanner;
import com.mycompany.homeworkbank.Client;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

/**
 *
 * @author jorozco
 */
public class HomeworkBank {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Client client = new Client();
        client.loadClient();
        System.out.println("Bienvenido a G-Bank");
        System.out.println("Usuario: ");
        System.out.println("Contraseña: ");
        Scanner user = new Scanner(System.in);
        String username = user.nextLine();
        Scanner pass = new Scanner(System.in);
        String password = pass.nextLine();

        if (username.equals("admin") && password.equals("123abc")) {
            boolean adminSession = true;
            while (adminSession) {

                System.out.println("Seleccione una opcion: ");
                System.out.println("1. Ver lista cliente ");
                System.out.println("2. Salir");
                Scanner op = new Scanner(System.in);
                int opcion = op.nextInt();

                switch (opcion) {
                    case 1:
                        client.getListClient();
                        break;
                    case 2:
                        System.out.println("Regresa pronto...");
                        adminSession = false;
                        break;
                    default:
                        System.out.println("Seleccione un apcion valida");
                }
            }
        } else {

            if (client.clientVerify(username, password) == true) {
                boolean clientSession = true;
                Account session = client.clientSession(username, password);
                while (clientSession) {

                    System.out.println("Seleccione una opcion: ");
                    System.out.println("1. Retirar ");
                    System.out.println("2. Depositar");
                    System.out.println("3. Transferir");
                    System.out.println("4. Salir");
                    Scanner opc = new Scanner(System.in);
                    int opcionc = opc.nextInt();
                    switch (opcionc) {
                        case 1:
                            System.out.println("Ingrese el monto de retiro: ");
                            Scanner moneyRe = new Scanner(System.in);
                            session.retirarDinero(moneyRe.nextDouble());
                            break;
                        case 2:
                            System.out.println("Ingrese el monto de deposito: ");
                            Scanner moneyDe = new Scanner(System.in);
                            session.depositarDinero(moneyDe.nextDouble());
                            break;
                        case 3:
                            System.out.println("Ingrese el numero de cuenta: ");
                            Scanner number = new Scanner(System.in);
                            int numberAccount = number.nextInt();
                            if (client.accountVerify(numberAccount) == true) {
                                System.out.println("Ingrese el monto de deposito: ");
                                Scanner moneyT = new Scanner(System.in);

                                session.transferirDinero(numberAccount, moneyT.nextDouble());
                            } else {
                                System.out.println("Numero de cuenta invalido");
                            }
                            break;
                        case 4:
                            System.out.println("Regresa pronto...");
                            clientSession = false;
                            break;

                        default:
                            System.out.println("Seleccione un apcion valida");
                    }
                }
            } else {
                System.out.println("Credenciales Incorrectas");
            }
        }

    }
}
