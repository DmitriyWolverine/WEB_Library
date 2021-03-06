package by.htp.login.controller.actions.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import by.htp.login.controller.actions.BaseAction;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.BookServiceImpl;

import static by.htp.login.controller.util.ControllerConstantsPool.*;
import static by.htp.login.controller.util.ControllerParametresConstants.*;

public class ShowBooksAction implements BaseAction{
	
	@Override
	public RequestDispatcher doAction(HttpServletRequest request) throws ServletException, IOException {
		BookService bookService = new BookServiceImpl();
		request.setAttribute(BOOKS_LIST, bookService.getBooksCatalog());
		return request.getRequestDispatcher(BOOKS_LIST_PAGE);
	}
}
