package by.htp.login.dao.factory;

import static by.htp.login.dao.util.DaoTypesConstants.SQL_DATA_BASE;
import static by.htp.login.dao.util.DaoTypesConstants.XML_DATA_BASE;

import by.htp.login.dao.ReadBooksDao;
import by.htp.login.dao.impl.sql.ReadBooksDaoDataBaseImpl;

public class ReadBooksDaoFactory implements DaoFactory<ReadBooksDao>{
	
	private static final ReadBooksDaoFactory readBookFactory = new ReadBooksDaoFactory();

	public static ReadBooksDaoFactory getInstance() {
		return readBookFactory;
	}
	@Override
	public ReadBooksDao getDataBaseHandler(String parameter) {
		ReadBooksDao readBookDao = null;
		switch(parameter){
			case SQL_DATA_BASE:{
				readBookDao = new ReadBooksDaoDataBaseImpl();
				break;
			}
			case XML_DATA_BASE:{
				break;
			}
			default:{
				throw new IllegalArgumentException();
			}
		}
		return readBookDao;
	}

}
