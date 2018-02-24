package by.htp.login.service;

import java.util.List;

import by.htp.login.bean.fields.Author;

public interface AuthorService {
	
	List<Author> getAuthorsCatalog();
	Author getAuthor(int id);
	boolean checkIfAuthorExists(String name, String surname);
	void createAuthor(Author author);
	void createAuthor(String name, String surName, String birthday);
	Author getAuthorByName(String name, String surName);
	

}
