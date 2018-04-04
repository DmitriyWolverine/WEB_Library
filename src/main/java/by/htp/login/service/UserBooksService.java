package by.htp.login.service;

import java.util.List;

import by.htp.login.bean.PairUserBook;

public interface UserBooksService {
	void addNewBook(PairUserBook pair);
	List<Integer> booksReadList(int userId);
}
