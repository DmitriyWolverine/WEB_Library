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

public class AddBookAction implements BaseAction{
	
	private BookService bookService;
	private AuthorService authorService; 
	
	private String title; 
	private String authorBirthday;
	private String aName;
	private String aSurname;
	private int publishedYear;
	
	public AddBookAction(){
		bookService = new BookServiceImpl();
		authorService = new AuthorServiceImpl(); 
	}
	
	private void initializeParametres(HttpServletRequest request)  {
		title = request.getParameter(BOOK_TITLE);
		authorBirthday = request.getParameter(AUTHOR_BIRTHDAY);
		aName = request.getParameter(AUTHOR_NAME);
		aSurname  = request.getParameter(AUTHOR_SURNAME);
		publishedYear = Integer.parseInt(request.getParameter(BOOK_PUBLISHED_YEAR));
	}

	@Override
	public String doAction(HttpServletRequest request)  {
		if(ActionChecker.validateAdminSession(request)) {
			try {
				initializeParametres(request);
				if( !authorService.checkIfAuthorExists(aName, aSurname) ) {
					authorService.createAuthor(aName, aSurname, authorBirthday);
				}
				bookService.createBook(bookService.initializeNewBook(title, authorService.getAuthorByName(aName, aSurname).getId(), publishedYear));
				request.setAttribute(BOOKS_LIST, bookService.getBooksCatalog());
				return (BOOKS_LIST_ADMIN_PAGE);
			}
			catch(NumberFormatException e ) {
				return (EROOR_INIT_FIELDS_PAGE);
			}
		}
		else {
			return (MAIN_PAGE);
		}
		
	}
}
