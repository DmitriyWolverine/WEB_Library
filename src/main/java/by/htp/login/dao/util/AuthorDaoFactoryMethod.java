package by.htp.login.dao.util;


import static by.htp.login.dao.util.DaoTypesConstants.*;

import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.impl.AuthorDaoDataBaseImpl;

public class AuthorDaoFactoryMethod {
		
		private AuthorDaoFactoryMethod() {
			
		}
		
		public static AuthorDao getDataBaseHandler(String parameter) {
			AuthorDao authorDao = null;
			switch(parameter){
				case SQL_DATA_BASE:{
					authorDao = new AuthorDaoDataBaseImpl();
					break;
				}
				case XML_DATA_BASE:{
					break;
				}
				default:{
					throw new IllegalArgumentException();
				}
			}
			return authorDao;
		}

}


