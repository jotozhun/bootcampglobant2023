public class SavingAccount {
        private int accountNumber;
        private String openingDate;
        private double balance;


        public SavingAccount( int accountNumber) {
            this.accountNumber = accountNumber;
            this.openingDate = "10/18/2023";
            this.balance = 0.0;
        }

        public void printAccountInfo() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Opening Date: " + openingDate);
            System.out.println("Balance: $" + balance+"\n");
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (amount < 1000) {
                if (balance >= amount + 200) {
                    balance -= amount + 200;
                    return true;
                } else {
                    System.out.println("Insufficient funds.");
                    return false;
                }
            } else {
                if (balance >= amount + 200 + (0.15 * amount)) {
                    balance -= amount + 200 + (0.15 * amount);
                    return true;
                } else {
                    System.out.println("Insufficient funds.");
                    return false;
                }
            }
        }

        public boolean transfer(double amount, SavingAccount recipientAccount) {
            if (balance >= amount + 100) {
                balance -= amount + 100;
                recipientAccount.deposit(amount);
                return true;
            } else {
                System.out.println("Insufficient funds.");
                return false;
            }
        }
}
