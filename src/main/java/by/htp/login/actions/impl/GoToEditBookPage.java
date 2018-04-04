package by.htp.login.actions.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.actions.BaseAction;
import by.htp.login.actions.util.ActionChecker;
import by.htp.login.bean.Admin;
import by.htp.login.service.AuthorService;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.AuthorServiceImpl;
import by.htp.login.service.impl.BookServiceImpl;

import static by.htp.login.controller.util.JspPagesPool.*;
import static by.htp.login.controller.util.RequestParametresPool.*;

public class GoToEditBookPage implements BaseAction {
	
	private BookService bookService;
	private AuthorService autService;
	
	public GoToEditBookPage() {
		bookService = new BookServiceImpl();
		autService = new AuthorServiceImpl();
	}

	@Override
	public String doAction(HttpServletRequest request){
		String login = ((Admin) request.getSession().getAttribute(USER_TYPE_ADMIN)).getLogin();
		request.setAttribute(USER_LOGIN, login);
		if(ActionChecker.validateAdminSession(request)) {
			request.setAttribute(BOOKS_LIST, bookService.getBooksCatalog());
			UpdateBookAction.setCurId(Integer.parseInt(request.getParameter(BOOK_ID) ));
			request.setAttribute(AUTHORS_LIST, autService.getAuthorsCatalog());
			request.setAttribute(PREVIOUS_TITLE, bookService.getBookById(Integer.parseInt(request.getParameter(BOOK_ID))).getTitle() ) ;
			return (BOOK_EDIT_PAGE);
		}
		else {
			return (MAIN_PAGE);
		}
	}
}
