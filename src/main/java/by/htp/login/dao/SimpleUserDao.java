package by.htp.login.dao;

import java.util.List;

import by.htp.login.bean.users.SimpleUser;

public interface SimpleUserDao extends BaseDao<SimpleUser>{
	
	List<SimpleUser> getRegistratedUsers();
	SimpleUser readUser(String login, String password);
	boolean ifUserExists(String login, String password);
	void create(String login, String password);
	
}
