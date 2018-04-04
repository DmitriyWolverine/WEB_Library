package by.htp.login.actions.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.actions.BaseAction;
import by.htp.login.service.UserService;
import by.htp.login.service.impl.UserServiceImpl;

import static by.htp.login.controller.util.JspPagesPool.*;
import static by.htp.login.controller.util.RequestParametresPool.*;

public class Registration implements BaseAction{

	private UserService userService;
	
	private String login = null;
	private String pass = null;
	
	public Registration() {
		 userService = new UserServiceImpl();
	}
	
	private void initParams(HttpServletRequest request) {
		login = request.getParameter(USER_LOGIN).trim();
		pass = request.getParameter(USER_PASS);
	}
	
	private void createNewSession(HttpServletRequest request) {
		request.changeSessionId();
		HttpSession session = request.getSession(true);
		session.setAttribute(USER_TYPE_SIMPLEUSER, userService.readUser(login,pass) );
	}
	
	@Override
	public String doAction(HttpServletRequest request) {
		initParams(request);
		if( !userService.checkIfUserRegistrated(login, pass) ) {
			if( userService.createUser(login, pass) != null )	{
				createNewSession(request);
				request.setAttribute(USER_LOGIN, login);
				return (SIMPLE_USER_PAGE);
			}
			else {
				return (PAGE_REG_FAILED);
			}
		}
		else {
			request.setAttribute(USER_LOGIN, login);
			return (PAGE_USER_EXISTS);

		}
	}
}
