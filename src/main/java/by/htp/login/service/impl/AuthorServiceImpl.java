package by.htp.login.service.impl;

import java.util.List;

import by.htp.login.bean.fields.Author;
import by.htp.login.dao.AuthorDao;
import by.htp.login.dao.impl.AuthorDaoDataBaseImpl;
import by.htp.login.service.AuthorService;

public class AuthorServiceImpl implements AuthorService{
	
	AuthorDao dao = new AuthorDaoDataBaseImpl();

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
