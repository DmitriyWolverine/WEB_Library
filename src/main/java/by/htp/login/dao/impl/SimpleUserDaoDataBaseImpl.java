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

import by.htp.login.bean.users.SimpleUser;
import by.htp.login.bean.util.MD5;
import by.htp.login.dao.SimpleUserDao;

public class SimpleUserDaoDataBaseImpl implements SimpleUserDao{
	
	@Override
	public void create(SimpleUser entity) {
		if(entity!=null && entity.getLogin()!=null && entity.getPassword()!=null)
		{
			try {
				Class.forName(DRIVER_SQL);
			}
			catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
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

	public SimpleUser readUser(int id) {
		try {
			Class.forName(DRIVER_SQL);
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		List<SimpleUser> users = getRegistratedUsers();
		for(int i = 0 ; i < users.size() ; ++i) {
			if(users.get(i).getId()==id) {
				return users.get(i);
			}
		}
		return null;
	}
	
	@Override
	public SimpleUser readUser(String login, String password) {
		try {
			Class.forName(DRIVER_SQL);
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		List<SimpleUser> users = getRegistratedUsers();
		for(int i = 0 ; i < users.size() ; ++i) {
			String md5Pass = MD5.md5Custom(password);
			if(users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(md5Pass)) {
				return users.get(i);
			}
		}
		return null;
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
		try {
			Class.forName(DRIVER_SQL);
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
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
	public SimpleUser read(int id){
		if( id <= 0) {
			return null;
		}
		else {
			List<Integer> usersList = new ArrayList<>();
			for(int i = 0 ; i < getRegistratedUsers().size(); ++i ) {
				usersList.add( getRegistratedUsers().get(i).getId() );
			}
			
			for(int i = 0 ; i < usersList.size(); ++i ) {
				if(id == usersList.get(i)){
					return getRegistratedUsers().get(i);
				}
			}
			return null;
		}
	}

	
	@Override
	public void update(SimpleUser entity) {
		if(entity==null) {
			return;
		}
		try {
			Class.forName(DRIVER_SQL);	
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
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
			return;
		}
		try {
			Class.forName(DRIVER_SQL);	
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_DELETE_USER)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
