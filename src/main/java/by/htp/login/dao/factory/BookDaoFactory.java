package by.htp.login.dao.factory;

import static by.htp.login.dao.util.DaoTypesConstants.*;


import by.htp.login.dao.BookDao;
import by.htp.login.dao.impl.sql.BookDaoDataBaseImpl;

public class BookDaoFactory implements DaoFactory<BookDao>{
	
	private static final BookDaoFactory bookFactory = new BookDaoFactory();
	
	public static BookDaoFactory getInstance() {
		return bookFactory;
	}
	
	@Override
	public BookDao getDataBaseHandler(String parameter) {
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
