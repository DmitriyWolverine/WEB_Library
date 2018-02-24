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

public class RegistrateAction implements BaseAction{
	private static final String LOGIN_STR = "login";
	private static final String PASS = "password";

	@Override
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		String login = request.getParameter(LOGIN_STR);
		String pass = request.getParameter(PASS);
		UserService userService = new UserServiceImpl();
		if( !userService.checkIfUserRegistrated(login, pass) ) {
			userService.createUser(login, pass);
			request.setAttribute(LOGIN_STR, login);
			request.setAttribute(PASS, pass);
			dispatcher = request.getRequestDispatcher(PAGE_FIN_REG);
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute(LOGIN_STR, login);
			dispatcher = request.getRequestDispatcher(PAGE_USER_EXISTS);
			dispatcher.forward(request, response);
		}
	}
}
