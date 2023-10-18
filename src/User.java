
public class User {
	private String name;
	private String username;
	private String password;
	private SavingAccount personalAccount;
	
	public void receiveMoney(double money) {
		this.personalAccount.addMoney(money);
		
	}
}
