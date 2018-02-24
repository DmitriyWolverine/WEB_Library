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

public class AddBookSelectAction implements BaseAction{

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookService bookService = new BookServiceImpl();
		AuthorService authorService = new AuthorServiceImpl();
		RequestDispatcher dispatcher = null;
		request.setAttribute("autList", authorService.getAuthorsCatalog());
		try {
			String title = request.getParameter("title");
			String curAuthorStr = request.getParameter("author");
			int publishedYear = Integer.parseInt(request.getParameter("date").split("-")[0]);
			request.setAttribute("title",title );
			if( !bookService.checkIfBookExists(bookService.initializeNewBook(title, curAuthorStr, publishedYear)) ) {
				bookService.createBook(bookService.initializeNewBook(title, curAuthorStr, publishedYear));
				dispatcher = request.getRequestDispatcher(BOOK_ADDED_PAGE);
			}
			else {
				request.setAttribute("book",title);
				dispatcher = request.getRequestDispatcher(BOOK_EXISTS);
			}
		}
		catch(NumberFormatException e) {
			dispatcher = request.getRequestDispatcher(EROOR_INIT_FIELDS);
			e.printStackTrace();
		}
		dispatcher.forward(request, response);
	}

}
