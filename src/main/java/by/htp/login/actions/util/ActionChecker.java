package by.htp.login.actions.util;

import static by.htp.login.controller.util.RequestParametresPool.USER_TYPE_ADMIN;
import static by.htp.login.controller.util.RequestParametresPool.USER_TYPE_SIMPLEUSER;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.bean.Admin;
import by.htp.login.bean.SimpleUser;

public class ActionChecker {
	private ActionChecker() {
		
	}
	public static boolean validateAdminSession(HttpServletRequest request) {
		return (request.getSession().getAttribute(USER_TYPE_ADMIN) != null && request.getSession().getAttribute(USER_TYPE_ADMIN).getClass() == Admin.class);
	}

	public static boolean validateSimpleUserSession(HttpServletRequest request) {
		return (request.getSession().getAttribute(USER_TYPE_SIMPLEUSER) != null && request.getSession().getAttribute(USER_TYPE_SIMPLEUSER).getClass() == SimpleUser.class) ;
	}
}
