package by.htp.login.actions.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.actions.BaseAction;
import by.htp.login.actions.util.ActionChecker;

import static by.htp.login.controller.util.JspPagesPool.*;

public class GoToAddNewBookPage implements BaseAction{

	@Override
	public String doAction(HttpServletRequest request)  {
		if(ActionChecker.validateAdminSession(request)) {
			return (BOOK_ADDITION_PAGE);
		}
		else {
			return (MAIN_PAGE);
		}
	}
}
