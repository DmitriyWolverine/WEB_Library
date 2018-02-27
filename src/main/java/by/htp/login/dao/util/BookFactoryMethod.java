package by.htp.login.dao.util;

import static by.htp.login.dao.util.DaoTypesConstants.*;


import by.htp.login.dao.BookDao;
import by.htp.login.dao.impl.BookDaoDataBaseImpl;

public class BookFactoryMethod {
	private BookFactoryMethod() {
		
	}
	
	public static BookDao getDataBaseHandler(String parameter) {
		BookDao bookrDao = null;
		switch(parameter){
			case SQL_DATA_BASE:{
				bookrDao = new BookDaoDataBaseImpl();
				break;
			}
			case XML_DATA_BASE:{
				break;
			}
			default:{
				throw new IllegalArgumentException();
			}
		}
		return bookrDao;
	}
}
