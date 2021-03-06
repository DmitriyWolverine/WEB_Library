package by.htp.login.dao.impl;

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

import by.htp.login.bean.Book;
import by.htp.login.bean.fields.Author;
import by.htp.login.dao.BookDao;

public class BookDaoDataBaseImpl implements BookDao{
	
	@Override
	public void create(Book entity) {
		if(entity==null) {
			return;
		}
		try {
			Class.forName(DRIVER_SQL);	
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_INSERT_NEW_BOOK)) {
			statement.setString(1, entity.getTitle());
			statement.setInt(2, entity.getPublishedYear());
			statement.setInt(3,  entity.getAuthor().getId());
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
	public Book read(int id) {
		if( id <= 0) {
			return null;
		}
		else {
			List<Integer> authIDList = new ArrayList<>();
			for(int i = 0 ; i < readAllBooks().size(); ++i ) {
				authIDList.add( readAllBooks().get(i).getId() );
			}
			
			for(int i = 0 ; i < authIDList.size(); ++i ) {
				if(id == authIDList.get(i)){
					return readAllBooks().get(i);
				}
			}
			return null;
		}
	}

	@Override
	public void update(Book entity) {
		if(entity==null) {
			return;
		}
		try {
			Class.forName(DRIVER_SQL);	
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_UPDATE_BOOK)) {
			statement.setString(1, entity.getTitle());
			statement.setInt(2, entity.getPublishedYear());
			statement.setInt(3,  entity.getAuthor().getId());
			statement.setInt(4, entity.getId());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		if(id<=0) {
			return;
		}
		try {
			Class.forName(DRIVER_SQL);	
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_DELETE_BOOK)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Book> readAllBooks() {
		try {
			Class.forName(DRIVER_SQL);	
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		List<Book> books = new ArrayList<>();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				Statement st =  cn.createStatement();	
				ResultSet bookRes = st.executeQuery(SQL_REQUEST_GET_BOOKS)) {
			while(bookRes.next()) {
				Book currentBook = new Book(bookRes.getInt(BOOK_ID_COLUMN) );
				currentBook.setTitle(bookRes.getString(BOOK_TITLE_COLUMN));
				Author bookAuthor = new Author((bookRes.getInt(AUTHOR_ID_COLUMN)), bookRes.getString(AUTHOR_NAME_COLUMN),bookRes.getString(AUTHOR_SURNAME_COLUMN), bookRes.getDate(AUTHOR_BIRTHDAY_COLUMN));
				currentBook.setAuthor(bookAuthor);
				currentBook.setPublishedYear(Integer.parseInt(bookRes.getString(BOOK_PUBLISHED_YEAR_COLUMN)));
				books.add(currentBook);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public boolean ifBookExists(Book curBook) {
		if(curBook == null) {
			return false;
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
	public Book readByParams(String title, Author author, int publishedYear) {
		new Book(title, author, publishedYear);
		for( int i = 0 ; i < readAllBooks().size(); ++i) {
			if(readAllBooks().get(i).getTitle().equals(title) && 
					readAllBooks().get(i).getAuthor().equals(author) &&
					readAllBooks().get(i).getId() == publishedYear) {
				return readAllBooks().get(i);
			}
		}
		return null;
	}
}
