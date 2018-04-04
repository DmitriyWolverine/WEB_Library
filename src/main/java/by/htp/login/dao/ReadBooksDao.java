package by.htp.login.dao;

import java.util.List;

import by.htp.login.bean.PairUserBook;

public interface ReadBooksDao extends BaseDao<PairUserBook>{
	List<Integer> readAllReadBooksIdByUser(int userId);
	List<Integer> readAllUsersWhoReadBook(int bookId);
}
