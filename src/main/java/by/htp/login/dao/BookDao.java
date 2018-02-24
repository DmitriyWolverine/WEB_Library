package by.htp.login.dao;

import java.util.List;

import by.htp.login.bean.Book;
import by.htp.login.bean.fields.Author;

public interface BookDao extends BaseDao<Book>{
	List<Book> readAllBooks();
	boolean ifBookExists(Book curBook);
	public void create(String title, Author author, int publishedYear);
	Book readByParams(String title, Author author, int publishedYear);
}
