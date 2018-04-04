package by.htp.login.service.impl;

import java.util.List;

import by.htp.login.bean.Author;
import by.htp.login.bean.Book;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.factory.BookDaoFactory;
import by.htp.login.service.AuthorService;
import by.htp.login.service.BookService;

import static by.htp.login.dao.util.DaoTypesConstants.*;
import static by.htp.login.service.util.ExceptionHandler.*;

public class BookServiceImpl implements BookService{
	
	private BookDao bookDao = BookDaoFactory.getInstance().getDataBaseHandler(SQL_DATA_BASE);

	@Override
	public List<Book> getBooksCatalog() {
		return bookDao.readAllBooks();
	}

	@Override
	public void updateBook(Book curBook) {
		if(curBook == null) {
			showEntityIsNotInitializedMessage();
		}
		bookDao.update(curBook);
	}

	@Override
	public Book updateParametres(int curId, String curTitle, String curAuthorStr, int curYear) {
		if(curId<=0 ||  curTitle.isEmpty() || curAuthorStr.isEmpty() ) {
			showParametresAreNotInitializedMessage();
		}
		AuthorService authorService = new AuthorServiceImpl();
		int authID = Integer.parseInt(curAuthorStr.trim());
		return new Book(curId,curTitle,authorService.getAuthor(authID),curYear);
	}

	@Override
	public void deleteBook(int curId) {
		if( curId<=0) {
			showParametresAreNotInitializedMessage();
		}
		bookDao.delete(curId);
	}

	@Override
	public void createBook(Book curBook) {
		if(curBook == null) {
			showEntityIsNotInitializedMessage();
		}
		bookDao.create(curBook);
	}

	@Override
	public Book initializeNewBook(String curTitle, int curAuthorID, int curYear) {
		if(curAuthorID<=0 ||  curTitle.isEmpty() ) {
			showParametresAreNotInitializedMessage();
		}
		AuthorService authorService = new AuthorServiceImpl();
		return new Book(curTitle,authorService.getAuthor(curAuthorID),curYear);
	}

	@Override
	public boolean checkIfBookExists(Book book) {
		if(book == null) {
			showEntityIsNotInitializedMessage();
		}
		return bookDao.ifBookExists(book);
	}

	@Override
	public List<Book> getBookByParametres(String curTitle, Author curAuthor, int pubYear) {
		if(curAuthor==null ||  curTitle.isEmpty() ) {
			showParametresAreNotInitializedMessage();
		}
		return bookDao.readByParams(curTitle, curAuthor, pubYear);
	}

	@Override
	public Book getBookById(int id) {
		if( id<=0  ) {
			showParametresAreNotInitializedMessage();
		}
		return bookDao.read(id);
	}

	@Override
	public List<Book> getChoosenBooks(String title, String aName, String aSurname, int publishedYear) {
		return bookDao.findChoosenBooks( title,  aName,  aSurname,  publishedYear);
	}

	@Override
	public void changeStatusBook(int id, boolean status) {
		if(id <=0) {
			showParametresAreNotInitializedMessage();
		}
		bookDao.changeStatus(id, status);
	}

	@Override
	public List<Book> getBookByUserId(int userId) {
		return bookDao.readByUser(userId);
	}
	
	
	
}
