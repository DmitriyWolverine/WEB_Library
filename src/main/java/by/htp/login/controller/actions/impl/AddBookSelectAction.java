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

public class AddBookSelectAction implements BaseAction{

	@Override
	public RequestDispatcher doAction(HttpServletRequest request) throws ServletException, IOException {
		
		BookService bookService = new BookServiceImpl();
		AuthorService authorService = new AuthorServiceImpl();
		request.setAttribute(AUTHORS_LIST, authorService.getAuthorsCatalog());
		try {
			String title = request.getParameter(BOOK_TITLE);
			int curAuthorId = Integer.parseInt(request.getParameter(AUTHOR_STRING).trim());
			int publishedYear = Integer.parseInt(request.getParameter(DATE_FROM_CALENDAR).split("-")[0]);
			request.setAttribute(BOOK_TITLE,title );
			if( !bookService.checkIfBookExists(bookService.initializeNewBook(title, curAuthorId, publishedYear)) ) {
				bookService.createBook(bookService.initializeNewBook(title, curAuthorId, publishedYear));
				return request.getRequestDispatcher(BOOK_ADDED_PAGE);
			}
			else {
				request.setAttribute(BOOK_TITLE,title);
				return  request.getRequestDispatcher(BOOK_EXISTS_PAGE);
			}
		}
		catch(NumberFormatException e) {
			return request.getRequestDispatcher(EROOR_INIT_FIELDS_PAGE);
		}
	}

}
