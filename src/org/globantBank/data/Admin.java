package org.globantBank.data;

public class Admin {
    private String username;
    private String password;

    public Admin(){}

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean auth(String username, String password){
        boolean isAuthenticated = false;
        if (this.username.equals(username) && this.password.equals(password)){
            isAuthenticated = true;
        }
        return isAuthenticated;
    }
}
