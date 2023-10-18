
public class GlobantBank {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();
        System.out.println("Se crean los usuarios:");
        Client client1 = new Client("mntoala", "password1", bank);
        Client client2 = new Client("cltoplo", "password2", bank);
        bank.addClient(client1);
        bank.addClient(client2);

        client1.printClientInfo();
        client2.printClientInfo();

        System.out.println("\nDeposito c1 1000");
        client1.getSavingsAccount().deposit(1000);
        client1.printClientInfo();
        client2.printClientInfo();

        System.out.println("\nRetiro c1 500");
        client1.getSavingsAccount().withdraw(500);
        client1.printClientInfo();
        client2.printClientInfo();

        System.out.println("\nDeposito c2 1500");
        client2.getSavingsAccount().deposit(1500);
        client1.printClientInfo();
        client2.printClientInfo();

        System.out.println("\nTransferir a C2 300");
        client1.getSavingsAccount().transfer(300, client2.getSavingsAccount());
        client1.printClientInfo();
        client2.printClientInfo();

        System.out.println("Listado Clientes");
        bank.printAllClients();
    }
}