package by.htp.login.dao;

import java.util.List;

import by.htp.login.bean.Book;
import by.htp.login.bean.SimpleUser;
import by.htp.login.bean.User;

public interface SimpleUserDao extends BaseDao<SimpleUser>{
	
	List<SimpleUser> getRegistratedUsers();
	SimpleUser readUser(String login, String password);
	boolean ifUserExists(String login, String password);
	void create(String login, String password);
	void updateReadBooks(User user, Book book);
	
	void setCurrentBook(User user, Book book);
	
	int getCurrentReadingBookId(User user);
	
}
