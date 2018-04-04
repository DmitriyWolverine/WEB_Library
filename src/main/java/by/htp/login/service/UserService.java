package by.htp.login.service;


import by.htp.login.bean.Book;
import by.htp.login.bean.User;

public interface UserService {
	
	boolean checkIfUserRegistrated(String login, String password);
	User createUser(String login, String password);
	User readUser(String login, String pass);
	void addBookToList(User user, Book book);
	
	void initCurrentBook(User user, Book book);
	boolean hasAnyTakenBooks(User user);
	
	int getReadingBookId(User user);
	
}
