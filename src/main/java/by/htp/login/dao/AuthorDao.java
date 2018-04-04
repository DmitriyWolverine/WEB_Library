package by.htp.login.dao;

import java.util.List;

import by.htp.login.bean.Author;

public interface AuthorDao extends BaseDao<Author>{
	List<Author> readAuthors();
	boolean ifAuthorExists(String name, String surname);
	Author getByName(String name, String surname);
	void create(String name, String surname, String authorBirthday);
}
