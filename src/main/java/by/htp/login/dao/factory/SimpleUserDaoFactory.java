package by.htp.login.dao.factory;

import by.htp.login.dao.SimpleUserDao;
import by.htp.login.dao.impl.sql.SimpleUserDaoDataBaseImpl;

import static by.htp.login.dao.util.DaoTypesConstants.*;


public class SimpleUserDaoFactory implements DaoFactory<SimpleUserDao>{
	private static final SimpleUserDaoFactory userFactory = new SimpleUserDaoFactory();
	
	public static SimpleUserDaoFactory getInstance() {
		return userFactory;
	}
	
	@Override
	public SimpleUserDao getDataBaseHandler(String parameter) {
		SimpleUserDao simpleUserDao = null;
		switch(parameter){
			case SQL_DATA_BASE:{
				simpleUserDao = new SimpleUserDaoDataBaseImpl();
				break;
			}
			case XML_DATA_BASE:{
				break;
			}
			default:{
				throw new IllegalArgumentException();
			}
		}
		return simpleUserDao;
	}

}
