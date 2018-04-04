package by.htp.login.dao.impl.sql;

import static by.htp.login.dao.util.DaoSqlRequestsPool.*;
import static by.htp.login.dao.util.DaoExceptionMessagesPool.*;
import static by.htp.login.dao.util.DaoSqlParametres.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.login.bean.Admin;
import by.htp.login.bean.Book;
import by.htp.login.bean.SimpleUser;
import by.htp.login.bean.User;
import by.htp.login.bean.util.MD5;
import by.htp.login.dao.SimpleUserDao;
import by.htp.login.dao.util.DaoExceptionHandler;
import by.htp.login.dao.util.DaoSqlDriverValidator;

public class SimpleUserDaoDataBaseImpl implements SimpleUserDao{
	
	@Override
	public void create(SimpleUser entity) {
		if(entity!=null && entity.getLogin()!=null && entity.getPassword()!=null)
		{
			DaoSqlDriverValidator.loadDriver();
			try( Connection connect = DriverManager.getConnection(URL, CONNECTION_LOGIN, CONNECTION_PASS);
					 PreparedStatement statement = connect.prepareStatement(SQL_REQUEST_INSERT_NEW_USER)){
				statement.setString(1, entity.getLogin());
				statement.setString(2, entity.getPassword());
				statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void create(String login, String password) {
		SimpleUser sUser = new SimpleUser(login,password);
		this.create(sUser);
	}

	@Override
	public SimpleUser read(int id) {
		if( id <= 0) {
			DaoExceptionHandler.showDaoExceptionStackTrace(PARAMETRES_ARE_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		SimpleUser simpleUser = null;
		ResultSet userRes  = null;
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS) ; 
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_READ_USER_BY_ID);
				) {
			statement.setInt(1, id);
			userRes = statement.executeQuery();
			while (userRes.next()) {
				simpleUser = createSimpleUser(userRes); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResultSet(userRes);
		}
		return simpleUser;
	}

	private SimpleUser initUser(ResultSet userRes) throws SQLException {
		SimpleUser simpleUser=null;
		if( userRes.getInt(USER_ROLE)==1 ) {
			simpleUser = new Admin(userRes.getInt(USER_ID_COLUMN) );
		}
		else {
			simpleUser = new SimpleUser(userRes.getInt(USER_ID_COLUMN) );
		}
		simpleUser.setLogin(userRes.getString(USER_LOGIN));
		simpleUser.setMd5Password(userRes.getString(USER_PASS));
		simpleUser.setCurrentBook(getBookFromSqlById(userRes.getInt(USER_CURRENT_BOOK_ID)) );
		
		return simpleUser;
	}
	
	@Override
	public SimpleUser readUser(String login, String password) {
		if( !ifUserExists(login,password)) {
			DaoExceptionHandler.showDaoExceptionStackTrace(SUCH_USER_DOES_NOT_EXIST);
		}
		DaoSqlDriverValidator.loadDriver();
		SimpleUser simpleUser = null;
		ResultSet userRes = null;
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS) ; 
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_READ_USER_BY_PARAMS)) {
			statement.setString(1, login);
			statement.setString(2, MD5.md5Custom(password));
			userRes = statement.executeQuery();
			while(userRes.next()) {
				simpleUser = initUser(userRes);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeResultSet(userRes);
		}
		return simpleUser;
	}
	
	@Override
	public boolean ifUserExists(String login, String password) {
		if(login!=null && password!=null) {
			List<SimpleUser> users = getRegistratedUsers();
			for(int i = 0 ; i < users.size() ; ++i) {
				if( users.get(i).getLogin().equals(login) ) {
					return true;
				}
			}	
		}
		return false;
	}
	

	@Override
	public List<SimpleUser> getRegistratedUsers() {
		DaoSqlDriverValidator.loadDriver();
		List<SimpleUser> usersList = new ArrayList<>();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS)  ; 
				Statement st =  cn.createStatement();
				ResultSet userRes = st.executeQuery(SQL_REQUEST_GET_ALL_USERS)  ) {
			while(userRes.next()) {
				if(userRes.getString(USER_LOGIN)!=null && userRes.getString(USER_PASS)!=null) {
					SimpleUser user = new SimpleUser(userRes.getString(USER_LOGIN));
					user.setMd5Password(userRes.getString(USER_PASS));
					if(Integer.parseInt(userRes.getString(USER_ROLE))==1) {
						user.setAdmin(true);
					}
					usersList.add(user);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	@Override
	public void update(SimpleUser entity) {
		if(entity==null) {
			DaoExceptionHandler.showDaoExceptionStackTrace(ENTITY_IS_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_UPDATE_USER)) {
			statement.setString(1, entity.getLogin());
			statement.setString(2, entity.getPassword());
			statement.setInt(3,  entity.isAdmin()?1:0);
			statement.setInt(4, entity.getId());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		if(id<=0) {
			DaoExceptionHandler.showDaoExceptionStackTrace(PARAMETRES_ARE_NOT_INITIALIZIED);
		}
		DaoSqlDriverValidator.loadDriver();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_DELETE_USER)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateReadBooks(User user, Book book) {
		if(user == null || book == null) {
			DaoExceptionHandler.showDaoExceptionStackTrace(ENTITY_IS_NOT_INITIALIZIED);
		}
		else {
			DaoSqlDriverValidator.loadDriver();
			try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
					PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_INSERT_NEW_READ_BOOK)) {
				statement.setInt(1, user.getId());
				statement.setInt(2, book.getId());
				statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setCurrentBook(User user, Book book) {
		int bookId = 0;
		if(user == null ) {
			DaoExceptionHandler.showDaoExceptionStackTrace(ENTITY_IS_NOT_INITIALIZIED);
		}
		else {
			DaoSqlDriverValidator.loadDriver();
			try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
					PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_SET_CURRENT_USERS_BOOK)) {
				if(book != null) {
					bookId = book.getId();
				}
				statement.setInt(1, bookId);
				statement.setInt(2, user.getId());
				statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private SimpleUser createSimpleUser(ResultSet userRes) throws SQLException {
		SimpleUser simpleUser = new SimpleUser(userRes.getInt(USER_ID_COLUMN) );
		simpleUser.setLogin(userRes.getString(USER_LOGIN));
		simpleUser.setMd5Password(userRes.getString(USER_PASS));
		simpleUser.setAdmin(userRes.getInt(USER_ROLE)==1?true:false);
		simpleUser.setCurrentBook(getBookFromSqlById(userRes.getInt(USER_CURRENT_BOOK_ID)));
		return simpleUser;
	}
	
	private Book getBookFromSqlById(int bookId) {
		return (new BookDaoDataBaseImpl()).read(bookId);
	}
	
	
	private void closeResultSet( ResultSet res) {
		try {
			if(res!=null)
				res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getCurrentReadingBookId(User user) {
		int readingBookId = 0;
		if(user == null ) {
			DaoExceptionHandler.showDaoExceptionStackTrace(ENTITY_IS_NOT_INITIALIZIED);
		}
		else {
			ResultSet userRes  = null;
			try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS) ; 
					PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_GET_CURRENT_READING_BOOK);
					) {
				statement.setInt(1, user.getId());
				userRes = statement.executeQuery();
				while (userRes.next()) {
					readingBookId = userRes.getInt(USER_CURRENT_BOOK_ID);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				closeResultSet(userRes);
			}
			
		}
		return readingBookId;
	}
	
}
