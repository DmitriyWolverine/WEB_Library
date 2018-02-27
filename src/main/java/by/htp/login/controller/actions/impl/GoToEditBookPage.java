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

public class GoToEditBookPage implements BaseAction {

	@Override
	public RequestDispatcher doAction(HttpServletRequest request)
			throws ServletException, IOException {

		BookService bookService = new BookServiceImpl();
		request.setAttribute(BOOKS_LIST, bookService.getBooksCatalog());
		UpdateBookAction.setCurId(Integer.parseInt(request.getParameter(BOOK_ID) ));
		AuthorService autService = new AuthorServiceImpl();
		request.setAttribute(AUTHORS_LIST, autService.getAuthorsCatalog());
		
		return request.getRequestDispatcher(BOOK_EDIT_PAGE);
		
	}
}
