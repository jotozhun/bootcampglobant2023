import java.util.Date;

public class SavingAccount {
	private int accountNumber;
	private Date openingDate;
	private double balance;
	
	public SavingAccount()
	{
		this.accountNumber = (int)(100000 * Math.random());
		this.openingDate = new Date();
		this.balance = 0;
	}

	public void withdraw(double money) {
		if (money > 0 && money + 200 <= this.balance && money < 1000) {
			this.balance = this.balance - money - 200;
			System.out.println("Now you have " + this.balance + " dollars in your account");
		} else if (money > 0 && money * 1.15 + 200 <= this.balance && money >= 1000) {
			money += money * 0.15;
			this.balance = this.balance - money - 200;
			System.out.println("Now you have " + this.balance + " dollars in your account");			
		} else {
			System.out.println("You don't have enough money");
		}

	}

	public void addMoney(double money) {
		this.balance += money;
		System.out.println("Sucessfull at adding money. Now you have " + this.balance + " dollars in your account");
	}
	
	public void transferMoney(double money, User user) {
		if(money > 0 && this.balance >= money + 100) {
			this.balance = this.balance - money - 100;
			System.out.println("Sucessfull transfer. Now you have " + this.balance + " dollars in your account");
			user.receiveMoney(money);
		} else {
			System.out.println("You don't have enough money");
			
		}
		
	}
	
	public void showSavingsAccount()
	{
		System.out.println("ID: " + this.accountNumber + " Balance: " + this.balance + " Opened: " + this.openingDate);
	}

}
