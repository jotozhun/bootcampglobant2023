
public class BankClient {
    private User user;
    private BankAccount account;

    public BankClient(User user, BankAccount account) {
        this.user = user;
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public BankAccount getAccount() {
        return account;
    }
}
