package by.htp.login.actions.impl;

import static by.htp.login.controller.util.JspPagesPool.*;
import static by.htp.login.controller.util.RequestParametresPool.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.actions.BaseAction;
import by.htp.login.actions.util.ActionChecker;
import by.htp.login.bean.Book;
import by.htp.login.service.AuthorService;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.AuthorServiceImpl;
import by.htp.login.service.impl.BookServiceImpl;

public class FindBooks implements BaseAction{
	
	private BookService bookService;
	private AuthorService authorService;
	
	private final String msg = "There is no books for your request.";
	
	private String curTitle = null;
	private String aName = null;
	private String aSurname = null;
	private int curYear;
	
	public FindBooks() {
		bookService = new BookServiceImpl();
		authorService = new AuthorServiceImpl();
		curYear = Integer.MIN_VALUE;
	}
	
	private void initParams(HttpServletRequest request) {
		String curAuthorStr = request.getParameter(AUTHOR_STRING.trim());
		curTitle = request.getParameter(BOOK_TITLE.trim());
		aName = null;
		aSurname = null  ;
		aName = curAuthorStr.split(" ")[0];
		if(curAuthorStr.split(" ").length> 1 ) {
			aSurname = curAuthorStr.split(" ")[1];
		}
		else {
			aSurname = aName;
		}
		if( request.getParameter(DATE_FROM_CALENDAR).length() > 0) {
			curYear = Integer.parseInt(request.getParameter(DATE_FROM_CALENDAR).split("-")[0]);
		}
	}

	@Override
	public String doAction(HttpServletRequest request)  {
		initParams(request);
		List<Book> booksForRequest = bookService.getChoosenBooks(curTitle, aName, aSurname, curYear);
		request.setAttribute(BOOKS_LIST, booksForRequest);
		if(booksForRequest.isEmpty()) {
			request.setAttribute(TEXT_MESSAGE, msg);
		}
		if(ActionChecker.validateAdminSession(request)) {
			request.setAttribute(AUTHORS_LIST, authorService.getAuthorsCatalog());
			return (BOOKS_LIST_ADMIN_PAGE);
		}
		return (BOOKS_LIST_PAGE);
	}
}
