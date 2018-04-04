package by.htp.login.actions.impl;


import javax.servlet.http.HttpServletRequest;

import by.htp.login.actions.BaseAction;
import by.htp.login.actions.util.ActionChecker;
import by.htp.login.service.AuthorService;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.AuthorServiceImpl;
import by.htp.login.service.impl.BookServiceImpl;

import static by.htp.login.controller.util.JspPagesPool.*;
import static by.htp.login.controller.util.RequestParametresPool.*;

public class AddBookSelectAction implements BaseAction{
	
	private BookService bookService = null;
	private AuthorService authorService = null;
	
	private String title;
	private int curAuthorId;
	private int publishedYear;
	
	public AddBookSelectAction() {
		bookService = new BookServiceImpl();
		authorService = new AuthorServiceImpl();
	}

	private void initParamtres(HttpServletRequest request) {
		title = request.getParameter(BOOK_TITLE);
		curAuthorId = Integer.parseInt(request.getParameter(AUTHOR_STRING).trim());
		publishedYear = Integer.parseInt(request.getParameter(DATE_FROM_CALENDAR).split("-")[0]);
	}
	
	@Override
	public String doAction(HttpServletRequest request) {
		if(ActionChecker.validateAdminSession(request)) {
			request.setAttribute(AUTHORS_LIST, authorService.getAuthorsCatalog());
			try {
				initParamtres(request);
				bookService.createBook(bookService.initializeNewBook(title, curAuthorId, publishedYear));
				request.setAttribute(BOOKS_LIST, bookService.getBooksCatalog());
				return (BOOKS_LIST_ADMIN_PAGE);
			}
			catch(NumberFormatException e) {
				return (EROOR_INIT_FIELDS_PAGE);
			}
		}
		else {
			return (MAIN_PAGE);
		}
	}
	
}
