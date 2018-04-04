package by.htp.login.dao;

import java.util.List;

import by.htp.login.bean.Author;
import by.htp.login.bean.Book;

public interface BookDao extends BaseDao<Book>{
	List<Book> readAllBooks();
	boolean ifBookExists(Book curBook);
	public void create(String title, Author author, int publishedYear);
	List<Book> readByParams(String title, Author author, int publishedYear);
	List<Book> findChoosenBooks(String title, String aName, String aSurname, int publishedYear);
	public void changeStatus(int id, boolean status);
	List<Book> readByUser(int userId);
	
}
