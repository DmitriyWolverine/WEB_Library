package by.htp.login.service.impl;

import by.htp.login.bean.Book;
import by.htp.login.bean.User;
import by.htp.login.dao.SimpleUserDao;
import by.htp.login.dao.factory.SimpleUserDaoFactory;
import by.htp.login.service.UserService;
import by.htp.login.service.util.ShowMessage;

import static by.htp.login.dao.util.DaoTypesConstants.*;
import static by.htp.login.service.util.ExceptionHandler.*;

import java.util.List;

public class UserServiceImpl implements UserService{
	
	private SimpleUserDao userDao = SimpleUserDaoFactory.getInstance().getDataBaseHandler(SQL_DATA_BASE);

	@Override
	public boolean checkIfUserRegistrated(String login, String password) {
		if(login.isEmpty() || password.isEmpty()) {
			showParametresAreNotInitializedMessage();
		}
		return userDao.ifUserExists(login, password);
	}

	@Override
	public User createUser(String login, String password) {
		if( validateInputData(login,password) ) {
			userDao.create(login, password);
			return userDao.readUser(login, password);
		}
		else {
			showParametresAreNotInitializedMessage();
		}
		return null;
	}

	@Override
	public User readUser(String login, String pass) {
		if(!checkIfUserRegistrated(login,pass)) {
			showParametresAreNotInitializedMessage();
		}
		return userDao.readUser(login, pass);
	}

	@Override
	public void addBookToList(User user, Book book) {
		if(user==null ||  book == null) {
			showParametresAreNotInitializedMessage();
		}
		else {
			if( book.isAvailable()  ) {
				if(!checkIfBookWasAddedBefore(user, book) ) {
					userDao.updateReadBooks(user, book);
				}
			}
			else {
				ShowMessage.showBookIsTakenMessage(book.getTitle() );
			}
		}
	}
	
	private boolean checkIfBookWasAddedBefore(User user, Book book) {
		List<Book> usersBook = (new BookServiceImpl()).getBookByUserId(user.getId());
		for(int i = 0 ; i < usersBook.size(); ++i) {
			if(usersBook.get(i).equals(book)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasAnyTakenBooks(User user) {
		return userDao.read(user.getId()).getCurrentBook()!=null;
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
	
	@Override
	public void initCurrentBook(User user, Book book) {
		if(user==null ||  book == null) {
			if(book == null) {
				userDao.setCurrentBook(user, book);
			}
			else {
			showParametresAreNotInitializedMessage();
			}
		}
		else {
			if(book.isAvailable()  ) {
				userDao.setCurrentBook(user, book);
				user.setCurrentBook(book);
			}
			else {
				ShowMessage.showBookIsTakenMessage(book.getTitle() );
			}
		}
		
	}

	@Override
	public int getReadingBookId(User user) {
		if(user != null)
			return userDao.getCurrentReadingBookId(user);
		return 0;
	}

}
