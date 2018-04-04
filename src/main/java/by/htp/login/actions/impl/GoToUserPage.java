package by.htp.login.actions.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.actions.BaseAction;
import by.htp.login.actions.util.ActionChecker;
import by.htp.login.bean.SimpleUser;
import by.htp.login.service.BookService;
import by.htp.login.service.UserService;
import by.htp.login.service.impl.BookServiceImpl;
import by.htp.login.service.impl.UserServiceImpl;

import static by.htp.login.controller.util.JspPagesPool.*;
import static by.htp.login.controller.util.RequestParametresPool.*;

public class GoToUserPage implements BaseAction{
	
	private BookService bookService = null;
	private UserService userService = null;
	public GoToUserPage() {
		userService = new UserServiceImpl();
		bookService = new BookServiceImpl();
	}

	@Override
	public String doAction(HttpServletRequest request){
		String login = ((SimpleUser) request.getSession().getAttribute(USER_TYPE_SIMPLEUSER)).getLogin();
		request.setAttribute(USER_LOGIN, login);
		if (ActionChecker.validateSimpleUserSession(request))  {
			SimpleUser user = (SimpleUser) request.getSession().getAttribute(USER_TYPE_SIMPLEUSER);
			request.setAttribute(USER_CURRENT_BOOK_ID, userService.getReadingBookId(user) );
			request.setAttribute(BOOKS_LIST, bookService.getBookByUserId(user.getId()));
			return (SIMPLE_USER_PAGE);
		}
		else {
			return (MAIN_PAGE);
		}
	}
}
