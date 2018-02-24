package by.htp.login.bean.users;

import by.htp.login.bean.Entity;

public abstract class User extends Entity{
	private String login;
	private String password;
	private boolean isAdmin = false;
	
	public User() {
		super();
	}
	public User(int id) {
		super(id);
	}
	public User(String login, String pass) {
		super();
		this.login = login;
		this.password = pass;
	}
	public User(int id, String login, String pass) {
		super(id);
		this.login = login;
		this.password = pass;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isAdmin ? 1231 : 1237);
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
		if (isAdmin != other.isAdmin)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User ID = "+  getId()+" Login=" + getLogin() + ", Pass=" + getPassword();
	}
}
