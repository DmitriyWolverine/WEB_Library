package by.htp.login.controller.actions.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.login.controller.actions.BaseAction;
import static by.htp.login.controller.util.ControllerConstantsPool.*;

public class GoToAddNewBookPage implements BaseAction{

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(BOOK_ADDITION_PAGE);
		dispatcher.forward(request, response);
	}
}
