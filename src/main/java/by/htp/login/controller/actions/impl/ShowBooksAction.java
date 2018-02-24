package by.htp.login.controller.actions.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.login.controller.actions.BaseAction;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.BookServiceImpl;

import static by.htp.login.controller.util.ControllerConstantsPool.*;

public class ShowBooksAction implements BaseAction{
	
	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookServiceImpl();
		request.setAttribute("list", bookService.getBooksCatalog());
		RequestDispatcher dispatcher = request.getRequestDispatcher(BOOKS_LIST);
		dispatcher.forward(request, response);
	}
}
