package by.htp.login.service.impl;

import java.util.List;

import by.htp.login.bean.Book;
import by.htp.login.bean.fields.Author;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.util.BookFactoryMethod;
import by.htp.login.service.AuthorService;
import by.htp.login.service.BookService;
import static by.htp.login.dao.util.DaoTypesConstants.*;

public class BookServiceImpl implements BookService{
	
	private BookDao bookDao = BookFactoryMethod.getDataBaseHandler(SQL_DATA_BASE);

	@Override
	public List<Book> getBooksCatalog() {
		return bookDao.readAllBooks();
	}

	@Override
	public void updateBook(Book curBook) {
		bookDao.update(curBook);
	}

	@Override
	public Book updateParametres(int curId, String curTitle, String curAuthorStr, int curYear) {
		AuthorService authorService = new AuthorServiceImpl();
		int authID = Integer.parseInt(curAuthorStr.trim());
		return new Book(curId,curTitle,authorService.getAuthor(authID),curYear);
	}

	@Override
	public void deleteBook(int curId) {
		bookDao.delete(curId);
	}

	@Override
	public void createBook(Book curBook) {
		bookDao.create(curBook);
	}

	@Override
	public Book initializeNewBook(String curTitle, int curAuthorID, int curYear) {
		AuthorService authorService = new AuthorServiceImpl();
		return new Book(curTitle,authorService.getAuthor(curAuthorID),curYear);
	}

	@Override
	public boolean checkIfBookExists(Book book) {
		return bookDao.ifBookExists(book);
	}

	@Override
	public Book getBookByParametres(String curTitle, Author curAuthor, int pubYear) {
		return bookDao.readByParams(curTitle, curAuthor, pubYear);
	}

	@Override
	public Book getBookById(int id) {
		return bookDao.read(id);
	}
	
	
}
