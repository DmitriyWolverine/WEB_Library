package by.htp.login.bean;

public class Admin extends SimpleUser{
	private LogBook users;
	
	public Admin(int id) {
		super(id);
		users = new LogBook();
		setAdmin(true);
	}

	public Admin(String login, String password) {
		super(login, password);
		users = new LogBook();
		setAdmin(true);
	}
	
	public Admin(int id, String login, String password) {
		super(id, login, password);
		users = new LogBook();
		setAdmin(true);
	}

	public LogBook getUsers() {
		return users;
	}

	public void setUsers(LogBook users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin ID = "+getId()+" Login=" + getLogin() + ", Password=" + getPassword() +" Users=" + users.getUsers();
	}
	
}
