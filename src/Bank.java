import java.util.ArrayList;

public class Bank {
	private String name;
	private ArrayList <User> lst_users;
	
	public Bank(){
		this.lst_users = new ArrayList<User>();
	}
	
	public void addUser(User client) {
		lst_users.add(client);
	}
	
	public void showUsersInformation() {
		for(int i = 0; i < lst_users.size(); i++) {
			lst_users.get(i).showUserInformation();
		}
	}
}
