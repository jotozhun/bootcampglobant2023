package org.globantBank.data;

public class Client {

    private String name;
    private String username;
    private String password;
    private Account account;

    public Client (){}

    public Client(String name, String user, String password) {
        this.name = name;
        this.username = user;
        this.password = password;
        this.account = new Account();
    }

    public String getName() {
        return name;
    }

    public boolean auth(String username, String password){
        boolean isAuthenticated = false;
        if (this.username.equals(username) && this.password.equals(password)){
            isAuthenticated = true;
        }
        return isAuthenticated;
    }

    @Override
    public String toString() {
        return "Cliente " + this.name + " Nombre de usuario : " + this.username + " " + this.account;
    }
}
