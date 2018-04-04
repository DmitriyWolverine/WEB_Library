package by.htp.login.actions.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.actions.BaseAction;
import by.htp.login.actions.util.ActionChecker;
import static by.htp.login.controller.util.JspPagesPool.*;
import static by.htp.login.controller.util.RequestParametresPool.USER_TYPE_ADMIN;
import static by.htp.login.controller.util.RequestParametresPool.USER_TYPE_SIMPLEUSER;

public class GoToFirstPage implements BaseAction {

	@Override
	public String doAction(HttpServletRequest request){
		
		if(ActionChecker.validateAdminSession(request)) {
			request.getSession().removeAttribute(USER_TYPE_ADMIN);
		}
		else if (ActionChecker.validateSimpleUserSession(request))  {
			request.getSession().removeAttribute(USER_TYPE_SIMPLEUSER);
		}
		return (MAIN_PAGE);
	}
	
}
