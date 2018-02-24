package by.htp.login.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.login.bean.users.SimpleUser;
import by.htp.login.dao.SimpleUserDao;
import static by.htp.login.controller.util.ControllerSqlRequestsPool.*;

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
			try( Connection connect = DriverManager.getConnection(URL, "root", "root");
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
			if(users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(password)) {
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
	public void changePassword() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void changeLogin() {
		throw new UnsupportedOperationException();
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
		try( Connection cn = DriverManager.getConnection(URL,"root","root")  ; 
				Statement st =  cn.createStatement();
				 ResultSet userRes = st.executeQuery(SQL_REQUEST_GET_ALL_USERS)  ) {
			while(userRes.next()) {
				if(userRes.getString("login")!=null && userRes.getString("password")!=null) {
					SimpleUser user = new SimpleUser(userRes.getString("login"), userRes.getString("password"));
					if(Integer.parseInt(userRes.getString("role"))==1) {
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
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void update(SimpleUser entity) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void delete(int id) {
		throw new UnsupportedOperationException();
		
	}

}
