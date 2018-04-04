package by.htp.login.service;

import java.util.List;

import by.htp.login.bean.Author;
import by.htp.login.bean.Book;

public interface BookService {
	List<Book> getBooksCatalog(); 
	void createBook(Book curBook);
	void updateBook(Book curBook);
	Book updateParametres(int curId, String curTitle, String curAuthorStr, int curYear);
	Book initializeNewBook(String curTitle, int curAuthorId, int curYear);
	void deleteBook(int curId);
	boolean checkIfBookExists(Book book);
	List<Book> getBookByParametres(String curTitle, Author curAuthor, int pubYear);
	Book getBookById(int id);
	List<Book> getChoosenBooks(String title, String aName, String aSurname, int publishedYear);
	void changeStatusBook(int id, boolean status);
	List<Book> getBookByUserId(int userId);
}
