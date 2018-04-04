package by.htp.login.service.impl;

import java.util.List;

import by.htp.login.bean.Author;
import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.factory.AuthorDaoFactory;
import by.htp.login.service.AuthorService;

import static by.htp.login.dao.util.DaoTypesConstants.*;
import static by.htp.login.service.util.ExceptionHandler.*;

public class AuthorServiceImpl implements AuthorService{
	
	private AuthorDao dao;

	public AuthorServiceImpl() {
		dao = AuthorDaoFactory.getInstance().getDataBaseHandler(SQL_DATA_BASE);
	}
	
	@Override
	public List<Author> getAuthorsCatalog() {
		return dao.readAuthors();
	}

	@Override
	public Author getAuthor(int id) {
		if(id <= 0 ) {
			showParametresAreNotInitializedMessage();
		}
		return dao.read(id);
	}

	@Override
	public boolean checkIfAuthorExists(String name, String surname) {
		if(name.isEmpty() || surname.isEmpty() ) {
			showParametresAreNotInitializedMessage();
		}
		return dao.ifAuthorExists(name, surname);
	}

	@Override
	public void createAuthor(Author author) {
		if ( author == null ) {
			showEntityIsNotInitializedMessage();
		}
		dao.create(author);
	}

	@Override
	public void createAuthor(String name, String surname, String birthday) {
		if(name.isEmpty() || surname.isEmpty() || birthday.isEmpty()) {
			showParametresAreNotInitializedMessage();
		}
		dao.create(name, surname, birthday);
	}

	@Override
	public Author getAuthorByName(String name, String surname) {
		if(name.isEmpty() || surname.isEmpty() ) {
			showParametresAreNotInitializedMessage();
		}
		return dao.getByName(name, surname);
	}
	

}
