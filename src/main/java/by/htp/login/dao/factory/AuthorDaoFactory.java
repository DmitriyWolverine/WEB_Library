package by.htp.login.dao.factory;


import static by.htp.login.dao.util.DaoTypesConstants.*;

import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.impl.sql.AuthorDaoDataBaseImpl;

public class AuthorDaoFactory implements DaoFactory<AuthorDao>{
		private static final AuthorDaoFactory authorFactory = new AuthorDaoFactory();
		
		public static AuthorDaoFactory getInstance() {
			return authorFactory;
		}
		
		@Override
		public AuthorDao getDataBaseHandler(String parameter) {
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


