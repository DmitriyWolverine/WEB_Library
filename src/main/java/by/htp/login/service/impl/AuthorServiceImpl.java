package by.htp.login.service.impl;

import java.util.List;

import by.htp.login.bean.fields.Author;
import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.util.AuthorDaoFactoryMethod;
import by.htp.login.service.AuthorService;

import static by.htp.login.dao.util.DaoTypesConstants.*;

public class AuthorServiceImpl implements AuthorService{
	
	AuthorDao dao = AuthorDaoFactoryMethod.getDataBaseHandler(SQL_DATA_BASE);

	@Override
	public List<Author> getAuthorsCatalog() {
		return dao.readAuthors();
	}

	@Override
	public Author getAuthor(int id) {
		return dao.read(id);
	}

	@Override
	public boolean checkIfAuthorExists(String name, String surname) {
		return dao.ifAuthorExists(name, surname);
	}

	@Override
	public void createAuthor(Author author) {
		dao.create(author);
	}

	@Override
	public void createAuthor(String name, String surName, String birthday) {
		dao.create(name, surName, birthday);
	}

	@Override
	public Author getAuthorByName(String name, String surName) {
		return dao.getByName(name, surName);
	}
	

}
