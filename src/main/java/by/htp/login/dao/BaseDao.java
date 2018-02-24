package by.htp.login.dao;

import by.htp.login.bean.Entity;

public interface BaseDao<T extends Entity> {
	void create(T user);
	T read(int id);
	void update( T entity);
	void delete(int id);
}
