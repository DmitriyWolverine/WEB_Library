package by.htp.login.dao.impl.sql;

import static by.htp.login.dao.util.DaoSqlRequestsPool.*;
import static by.htp.login.dao.util.DaoSqlParametres.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.login.bean.Author;
import by.htp.login.bean.Book;
import by.htp.login.dao.BookDao;
import by.htp.login.dao.exception.DaoIncorrectInputDataException;
import by.htp.login.dao.util.DaoSqlDriverValidator;

import static by.htp.login.dao.util.DaoExceptionMessagesPool.*;

public class BookDaoDataBaseImpl implements BookDao{
	
	@Override
	public void create(Book entity) {
		if(entity == null) {
			throw new DaoIncorrectInputDataException(ENTITY_IS_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_INSERT_NEW_BOOK)) {
			statement.setString(1, entity.getTitle());
			statement.setInt(2, entity.getPublishedYear());
			statement.setInt(3, entity.getAuthor().getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void create(String title, Author author, int publishedYear){
		Book curBook = new Book(title,author,publishedYear);
		this.create(curBook);
	}
	
	@Override
	public Book read(int id)  {
		if( id < 0) {
			throw new DaoIncorrectInputDataException(PARAMETRES_ARE_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		Book currentBook = null;
		ResultSet bookRes = null;
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS) ; 
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_READ_BOOK_BY_ID)) {
			statement.setInt(1, id);
			bookRes = statement.executeQuery();
			while(bookRes.next()) {
				currentBook = createBook(bookRes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResultSet(bookRes);
		}
		return currentBook;
	}

	@Override
	public void update(Book entity) {
		if(entity==null) {
			throw new DaoIncorrectInputDataException(ENTITY_IS_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_UPDATE_BOOK)) {
			statement.setString(1, entity.getTitle());
			statement.setInt(2, entity.getPublishedYear());
			statement.setInt(3, entity.getAuthor().getId());
			statement.setInt(4, entity.getAvailableInt());
			statement.setInt(5, entity.getId());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		if(id<=0) {
			throw new DaoIncorrectInputDataException(PARAMETRES_ARE_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_DELETE_BOOK)) {
			statement.setInt(1, id);
			deleteBookFromReadList(id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBookFromReadList(int id) {
		if(id<=0) {
			throw new DaoIncorrectInputDataException(PARAMETRES_ARE_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_DELETE_READ_BOOK)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Book> readAllBooks() {
		DaoSqlDriverValidator.loadDriver();
		List<Book> booksList = new ArrayList<>();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				Statement st =  cn.createStatement();	
				ResultSet bookRes = st.executeQuery(SQL_REQUEST_GET_BOOKS)) {
			while(bookRes.next()) {
				addNewBookToList(booksList, bookRes);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return booksList;
	}

	@Override
	public boolean ifBookExists(Book curBook) {
		if(curBook == null) {
			throw new DaoIncorrectInputDataException(ENTITY_IS_NOT_INITIALIZIED);
		}
		List<Book> books = readAllBooks();
		for( int i = 0 ; i < books.size() ; ++i) {
			if(books.get(i).equals(curBook)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Book> readByParams(String title, Author author, int publishedYear) {
		List<Book> booksList = null;
		if( title == null || author == null) {
			return new ArrayList<>();
		}
		DaoSqlDriverValidator.loadDriver();
		ResultSet bookRes = null;
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS) ; 
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_READ_BOOK_BY_PARAMS);
				) {
			initSqlPreparedStatementParams(statement, title, author.getName(), author.getSurname(), publishedYear);
			bookRes = statement.executeQuery();
			booksList = new ArrayList<>();
			while(bookRes.next()) {
				addNewBookToList(booksList, bookRes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResultSet(bookRes);
		}
		return booksList;
	}
	
	@Override
	public List<Book> findChoosenBooks(String title, String aName, String aSurname, int publishedYear) {
		List<Book> booksList = null;
		validateParametres(title, aName, aSurname);
		DaoSqlDriverValidator.loadDriver();
		ResultSet bookRes = null;
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS) ; 
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_CHOOSE_BOOK_BY_PARAMS)) {
			initSqlPreparedStatementParams(statement, title, aName, aSurname, publishedYear);
			bookRes = statement.executeQuery();
			booksList = new ArrayList<>();
			while(bookRes.next()) {
				addNewBookToList(booksList, bookRes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResultSet(bookRes);
		}
		return booksList;
	}
	

	@Override
	public void changeStatus(int id, boolean status) {
		if( id<=0 ) {
			throw new DaoIncorrectInputDataException(PARAMETRES_ARE_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_CHANGE_BOOK_STATUS)) {
			statement.setInt(1, status? 1 : 0);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	private void validateParametres(String title, String aName, String aSurname) {
		if( title == null || title.length()==0 ) {
			title="";
		}
		if( aName == null || aName.length()==0 ) {
			aName="";
		}
		if( aSurname == null || aSurname.length()==0 ) {
			aSurname="";
		}
	}
	
	private void addNewBookToList(List<Book> booksList , ResultSet bookRes) throws SQLException {
		Book currentBook = createBook(bookRes);
		booksList.add(currentBook);
	}
	
	private Book createBook(ResultSet bookRes) throws SQLException {
		Book currentBook = new Book(bookRes.getInt(BOOK_ID_COLUMN) );
		currentBook.setTitle(bookRes.getString(BOOK_TITLE_COLUMN));
		Author bookAuthor = new Author((bookRes.getInt(AUTHOR_ID_COLUMN)), bookRes.getString(AUTHOR_NAME_COLUMN),bookRes.getString(AUTHOR_SURNAME_COLUMN), bookRes.getDate(AUTHOR_BIRTHDAY_COLUMN));
		currentBook.setAuthor(bookAuthor);
		currentBook.setPublishedYear(Integer.parseInt(bookRes.getString(BOOK_PUBLISHED_YEAR_COLUMN)));
		currentBook.setAvailable( bookRes.getInt(BOOK_IS_AVAILABLE) == 1 );
		return currentBook;
	}
	
	private void initSqlPreparedStatementParams(PreparedStatement statement, String title, String aName, String aSurname, int publishedYear) throws SQLException {
		statement.setString(1, title);
		statement.setString(2, aName);
		statement.setString(3, aSurname);
		statement.setInt(4, publishedYear);
	}
	
	private void closeResultSet( ResultSet bookRes) {
		try {
			if(bookRes!=null)
				bookRes.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> readByUser(int userId) {
		List<Book> booksList = null;
		DaoSqlDriverValidator.loadDriver();
		ResultSet bookRes = null;
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS) ; 
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_GET_USERS_BOOKS)) {
			statement.setInt(1,userId);
			bookRes = statement.executeQuery();
			booksList = new ArrayList<>();
			while(bookRes.next()) {
				Book currentBook = new Book(bookRes.getInt(BOOK_ID_COLUMN) );
				currentBook.setTitle(bookRes.getString(BOOK_TITLE_COLUMN));
				currentBook.setAuthor( read(currentBook.getId()).getAuthor() );
				currentBook.setPublishedYear(Integer.parseInt(bookRes.getString(BOOK_PUBLISHED_YEAR_COLUMN)));
				currentBook.setAvailable(bookRes.getInt(BOOK_IS_AVAILABLE)==1);
				booksList.add(currentBook);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResultSet(bookRes);
		}
		return booksList;
	}
	
}
