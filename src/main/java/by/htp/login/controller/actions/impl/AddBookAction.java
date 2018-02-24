package by.htp.login.controller.actions.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.login.controller.actions.BaseAction;
import by.htp.login.service.AuthorService;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.AuthorServiceImpl;
import by.htp.login.service.impl.BookServiceImpl;

import static by.htp.login.controller.util.ControllerConstantsPool.*;

public class AddBookAction implements BaseAction{

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String title = request.getParameter("title");
		String authorBirthday = request.getParameter("aBirthday");
		String aName = request.getParameter("aName");
		String aSurname  = request.getParameter("aSurname");
		int publishedYear = Integer.parseInt(request.getParameter("pubYear"));
		BookService bookService = new BookServiceImpl();
		AuthorService authorService = new AuthorServiceImpl();
		request.setAttribute("title",title );
		
		if( !authorService.checkIfAuthorExists(aName, aSurname) ) {
			authorService.createAuthor(aName, aSurname, authorBirthday);
			bookService.createBook(bookService.initializeNewBook(title, authorService.getAuthorByName(aName, aSurname).getId() +"", publishedYear));
			dispatcher = request.getRequestDispatcher(BOOK_ADDED_PAGE);
		}
		else {
			if( !bookService.checkIfBookExists(bookService.initializeNewBook(title, authorService.getAuthorByName(aName, aSurname).getId() +"", publishedYear)) ) {
				bookService.createBook(bookService.initializeNewBook(title, authorService.getAuthorByName(aName, aSurname).getId() +"", publishedYear));
				dispatcher = request.getRequestDispatcher(BOOK_ADDED_PAGE);
			}
			else {
				request.setAttribute("book",title);
				dispatcher = request.getRequestDispatcher(BOOK_EXISTS);
			}
		}
		dispatcher.forward(request, response);
	}
	
}
