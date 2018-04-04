package by.htp.login.dao.util;

public class DaoSqlRequestsPool {
	
	private DaoSqlRequestsPool() {
		
	}
	
	public static final String URL = "jdbc:mysql://localhost/library?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true"
			+ "&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

	public static final String DRIVER_SQL = "com.mysql.cj.jdbc.Driver";

	public static final String SQL_REQUEST_GET_ALL_USERS			= "SELECT * FROM users";
	public static final String SQL_REQUEST_INSERT_NEW_USER 			= "INSERT INTO users (login, password) VALUES(?, ?) ";
	public static final String SQL_REQUEST_UPDATE_USER				= "UPDATE users SET login=?, password=?, role=? WHERE id=?";
	public static final String SQL_REQUEST_DELETE_USER				= "DELETE FROM users WHERE id=?";
	public static final String SQL_REQUEST_READ_USER_BY_ID			= "SELECT * FROM users WHERE id=?";
	public static final String SQL_REQUEST_READ_USER_BY_PARAMS		= "SELECT * FROM users WHERE login=? AND password=?";
	public static final String SQL_REQUEST_INSERT_NEW_READ_BOOK		= "INSERT INTO read_books (user_id, book_id) VALUES(?, ?)";
	public static final String SQL_REQUEST_SET_CURRENT_USERS_BOOK	= "UPDATE users SET current_book_id=? WHERE id=?";
	public static final String SQL_REQUEST_GET_CURRENT_READING_BOOK = "SELECT current_book_id FROM users WHERE id=?";
	
	
	public static final String SQL_REQUEST_GET_BOOKS 			= "SELECT * FROM books LEFT JOIN authors ON authors.id=books.author_id";
	public static final String SQL_REQUEST_INSERT_NEW_BOOK 		= "INSERT INTO books ( title, published_year, author_id) VALUES(?, ?, ?)";
	public static final String SQL_REQUEST_UPDATE_BOOK 			= "UPDATE books SET title=?, published_year=?, author_id=?, available=? WHERE id=?";
	public static final String SQL_REQUEST_DELETE_BOOK 			= "DELETE FROM books WHERE id=?";
	public static final String SQL_REQUEST_READ_BOOK_BY_ID		= "SELECT * FROM books LEFT JOIN authors ON authors.id=books.author_id WHERE books.id=?";
	public static final String SQL_REQUEST_READ_BOOK_BY_PARAMS	= "SELECT * FROM books LEFT JOIN authors ON authors.id=books.author_id "
																+ "WHERE books.title=?, authors.name=?, authors.surname=?, books.published_year=?";
	
	public static final String SQL_REQUEST_CHOOSE_BOOK_BY_PARAMS	= "SELECT * FROM books LEFT JOIN authors ON authors.id=books.author_id "
			+ "WHERE (books.title=? OR authors.name=? OR authors.surname=? OR books.published_year=?)";
	public static final String SQL_REQUEST_CHANGE_BOOK_STATUS		= "UPDATE books SET available=? WHERE id=?";
	public static final String SQL_REQUEST_GET_USERS_BOOKS			= "SELECT * FROM books LEFT JOIN read_books ON read_books.book_id=books.id WHERE read_books.user_id=?";
	
	
	
	public static final String SQL_REQUEST_GET_READ_BOOK_BY_ID		= "SELECT * FROM read_books WHERE id=?";
	public static final String SQL_REQUEST_UPDATE_READ_BOOK			= "UPDATE read_books SET user_id=?, book_id=? WHERE id=?";
	public static final String SQL_REQUEST_DELETE_READ_BOOK			= "DELETE FROM read_books WHERE book_id=?";
	public static final String SQL_REQUEST_GET_READ_BOOK_BY_USER_ID = "SELECT book_id FROM read_books WHERE user_id=?";
	public static final String SQL_REQUEST_GET_USER_ID_BY_READ_BOOK = "SELECT user_id FROM read_books WHERE book_id=?";

	
	public static final String SQL_REQUEST_GET_AUTHORS 			= "SELECT * FROM authors";
	public static final String SQL_REQUEST_INSERT_NEW_AUTHOR 	= "INSERT INTO authors (name, surname, birthday) VALUES(?, ?, ?)";
	public static final String SQL_REQUEST_UPDATE_AUTHOR		= "UPDATE authors SET name=?, surname=?, bithday=? WHERE id=?";
	public static final String SQL_REQUEST_DELETE_AUTHOR		= "DELETE FROM authors WHERE id=?";

}
