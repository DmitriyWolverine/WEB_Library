package by.htp.login.bean.fields;

import java.util.ArrayList;
import java.util.List;

import by.htp.login.bean.users.SimpleUser;

public class LogBook {
	private List<SimpleUser> users;
	
	public LogBook() {
		super();
		initUsersFromDataBase();
	}

	public LogBook(List<SimpleUser> users) {
		super();
		this.users = users;
	}

	public List<SimpleUser> getUsers() {
		return users;
	}
	
	public void setUsers(List<SimpleUser> users) {
		this.users = users;
	}
	
	private void initUsersFromDataBase() {
		users = new ArrayList<>();
		
	}
	
	public int getLength() {
		return users.size();
	}
	
	public void addUser(SimpleUser user) {
		if(user!= null)
			users.add(user);
	}
	
	public void removeUser(SimpleUser user) {
		if(user == null)
		{
			return ;
		}
		for( int i = 0 ; i < users.size(); ++i) {
			if(user.getId() == users.get(i).getId()) {
				users.remove(i);
				break;
			}
		}
	}
	
	public void removeUser(int id ) {
		if(id <= 0)
		{
			throw  new IllegalArgumentException();
		}
		for( int i = 0 ; i < users.size(); ++i) {
			if(id == users.get(i).getId() ) {
				users.remove(i);
				break;
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogBook other = (LogBook) obj;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LogBook users are: " + users;
	}
	
	
}
