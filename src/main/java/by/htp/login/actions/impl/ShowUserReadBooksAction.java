package by.htp.login.actions.impl;

import static by.htp.login.controller.util.JspPagesPool.BOOKS_LIST_PAGE;
import static by.htp.login.controller.util.JspPagesPool.MAIN_PAGE;
import static by.htp.login.controller.util.RequestParametresPool.BOOKS_LIST;
import static by.htp.login.controller.util.RequestParametresPool.USER_TYPE_SIMPLEUSER;

import javax.servlet.http.HttpServletRequest;
import by.htp.login.actions.BaseAction;
import by.htp.login.actions.util.ActionChecker;
import by.htp.login.bean.SimpleUser;
import by.htp.login.service.BookService;
import by.htp.login.service.impl.BookServiceImpl;


public class ShowUserReadBooksAction implements BaseAction{
	
	private BookService bookService ;
	
	public ShowUserReadBooksAction(){
		bookService = new BookServiceImpl();
	}
	
	@Override
	public String doAction(HttpServletRequest request)  {
		if (ActionChecker.validateSimpleUserSession(request))  {
			SimpleUser user = (SimpleUser) request.getSession().getAttribute(USER_TYPE_SIMPLEUSER);
			request.setAttribute(BOOKS_LIST, bookService.getBookByUserId(user.getId()));
			return (BOOKS_LIST_PAGE);
		}
		else {
			return (MAIN_PAGE);
		}
	}
	

	
}
