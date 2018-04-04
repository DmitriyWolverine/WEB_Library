package by.htp.login.dao.util;

public class DaoSqlParametres {
	
	private DaoSqlParametres() {}

	public static final String CONNECTION_LOGIN 			 = "root";
	public static final String CONNECTION_PASS				 = "root";
	
	public static final String USER_ID_COLUMN  				 = "id";
	public static final String USER_LOGIN   				 = "login";
	public static final String USER_PASS   					 = "password";
	public static final String USER_ROLE   					 = "role";
	public static final String USER_READ_BOOKS				 = "read_books_id";
	public static final String USER_CURRENT_BOOK_ID			= "current_book_id";
	
	public static final String BOOK_ID_COLUMN       		 = "id";
	public static final String BOOK_TITLE_COLUMN       		 = "title";
	public static final String BOOK_PUBLISHED_YEAR_COLUMN    = "published_year";
	public static final String BOOK_IS_AVAILABLE			 = "available";
	
	public static final String AUTHOR_ID		     		 = "id";
	public static final String AUTHOR_ID_COLUMN     		 = "author_id";
	public static final String AUTHOR_NAME_COLUMN     		 = "name";
	public static final String AUTHOR_SURNAME_COLUMN     	 = "surname";
	public static final String AUTHOR_BIRTHDAY_COLUMN    	 = "birthday";
	

	public static final String READ_BOOKS_COLUMN_ID		   	 = "id";
	public static final String READER_ID		     		 = "user_id";
	public static final String READ_BOOK_ID		     		 = "book_id";
	
}