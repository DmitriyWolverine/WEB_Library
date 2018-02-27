package by.htp.login.service;


import by.htp.login.bean.users.User;

public interface UserService {
	
	boolean checkIfUserRegistrated(String login, String password);
	User createUser(String login, String password);
	User readUser(String login, String pass);
	
}
