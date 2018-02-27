package by.htp.login.service;

import java.util.List;

import by.htp.login.bean.Book;
import by.htp.login.bean.fields.Author;

public interface BookService {
	List<Book> getBooksCatalog(); 
	void createBook(Book curBook);
	void updateBook(Book curBook);
	Book updateParametres(int curId, String curTitle, String curAuthorStr, int curYear);
	Book initializeNewBook(String curTitle, int curAuthorId, int curYear);
	void deleteBook(int curId);
	boolean checkIfBookExists(Book book);
	Book getBookByParametres(String curTitle, Author curAuthor, int pubYear);
	Book getBookById(int id);
}
