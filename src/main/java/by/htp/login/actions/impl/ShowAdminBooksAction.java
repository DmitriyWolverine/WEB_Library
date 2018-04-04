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

public class ShowAdminBooksAction implements BaseAction{
	
	private BookService bookService;
	AuthorService authorService;
	
	public ShowAdminBooksAction() {
		bookService = new BookServiceImpl();
		authorService = new AuthorServiceImpl();
	}
	
	@Override
	public String doAction(HttpServletRequest request) {
		if(ActionChecker.validateAdminSession(request)) {
			request.setAttribute(BOOKS_LIST, bookService.getBooksCatalog());
			request.setAttribute(AUTHORS_LIST, authorService.getAuthorsCatalog());
			return (BOOKS_LIST_ADMIN_PAGE);
		}
		else {
			return (MAIN_PAGE);
		}
	}
}
