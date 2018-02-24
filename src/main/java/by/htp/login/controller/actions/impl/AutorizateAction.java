package by.htp.login.controller.actions.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.login.controller.actions.BaseAction;

import by.htp.login.service.UserService;
import by.htp.login.service.impl.UserServiceImpl;

import static by.htp.login.controller.util.ControllerConstantsPool.*;

public class AutorizateAction implements BaseAction{
	private static final String USER_LOGIN = "login";
	private static final String USER_PASS = "password";
	
	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String login = request.getParameter(USER_LOGIN);
		String pass = request.getParameter(USER_PASS);
		UserService userService = new UserServiceImpl();
		if( userService.checkIfUserRegistrated(login, pass)) {
			request.setAttribute(USER_LOGIN, login);
			if(userService.readUser(login,pass).isAdmin()) {
				dispatcher = request.getRequestDispatcher(ADMIN_PAGE);
			}
			else {
				dispatcher = request.getRequestDispatcher(PAGE_LOGGED_IN);
			}
			dispatcher.forward(request, response);
		}
		else {
			dispatcher = request.getRequestDispatcher(PAGE_ERROR);
			dispatcher.forward(request, response);
		}	
	}

}
