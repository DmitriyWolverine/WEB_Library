package by.htp.login.actions.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.actions.BaseAction;
import by.htp.login.actions.util.ActionChecker;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.BookServiceImpl;

import static by.htp.login.controller.util.JspPagesPool.*;
import static by.htp.login.controller.util.RequestParametresPool.*;

public class ShowBooksAction implements BaseAction{
	private BookService bookService ;
	
	public ShowBooksAction(){
		bookService = new BookServiceImpl();
	}
	
	@Override
	public String doAction(HttpServletRequest request)  {
		if (ActionChecker.validateSimpleUserSession(request))  {
			request.setAttribute(BOOKS_LIST, bookService.getBooksCatalog());
			return (BOOKS_LIST_PAGE);
		}
		else {
			return (MAIN_PAGE);
		}
	}
}
