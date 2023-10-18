
public class Main {
	public static void main(String[] args) {
		Bank globantBank = new Bank();
		
		User testUser1 = new User("camily", "testuser", "testpass");
		User testUser2 = new User("Nina", "michi", "michipass");
		globantBank.addUser(testUser1);
		globantBank.addUser(testUser2);
		
		testUser1.addMoney(900);
		testUser1.transferMoney(200, testUser2);
		globantBank.showUsersInformation();
	}
}
