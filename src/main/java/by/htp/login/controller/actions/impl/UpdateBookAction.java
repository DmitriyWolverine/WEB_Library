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

public class UpdateBookAction implements BaseAction{
	private static int curId;
	
	public static void setCurId(int id) {
		curId = id;
	}

	@Override
	public RequestDispatcher doAction(HttpServletRequest request)
			throws ServletException, IOException {
		BookService bookService = new BookServiceImpl();
		AuthorService authorService = new AuthorServiceImpl();
		request.setAttribute(AUTHORS_LIST, authorService.getAuthorsCatalog());
		String curTitle = request.getParameter(BOOK_TITLE);
		String curAuthorStr = request.getParameter(AUTHOR_STRING);
		int curYear = Integer.parseInt(request.getParameter(DATE_FROM_CALENDAR).split("-")[0]);
		request.setAttribute(BOOK_ID, curId);
		bookService.updateBook(bookService.updateParametres(curId, curTitle, curAuthorStr, curYear));
		return request.getRequestDispatcher(BOOK_UPDATED_PAGE);
	}
}
