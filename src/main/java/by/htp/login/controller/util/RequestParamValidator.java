package by.htp.login.controller.util;

import by.htp.login.controller.exceptions.RequestParamValidatorException;

public class RequestParamValidator {
	
	private RequestParamValidator() {}

	public static void validateUserLoginPass(String login, String pass) {
		if(login == null || pass == null) {
			throw new RequestParamValidatorException();
		}
	}
}
