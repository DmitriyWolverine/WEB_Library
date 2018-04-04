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

public class UpdateBookAction implements BaseAction{
	private static int curId;
	
	private BookService bookService;
	private AuthorService authorService;
	private String curTitle;
	private String curAuthorStr;
	private int curYear;
	
	public UpdateBookAction (){
		bookService = new BookServiceImpl();
		authorService = new AuthorServiceImpl();
	}
	
	public static void setCurId(int id) {
		curId = id;
	}
	
	private void initParametres(HttpServletRequest request) {
		curTitle = request.getParameter(BOOK_TITLE);
		curAuthorStr = request.getParameter(AUTHOR_STRING);
		curYear = Integer.parseInt(request.getParameter(DATE_FROM_CALENDAR).split("-")[0]);
	}

	@Override
	public String doAction(HttpServletRequest request){
		if(ActionChecker.validateAdminSession(request)) {
			try {
				request.setAttribute(AUTHORS_LIST, authorService.getAuthorsCatalog());
				initParametres(request);
				bookService.updateBook(bookService.updateParametres(curId, curTitle, curAuthorStr, curYear));
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
