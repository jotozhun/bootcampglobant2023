import java.util.ArrayList;

public class User {
    private BankAccount savingsAccount;
    private String userName;
    private String password;

    public User(String userName, String password,BankAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
        this.userName = userName;
        this.password = password;
    }

    public void makeWithdraw(double amount){
        double actualBalance = this.getSavingsAccount().getBalance();

        if(amount<=1000) {
            if (actualBalance < amount + 200) {
                System.out.println("You do not have enough money for the taxes:\n" +
                        "Taxes for withdraw have a cost of $200.");
            } else {
                this.savingsAccount.setBalance(actualBalance - 200 - amount);
                System.out.println("Your withdraw was successfully made:\n" +
                        "Your actual balance is: $" + this.savingsAccount.getBalance());
            }
        }
        else
        {
            if (actualBalance < amount + 200+(amount*0.15)) {
                System.out.println("You do not have enough money for the taxes:\n" +
                        "Taxes for more than 1000 withdraws have a cost of "+ 200+(amount*0.15));
            } else {
                this.savingsAccount.setBalance(actualBalance - 200 - amount-(amount*0.15));
                System.out.println("Your withdraw was successfully made:\n" +
                        "Your actual balance is: $" + this.savingsAccount.getBalance());
            }

        }
    }

    public void addMoney(double amount){
        double actualBalance = this.getSavingsAccount().getBalance();
        this.savingsAccount.setBalance(actualBalance+amount);
        System.out.println("Your actual balance is: $"+this.getSavingsAccount().getBalance());
    }

    public void transferMoney(double amount, int numberBankAccount){
        //chequear que haya suficiente dinero para transferir
        //chequear que el numero de cuenta este dentro del banco
        double actualBalance = this.getSavingsAccount().getBalance();
        ArrayList<User> usuarios = Bank.getUsuarios();

        if(amount > actualBalance+100)
            System.out.println("You do not have enough money");
        else
        {
            for(User usuarioIterar : usuarios)
            {
                int numberBank = usuarioIterar.getSavingsAccount().getNumber();
                if(numberBank == numberBankAccount)
                {
                    usuarioIterar.addMoney(amount);
                    this.savingsAccount.setBalance(actualBalance-amount-100);
                    System.out.println("Your transfer was made successfully");
                    System.out.println("Your actual balance is: $"+this.savingsAccount.getBalance());
                }
            }
        }



    }


    public BankAccount getSavingsAccount() {
        return savingsAccount;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setSavingsAccount(BankAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
