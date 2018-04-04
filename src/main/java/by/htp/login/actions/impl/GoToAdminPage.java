package by.htp.login.actions.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.actions.BaseAction;
import by.htp.login.actions.util.ActionChecker;
import by.htp.login.bean.Admin;
import by.htp.login.bean.SimpleUser;
import by.htp.login.service.BookService;
import by.htp.login.service.UserService;
import by.htp.login.service.impl.BookServiceImpl;
import by.htp.login.service.impl.UserServiceImpl;

import static by.htp.login.controller.util.JspPagesPool.*;
import static by.htp.login.controller.util.RequestParametresPool.*;

public class GoToAdminPage implements BaseAction{
	private BookService bookService;
	private UserService userService;
	
	public GoToAdminPage() {
		bookService = new BookServiceImpl();
		userService = new UserServiceImpl();
	}

	@Override
	public String doAction(HttpServletRequest request) {
		if(ActionChecker.validateAdminSession(request)) {
			Admin user = (Admin) request.getSession().getAttribute(USER_TYPE_ADMIN);
			setParametres(request, user);
			return (ADMIN_PAGE);
		}
		else {
			return (MAIN_PAGE);
		}
	}
	
	private void setParametres(HttpServletRequest request, SimpleUser user) {
		request.setAttribute(USER_LOGIN, user.getLogin());
		request.setAttribute(USER_CURRENT_BOOK_ID, userService.getReadingBookId(user) );
		request.setAttribute(BOOKS_LIST, bookService.getBookByUserId(user.getId()));
	}
	
}
