package by.htp.login.service.impl;

import by.htp.login.bean.users.User;

import by.htp.login.dao.SimpleUserDao;
import by.htp.login.dao.util.SimpleUserDaoFactoryMethod;
import by.htp.login.service.UserService;

import static by.htp.login.dao.util.DaoTypesConstants.*;

public class UserServiceImpl implements UserService{
	
	private SimpleUserDao userDao = SimpleUserDaoFactoryMethod.getDataBaseHandler(SQL_DATA_BASE);

	@Override
	public boolean checkIfUserRegistrated(String login, String password) {
		return userDao.ifUserExists(login, password);
	}

	@Override
	public User createUser(String login, String password) {
		if( validateInputData(login,password) ) {
			userDao.create(login, password);
			return userDao.readUser(login, password);
		}
		else {
			return null;
		}
	}

	@Override
	public User readUser(String login, String pass) {
		return userDao.readUser(login, pass);
	}
	
	private boolean validateInputData(String login, String password) {
		if(login == null) {
			return false;
		}
		if(login.length()==0) {
			return false;
		}
		if(password == null) {
			return false;
		}
		return (password.length()>=6);
	}
	
	
}
