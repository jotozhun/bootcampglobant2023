import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BankSystem {
    private List<Client> clients;
    private int nextAccountNumber = 1;
    private Set<Integer> usedAccountNumbers;

    public BankSystem() {
        clients = new ArrayList<>();
        usedAccountNumbers = new HashSet<>();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void printAllClients() {
        for (Client client : clients) {
            client.printClientInfo();
        }
    }

    public int generateAccountNumber() {
        int accountNumber = nextAccountNumber;
        while (usedAccountNumbers.contains(accountNumber)) {
            accountNumber++;
        }
        nextAccountNumber = accountNumber + 1;
        usedAccountNumbers.add(accountNumber);
        return 123 + accountNumber;
    }
}
