
public class User {
	private String name;
	private String username;
	private String password;
	private SavingAccount personalAccount;
	
	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
		personalAccount = new SavingAccount();
	}
	
	public void receiveMoney(double money) {
		this.personalAccount.addMoney(money);
	}
	
	public void widthdrawMoney(double money) {
		personalAccount.withdraw(money);
	}
	
	public void addMoney(double money)
	{
		personalAccount.addMoney(money);
	}
	
	public void transferMoney(double money, User user)
	{
		personalAccount.transferMoney(money, user);
	}
	
	public void showUserInformation()
	{
		System.out.println("Name: " + this.name + " Username: " + this.username);
		personalAccount.showSavingsAccount();
	}
}
