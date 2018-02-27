package by.htp.login.controller.actions.impl;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import by.htp.login.controller.actions.BaseAction;
import by.htp.login.service.AuthorService;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.AuthorServiceImpl;
import by.htp.login.service.impl.BookServiceImpl;

import static by.htp.login.controller.util.ControllerConstantsPool.*;
import static by.htp.login.controller.util.ControllerParametresConstants.*;

public class AddBookAction implements BaseAction{
	
	private String title; 
	private String authorBirthday;
	private String aName;
	private String aSurname;
	private int publishedYear;
	
	private void initializeParametres(HttpServletRequest request)  {
		title = request.getParameter(BOOK_TITLE);
		authorBirthday = request.getParameter(AUTHOR_BIRTHDAY);
		aName = request.getParameter(AUTHOR_NAME);
		aSurname  = request.getParameter(AUTHOR_SURNAME);
		publishedYear = Integer.parseInt(request.getParameter(BOOK_PUBLISHED_YEAR));
	}

	@Override
	public RequestDispatcher doAction(HttpServletRequest request) throws ServletException, IOException {
		initializeParametres(request);
		BookService bookService = new BookServiceImpl();
		AuthorService authorService = new AuthorServiceImpl();
		request.setAttribute(BOOK_TITLE, title);
		if( !authorService.checkIfAuthorExists(aName, aSurname) ) {
			authorService.createAuthor(aName, aSurname, authorBirthday);
			bookService.createBook(bookService.initializeNewBook(title, authorService.getAuthorByName(aName, aSurname).getId(), publishedYear));
			return request.getRequestDispatcher(BOOK_ADDED_PAGE);
		}
		else {
			if( !bookService.checkIfBookExists(bookService.initializeNewBook(title, authorService.getAuthorByName(aName, aSurname).getId(), publishedYear)) ) {
				bookService.createBook(bookService.initializeNewBook(title, authorService.getAuthorByName(aName, aSurname).getId(), publishedYear));
				return request.getRequestDispatcher(BOOK_ADDED_PAGE);
			}
			else {
				request.setAttribute(BOOK_TITLE,title);
				return request.getRequestDispatcher(BOOK_EXISTS_PAGE);
			}
		}
	
	}
	
}
