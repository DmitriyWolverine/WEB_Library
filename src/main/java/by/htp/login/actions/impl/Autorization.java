package by.htp.login.actions.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.htp.login.actions.BaseAction;
import by.htp.login.bean.Admin;
import by.htp.login.bean.SimpleUser;
import by.htp.login.service.BookService;
import by.htp.login.service.UserService;
import by.htp.login.service.impl.BookServiceImpl;
import by.htp.login.service.impl.UserServiceImpl;

import static by.htp.login.controller.util.JspPagesPool.*;
import static by.htp.login.controller.util.RequestParametresPool.*;


public class Autorization implements BaseAction{
	private UserService userService = null;
	private BookService bookService = null;
	private String login ;
	private String pass ;
	
	public Autorization() {
		userService = new UserServiceImpl();
		bookService = new BookServiceImpl();
	}
	
	private void initParams(HttpServletRequest request) {
		login = request.getParameter(USER_LOGIN);
		pass = request.getParameter(USER_PASS);
	}

	private String selectAuthority(HttpServletRequest request){
		request.changeSessionId();
		HttpSession session = request.getSession(true);
		if(  userService.readUser(login,pass).isAdmin() ) {
			session.setAttribute(USER_TYPE_ADMIN, userService.readUser(login,pass) );
			request.setAttribute(USER_LOGIN, login);
			Admin admin = (Admin) request.getSession().getAttribute(USER_TYPE_ADMIN);
			request.setAttribute(BOOKS_LIST, bookService.getBookByUserId(admin.getId()));
			request.setAttribute(USER_CURRENT_BOOK_ID, userService.getReadingBookId(admin) );
			return (ADMIN_PAGE);
		}
		else {
			session.setAttribute(USER_TYPE_SIMPLEUSER, userService.readUser(login,pass) );
			request.setAttribute(USER_LOGIN, login);
			SimpleUser user = (SimpleUser) request.getSession().getAttribute(USER_TYPE_SIMPLEUSER);
			request.setAttribute(BOOKS_LIST, bookService.getBookByUserId(user.getId()));
			request.setAttribute(USER_CURRENT_BOOK_ID, userService.getReadingBookId(user) );
			return (SIMPLE_USER_PAGE);
		}
	}

	@Override
	public String doAction(HttpServletRequest request)  {
		initParams(request);
		if(userService.readUser(login,pass)!=null && userService.checkIfUserRegistrated(login, pass)){
			request.setAttribute(USER_LOGIN, login);
			return selectAuthority(request);
		}
		else {
			return (PAGE_ERROR);
		}	
	}

}
