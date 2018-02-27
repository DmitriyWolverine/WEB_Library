package by.htp.login.dao.util;

public class DaoSqlRequestsPool {
	
	private DaoSqlRequestsPool() {
		
	}
	
	public static final String URL = "jdbc:mysql://localhost/library?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true"
			+ "&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

	public static final String DRIVER_SQL = "com.mysql.cj.jdbc.Driver";

	public static final String SQL_REQUEST_GET_ALL_USERS		= "SELECT * FROM users";
	public static final String SQL_REQUEST_INSERT_NEW_USER 		= "INSERT INTO users (login, password) VALUES(?, ?) ";
	public static final String SQL_REQUEST_UPDATE_USER			= "UPDATE users SET login=?, password=?, role=? WHERE ID=?";
	public static final String SQL_REQUEST_DELETE_USER			= "DELETE FROM users WHERE id=?";

	
	public static final String SQL_REQUEST_GET_BOOKS 			= "SELECT * FROM books LEFT JOIN authors ON authors.id=books.author_id";
	public static final String SQL_REQUEST_INSERT_NEW_BOOK 		= "INSERT INTO books ( title, published_year, author_id) VALUES(?, ?, ?)";
	public static final String SQL_REQUEST_UPDATE_BOOK 			= "UPDATE books SET title=?, published_year=?, author_id=? WHERE ID=?";
	public static final String SQL_REQUEST_DELETE_BOOK 			= "DELETE FROM books WHERE id=?";
	
	public static final String SQL_REQUEST_GET_AUTHORS 			= "SELECT * FROM authors";
	public static final String SQL_REQUEST_INSERT_NEW_AUTHOR 	= "INSERT INTO authors (name, surname, birthday) VALUES(?, ?, ?)";
	public static final String SQL_REQUEST_UPDATE_AUTHOR		= "UPDATE authors SET name=?, surname=?, bithday=? WHERE ID=?";
	public static final String SQL_REQUEST_DELETE_AUTHOR		= "DELETE FROM authors WHERE id=?";

}
