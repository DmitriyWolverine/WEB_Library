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

public class AutorizateAction implements BaseAction{
	
	@Override
	public RequestDispatcher doAction(HttpServletRequest request) throws ServletException, IOException {
		String login = request.getParameter(USER_LOGIN);
		String pass = request.getParameter(USER_PASS);
		UserService userService = new UserServiceImpl();
		
		if(userService.readUser(login,pass)!=null ){
			if( userService.checkIfUserRegistrated(login, pass)) {
				request.setAttribute(USER_LOGIN, login);
				if(  userService.readUser(login,pass).isAdmin()) {
					return request.getRequestDispatcher(ADMIN_PAGE);
				}
				else {
					return request.getRequestDispatcher(PAGE_LOGGED_IN);
				}
			}
			else {
				return request.getRequestDispatcher(PAGE_ERROR);
			}	
		}
		else {
			return request.getRequestDispatcher(PAGE_ERROR);
		}	
	}

}
