package by.htp.login.controller.util;

public class ControllerSqlRequestsPool {
	
	private ControllerSqlRequestsPool() {
		
	}
	
	public static final String URL = "jdbc:mysql://localhost/library?"
			+ "useUnicode=true&useJDBCCompliantTimezoneShift=true"
			+ "&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

	public static final String DRIVER_SQL = "com.mysql.cj.jdbc.Driver";

	public static final String SQL_REQUEST_GET_ALL_USERS = "SELECT * FROM users";
	public static final String SQL_REQUEST_INSERT_NEW_USER ="INSERT INTO users (login, password) VALUES(?, ?) ";
	
	public static final String SQL_REQUEST_GET_BOOKS = "select * from books LEFT JOIN authors ON authors.id=books.AuthorID";
	public static final String SQL_REQUEST_INSERT_NEW_BOOK ="INSERT INTO books ( Title, Published_Year, AuthorID) VALUES(?, ?, ?)";
	public static final String SQL_REQUEST_UPDATE_BOOK = "UPDATE books SET Title=?, Published_Year=?, AuthorID=? WHERE ID=?";
	public static final String SQL_REQUEST_DELTE_BOOK = "DELETE FROM books WHERE ID=?";
	
	public static final String SQL_REQUEST_GET_AUTHORS = "SELECT * FROM authors";
	public static final String SQL_REQUEST_INSERT_NEW_AUTHOR ="INSERT INTO authors (name, surname, birthday) VALUES(?, ?, ?)";

}
