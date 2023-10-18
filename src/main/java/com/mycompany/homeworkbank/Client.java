/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homeworkbank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jorozco
 */
public class Client {

    private static List<Account> listClient = new ArrayList<>();

    private Date fecha = new Date(2023, 10, 17);

    private Account client1 = new Account("Juan Perez", "jperez", "123", 223456,
            250.00, fecha);
    private Account client2 = new Account("Pedro Ortiz", "portiz", "456", 223356,
            250.00, fecha);
    private Account client3 = new Account("Sebastian Cevallos", "scevallos", "222", 223888,
            250.00, fecha);
    private Account client4 = new Account("Juana Alvarado", "jalavarado", "333", 224455,
            250.00, fecha);
    private Account client5 = new Account("Andres Casa", "acasa", "789", 213466,
            250.00, fecha);

    public void getListClient() {
        for (Account account : listClient) {
            System.out.println("Nombre: " + account.getNombre());
            System.out.println("Usuario: " + account.getUser());
            System.out.println("Numero Cuenta: " + account.getNumberAccount() + "\n");
        }
    }

    public void loadClient() {
        listClient.add(client1);
        listClient.add(client2);
        listClient.add(client3);
        listClient.add(client4);
        listClient.add(client5);
    }

    public boolean clientVerify(String user, String pass) {
        boolean verify = false;
        for (Account account : listClient) {
            if (account.getUser().equals(user) && account.getPassword().equals(pass)) {
                verify = true;
                break;
            }
        }
        return verify;
    }

    public Account clientSession(String user, String pass) {
        Account userClient = new Account();
        for (Account account : listClient) {
            if (account.getUser().equals(user) && account.getPassword().equals(pass)) {
                userClient = account;
                break;
            }
        }
        return userClient;
    }

    public boolean accountVerify(int numberAccount) {
        boolean verify = false;
        for (Account account1 : listClient) {
            if (account1.getNumberAccount() == numberAccount) {
                verify = true;
                break;
            }
        }
        return verify;
    }
    
     public static Account accountTransfer(int numberAccount) {
        Account acccountTransfer = new Account();
        for (Account account : listClient) {
            if (account.getNumberAccount() == numberAccount) {
                acccountTransfer = account;
                break;
            }
        }
        return acccountTransfer;
    }
    

}
