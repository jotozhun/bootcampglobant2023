package org.globantBank.data;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<Client> clientList;
    private List<Admin> adminList;

    public Bank(String name) {
        this.name = name;
        this.clientList = new ArrayList<>();
        this.adminList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public Client getClientByIndex(int index) {
        return clientList.get(index);
    }

    public int getClientsAmount(){
        return clientList.size();
    }

    public void registerClient(Client client){
            this.clientList.add(client);
    }

    public void registerAdmin(Admin admin){
        this.adminList.add(admin);
    }

    public Client authenticateClient(String username, String password){
        Client authClient = new Client();
        for (Client tryClient : this.clientList) {
            if(tryClient.auth(username, password)){
                authClient = tryClient;
            }
        }
        return authClient;
    }

    public Admin authenticateAdmin(String username, String password){
        Admin authAdmin = new Admin();
        for (Admin tryAdmin : this.adminList) {
            if(tryAdmin.auth(username, password)){
                authAdmin = tryAdmin;
            }
        }
        return authAdmin;
    }

}
