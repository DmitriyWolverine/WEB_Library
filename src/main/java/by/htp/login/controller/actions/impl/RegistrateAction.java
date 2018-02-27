package by.htp.login.controller.actions.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import by.htp.login.controller.actions.BaseAction;
import by.htp.login.service.UserService;
import by.htp.login.service.impl.UserServiceImpl;

import static by.htp.login.controller.util.ControllerConstantsPool.*;
import static by.htp.login.controller.util.ControllerParametresConstants.*;

public class RegistrateAction implements BaseAction{

	@Override
	public RequestDispatcher doAction(HttpServletRequest request) throws ServletException, IOException {
		String login = request.getParameter(USER_LOGIN).trim();
		String pass = request.getParameter(USER_PASS);
		UserService userService = new UserServiceImpl();
		if( !userService.checkIfUserRegistrated(login, pass) ) {
			if( userService.createUser(login, pass) != null )	{
				request.setAttribute(USER_LOGIN, login);
				return request.getRequestDispatcher(PAGE_FIN_REG);
			}
			else {
				return request.getRequestDispatcher(PAGE_REG_FAILED);
			}
			
		}
		else {
			request.setAttribute(USER_LOGIN, login);
			return request.getRequestDispatcher(PAGE_USER_EXISTS);

		}
	}
}
