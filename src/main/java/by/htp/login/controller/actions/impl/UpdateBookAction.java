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

public class UpdateBookAction implements BaseAction{
	private static int curId;
	
	public static void setCurId(int id) {
		curId = id;
	}

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		BookService bookService = new BookServiceImpl();
		AuthorService authorService = new AuthorServiceImpl();
		request.setAttribute("autList", authorService.getAuthorsCatalog());
		String curTitle = request.getParameter("title");
		String curAuthorStr = request.getParameter("author");
		int curYear = Integer.parseInt(request.getParameter("date").split("-")[0]);
		request.setAttribute("id", curId);
		bookService.updateBook(bookService.updateParametres(curId, curTitle, curAuthorStr, curYear));
		RequestDispatcher dispatcher = request.getRequestDispatcher(BOOK_UPDATED_PAGE);
		dispatcher.forward(request, response);
		
	}
}
