package by.htp.login.service.impl;

import by.htp.login.bean.users.User;
import by.htp.login.dao.SimpleUserDao;
import by.htp.login.dao.impl.SimpleUserDaoDataBaseImpl;
import by.htp.login.service.UserService;

public class UserServiceImpl implements UserService{
	
	//service - промежуточное звено между DAO и controller
	//здесь должен быть запрос в базу данных и возвращение некоторой сущности : User, List<Book>
	
	//TODO Factory method
	private SimpleUserDao userDao = new SimpleUserDaoDataBaseImpl();

	@Override
	public boolean checkIfUserRegistrated(String login, String password) {
		return userDao.ifUserExists(login, password);
	}

	@Override
	public void createUser(String login, String password) {
		userDao.create(login, password);
	}

	@Override
	public User readUser(String login, String pass) {
		return userDao.readUser(login, pass);
	}
	
	
}
