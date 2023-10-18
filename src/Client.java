public class Client {
    private String username;
    private String password;
    private SavingAccount savingAccount;
    private BankSystem bankSystem;

    public Client(String username, String password, BankSystem bankSystem) {
        this.username = username;
        this.password = password;
        this.bankSystem = bankSystem;
        int accountNumber = bankSystem.generateAccountNumber();
        this.savingAccount = new SavingAccount(accountNumber);
    }

    public void printClientInfo() {
        System.out.println("Username: " + username);
        savingAccount.printAccountInfo();
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public SavingAccount getSavingsAccount() {
        return savingAccount;
    }
}