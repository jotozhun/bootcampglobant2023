
package org.globant.bank.bootcampglobant2023.AppGlobantBank;

import java.util.ArrayList;

/**
 * Bank
 */
public class Bank {
    private ArrayList<User> users;

    public Bank(ArrayList<User> users) {
        this.users = users;
    }

    public void informationUser() {
        for (User user : users) {
            System.out.println(user.toString());
        }

    }

    public void withDraw(double mount, String client) {
        final int tax = 200;
        final int plus = 15;
        for (User user : users) {
            if (mount <= user.getBankAccount().getBalance() && client.equals(user.getUser())) {
                if (mount > 1000) {
                    user.getBankAccount()
                            .setBalance(user.getBankAccount().getBalance() - ((mount * plus / 100) + (mount - tax)));
                }
                user.getBankAccount()
                        .setBalance(user.getBankAccount().getBalance() - (mount - tax));
            }

        }

    }

    public void add(double mount, String client) {
        for (User user : users) {
            if (user.getUser().equals(client)) {
                user.getBankAccount().setBalance(mount);
            }

        }
    }

    public void transfering(double mount, String client, int account) {
        final int tax = 100;
        for (User user : users) {
            if (user.getUser().equals(client)) {
                user.getBankAccount().setBalance(user.getBankAccount().getBalance() - (mount + tax));
            }
            if (user.getBankAccount().getAccountNumber() == account) {
                user.getBankAccount().setBalance(user.getBankAccount().getBalance() + mount);
            }
        }
    }

    public boolean login(String user, String password) {
        boolean login = false;
        for (User user1 : users) {
            if (user1.getUser().equals(user) && user1.getPassword().equals(password)) {
                login = true;
            }

        }
        return login;
    }

    public double balanceToUser(String user) {
        double balance = 0;
        for (User user1 : users) {
            if (user1.getUser().equals(user)) {
                balance = user1.getBankAccount().getBalance();
            }

        }
        return balance;
    }

}