package by.htp.login.actions.impl;

import javax.servlet.http.HttpServletRequest;

import by.htp.login.actions.BaseAction;

import static by.htp.login.controller.util.JspPagesPool.*;

public class GoToRegistrationPage implements BaseAction {

	@Override
	public String doAction(HttpServletRequest request){
		return (PAGE_REGISTRATION);
	}
}
