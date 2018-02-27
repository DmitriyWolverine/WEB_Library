package by.htp.login.dao.util;

import by.htp.login.dao.SimpleUserDao;

import by.htp.login.dao.impl.SimpleUserDaoDataBaseImpl;
import static by.htp.login.dao.util.DaoTypesConstants.*;

public class SimpleUserDaoFactoryMethod {
	
	private SimpleUserDaoFactoryMethod() {
		
	}
	
	public static SimpleUserDao getDataBaseHandler(String parameter) {
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
