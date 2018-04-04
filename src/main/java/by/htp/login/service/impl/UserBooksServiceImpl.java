package by.htp.login.service.impl;

import java.util.List;

import by.htp.login.bean.PairUserBook;
import by.htp.login.dao.ReadBooksDao;
import by.htp.login.dao.factory.ReadBooksDaoFactory;
import by.htp.login.service.UserBooksService;

import static by.htp.login.dao.util.DaoTypesConstants.*;
import static by.htp.login.service.util.ExceptionHandler.*;

public class UserBooksServiceImpl implements UserBooksService{
	private ReadBooksDao readBooksDao;
			
	public UserBooksServiceImpl() {
		readBooksDao = ReadBooksDaoFactory.getInstance().getDataBaseHandler(SQL_DATA_BASE);
	}
	
	@Override
	public void addNewBook(PairUserBook pair) {
		if(pair == null) {
			showEntityIsNotInitializedMessage();
		}
		readBooksDao.create(pair);
	}

	@Override
	public List<Integer> booksReadList(int userId) {
		return readBooksDao.readAllReadBooksIdByUser(userId);
	}

}
