package by.htp.login.bean.users;

public class SimpleUser extends User{

	public SimpleUser(String login, String password) {
		super(login,password);
	}
	public SimpleUser(int i, String login, String password) {
		super(i, login,password);
	}
	
	@Override
	public String toString() {
		return "User ID = "+  getId()+" Login=" + getLogin() + ", Pass=" + getPassword();
	}
	
}
