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

public class GoToEditBookPage implements BaseAction {

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookService bookService = new BookServiceImpl();
		request.setAttribute("list", bookService.getBooksCatalog());
		UpdateBookAction.setCurId(Integer.parseInt(request.getParameter("bookid") ));
		AuthorService autService = new AuthorServiceImpl();
		request.setAttribute("autList", autService.getAuthorsCatalog());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(BOOK_EDIT_PAGE);
		dispatcher.forward(request, response);
		
	}
}
