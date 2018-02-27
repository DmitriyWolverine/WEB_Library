package by.htp.login.dao.impl;

import static by.htp.login.dao.util.DaoSqlRequestsPool.*;
import static by.htp.login.dao.util.DaoSqlParametres.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.login.bean.fields.Author;
import by.htp.login.dao.AuthorDao;

public class AuthorDaoDataBaseImpl implements AuthorDao{
	
	@Override
	public void create(Author author) {
		if(author==null) {
			return;
		}
		try {
			Class.forName(DRIVER_SQL);	
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				 PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_INSERT_NEW_AUTHOR)) {
			statement.setString(1, author.getName());
			statement.setString(2, author.getSurname());
			Date date = new Date(author.getBirthday().getTime());
			statement.setDate(3, date);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void create(String authorName, String authorSurname, String authorBirthday) {
		Author curAuthor = new Author(authorName, authorSurname);
		curAuthor.setBirthday(authorBirthday.replace("-", "_"));
		this.create(curAuthor);
	}

	@Override
	public Author read(int id) {
		if( id <= 0) {
			return null;
		}
		else {
			List<Integer> authIDList = new ArrayList<>();
			for(int i = 0 ; i < readAuthors().size(); ++i ) {
				authIDList.add( readAuthors().get(i).getId() );
			}
			
			for(int i = 0 ; i < authIDList.size(); ++i ) {
				if(id == authIDList.get(i)){
					return readAuthors().get(i);
				}
			}
			return null;
		}
	}

	@Override
	public void update(Author entity) {
		if(entity==null) {
			return;
		}
		try {
			Class.forName(DRIVER_SQL);	
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_UPDATE_AUTHOR)) {
			statement.setString(1, entity.getName());
			statement.setString(2, entity.getSurname());
			statement.setDate(3,  new Date( entity.getBirthday().getTime() ));
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
				PreparedStatement statement = cn.prepareStatement(SQL_REQUEST_DELETE_AUTHOR)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Author> readAuthors() {
		try {
			Class.forName(DRIVER_SQL);
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		List<Author> authorsList = new ArrayList<>();
		try( Connection cn = DriverManager.getConnection(URL,CONNECTION_LOGIN,CONNECTION_PASS);
				Statement st =  cn.createStatement();
				ResultSet userRes = st.executeQuery(SQL_REQUEST_GET_AUTHORS)) {
			
			while(userRes.next()) {
				int id = userRes.getInt(AUTHOR_ID);
				String name = userRes.getString(AUTHOR_NAME_COLUMN);
				String surName = userRes.getString(AUTHOR_SURNAME_COLUMN);
				String birthday = userRes.getString(AUTHOR_BIRTHDAY_COLUMN);
				if(name!=null && surName!=null ) {
					Author aut = new Author(id, name, surName);
					aut.setBirthday(birthday.replaceAll("-","_"));
					authorsList.add(aut);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return authorsList;
	}
	
	@Override
	public Author getByName(String name, String surname) {
		if( ifAuthorExists(name,surname) ) {
			List<Author> authors = readAuthors();
			for(int i = 0 ; i < authors.size() ; ++i) {
				if(authors.get(i).getName().equals(name) && authors.get(i).getSurname().equals(surname)) {
					return authors.get(i);
				}
			}	
		}
		return null;
	}
	
	@Override
	public boolean ifAuthorExists(String name, String surName) {
		if(name!=null && surName!=null) {
			List<Author> authors = readAuthors();
			for(int i = 0 ; i < authors.size() ; ++i) {
				if(authors.get(i).getName().equals(name) && authors.get(i).getSurname().equals(surName)) {
					return true;
				}
			}	
		}
		return false;
	}

}
