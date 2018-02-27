package by.htp.login.controller.actions.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import by.htp.login.controller.actions.BaseAction;
import static by.htp.login.controller.util.ControllerConstantsPool.*;

public class DefaultAction implements BaseAction{

	@Override
	public RequestDispatcher doAction(HttpServletRequest request)
			throws ServletException, IOException {
		return request.getRequestDispatcher(MAIN_PAGE);

	}
}
