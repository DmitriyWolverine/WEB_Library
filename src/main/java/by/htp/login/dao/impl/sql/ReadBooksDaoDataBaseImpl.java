package by.htp.login.dao.impl.sql;

import static by.htp.login.dao.util.DaoExceptionMessagesPool.ENTITY_IS_NOT_INITIALIZIED;
import static by.htp.login.dao.util.DaoExceptionMessagesPool.PARAMETRES_ARE_NOT_INITIALIZIED;
import static by.htp.login.dao.util.DaoSqlParametres.*;
import static by.htp.login.dao.util.DaoSqlRequestsPool.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.login.bean.PairUserBook;
import by.htp.login.dao.ReadBooksDao;
import by.htp.login.dao.exception.DaoIncorrectInputDataException;
import by.htp.login.dao.util.DaoSqlDriverValidator;

public class ReadBooksDaoDataBaseImpl implements ReadBooksDao{

	@Override
	public void create(PairUserBook entity) {
		if(entity == null) {
			throw new DaoIncorrectInputDataException(ENTITY_IS_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_INSERT_NEW_READ_BOOK)) {
			statement.setInt(1, entity.getUserId());
			statement.setInt(2, entity.getBookId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public PairUserBook read(int id) {
		if( id <= 0) {
			throw new DaoIncorrectInputDataException(PARAMETRES_ARE_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		ResultSet readBookRes = null;
		PairUserBook pair = null;
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS) ; 
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_GET_READ_BOOK_BY_ID)) {
			statement.setInt(1, id);
			readBookRes = statement.executeQuery();
			while(readBookRes.next()) {
				pair = createPair(readBookRes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			closeResultSet(readBookRes);
		}
		return pair;
	}
	
	@Override
	public void update(PairUserBook entity) {
		if(entity==null) {
			throw new DaoIncorrectInputDataException(ENTITY_IS_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_UPDATE_READ_BOOK)) {
			statement.setInt(1, entity.getUserId());
			statement.setInt(2, entity.getBookId());
			statement.setInt(3, entity.getId());
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
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_DELETE_READ_BOOK)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Integer> readAllReadBooksIdByUser(int userId) {
		DaoSqlDriverValidator.loadDriver();
		List<Integer> booksList = new ArrayList<>();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				Statement st =  cn.createStatement();	
				ResultSet res = st.executeQuery(SQL_REQUEST_GET_READ_BOOK_BY_USER_ID)) {
			while(res.next()) {
				addNewBookIdToList(booksList, res);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return booksList;
	}

	@Override
	public List<Integer> readAllUsersWhoReadBook(int bookId) {
		DaoSqlDriverValidator.loadDriver();
		List<Integer> usersList = new ArrayList<>();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				Statement st =  cn.createStatement();	
				ResultSet res = st.executeQuery(SQL_REQUEST_GET_USER_ID_BY_READ_BOOK)) {
			while(res.next()) {
				addNewUserIdToList(usersList, res);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	private void addNewUserIdToList(List<Integer> booksList, ResultSet res) throws SQLException {
		PairUserBook pair = createPair(res);
		booksList.add(pair.getUserId());
	}
	
	private void addNewBookIdToList(List<Integer> booksList, ResultSet res) throws SQLException {
		PairUserBook pair = createPair(res);
		booksList.add(pair.getBookId());
	}
	
	private PairUserBook createPair(ResultSet readBookRes) throws SQLException {
		PairUserBook pair = new PairUserBook(readBookRes.getInt(READ_BOOKS_COLUMN_ID));
		pair.setUserId(readBookRes.getInt(READER_ID));
		pair.setBookId(readBookRes.getInt(READ_BOOK_ID));
		return pair;
	}
	
	private void closeResultSet( ResultSet res) {
		try {
			if(res!=null)
				res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
