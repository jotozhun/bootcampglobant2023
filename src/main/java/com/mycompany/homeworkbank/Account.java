/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.homeworkbank;

import java.util.Date;
import com.mycompany.homeworkbank.Tax;
import com.mycompany.homeworkbank.Client;

/**
 *
 * @author jorozco
 */
public class Account {

    private String nombre;
    private String user;
    private String password;
    private int numberAccount;
    private double money;
    private Date fecha;

    public Account() {
    }

    public Account(String nombre, String user, String password, int numberAccount, double money, Date fecha) {
        this.nombre = nombre;
        this.user = user;
        this.password = password;
        this.numberAccount = numberAccount;
        this.money = money;
        this.fecha = fecha;
    }

    public void retirarDinero(double money) {
        double tax = Tax.calularTax("R", money);
        if (money < 0) {
            System.out.println("Ingresar  numero mayores a 0");
        }
        if (money > this.money) {
            System.out.println("Saldo Insuficiente");
        } else {
            setMoney(this.money - money - tax);
            System.out.println("Retiro exitoso");
        }
    }

    public void depositarDinero(double money) {
        if (money < 0) {
            System.out.println("Ingresar numero mayores a 0");
        } else {
            setMoney(this.money + money);
            System.out.println("Deposito exitoso de : " + money);
        }
    }

    public void transferirDinero(int numberAccount, double money) {
        if (money < 0) {
            System.out.println("Ingresar numeros mayores a 0");
        } else {

            setMoney(this.money - money - 100);
            System.out.println("Su saldo actual es: " + this.money);
            Account transfer = Client.accountTransfer(numberAccount);
            transfer.depositarDinero(money);
            System.out.println("Transferencia completada");

        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(int numberAccount) {
        this.numberAccount = numberAccount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
