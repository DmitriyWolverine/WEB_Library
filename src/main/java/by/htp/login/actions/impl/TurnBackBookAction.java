package by.htp.login.actions.impl;


import static by.htp.login.controller.util.JspPagesPool.*;
import static by.htp.login.controller.util.RequestParametresPool.BOOKS_LIST;
import static by.htp.login.controller.util.RequestParametresPool.BOOK_ID;
import static by.htp.login.controller.util.RequestParametresPool.USER_CURRENT_BOOK_ID;
import static by.htp.login.controller.util.RequestParametresPool.USER_LOGIN;
import static by.htp.login.controller.util.RequestParametresPool.USER_TYPE_ADMIN;
import static by.htp.login.controller.util.RequestParametresPool.USER_TYPE_SIMPLEUSER;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.actions.BaseAction;
import by.htp.login.actions.util.ActionChecker;
import by.htp.login.bean.Admin;
import by.htp.login.bean.SimpleUser;
import by.htp.login.bean.User;
import by.htp.login.service.BookService;
import by.htp.login.service.UserService;
import by.htp.login.service.impl.BookServiceImpl;
import by.htp.login.service.impl.UserServiceImpl;


public class TurnBackBookAction implements BaseAction{

	private int curBookId;
	
	private BookService bookService;
	private UserService userService;
	
	public TurnBackBookAction() {
		bookService = new BookServiceImpl();
		userService = new UserServiceImpl();
	}
	
	private void initParametres (HttpServletRequest request) {
		curBookId = Integer.parseInt(request.getParameter(BOOK_ID) ) ;
	}

	@Override
	public String doAction(HttpServletRequest request){
		if(ActionChecker.validateAdminSession(request)) {
			return doAdminAction(request);
		}
		else if (ActionChecker.validateSimpleUserSession(request))  {
			return doUserAction(request);
		}
		else {
			return MAIN_PAGE;
		}
	}
	
	private String doAdminAction(HttpServletRequest request) {
		Admin user = (Admin) request.getSession().getAttribute(USER_TYPE_ADMIN);
		if(mainActions(request, user)) {
			return (ADMIN_PAGE);
		}
		else {
			return (EROOR_IMPOSSIBLE_OPERATION_ADMIN);
		}
	}
	
	private String doUserAction(HttpServletRequest request) {
		SimpleUser user = (SimpleUser) request.getSession().getAttribute(USER_TYPE_SIMPLEUSER);
		if(mainActions(request, user)) {
			return (SIMPLE_USER_PAGE);
		}
		else {
			return (EROOR_IMPOSSIBLE_OPERATION_USER);
		}
	}
	
	private boolean mainActions(HttpServletRequest request, User user) {
		initParametres(request);
		request.setAttribute(USER_LOGIN, user.getLogin());
		if(!bookAvailable()){
			userService.initCurrentBook(user, null);
			bookService.changeStatusBook(curBookId, true);
			request.setAttribute(USER_CURRENT_BOOK_ID, userService.getReadingBookId(user) );
			request.setAttribute(BOOKS_LIST, bookService.getBookByUserId(user.getId()));
			return true;
		}
		request.setAttribute(USER_CURRENT_BOOK_ID, userService.getReadingBookId(user) );
		request.setAttribute(BOOKS_LIST, bookService.getBookByUserId(user.getId()));
		return false;
	}
	
	private boolean bookAvailable() {
		return (bookService.getBookById(curBookId).isAvailable());
	}

}
