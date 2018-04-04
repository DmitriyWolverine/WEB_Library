package by.htp.login.dao.util;

import by.htp.login.dao.exception.DaoIncorrectInputDataException;

public class DaoExceptionHandler {
	
	private DaoExceptionHandler() {}
	
	public static void showDaoExceptionStackTrace(String message) {
		new DaoIncorrectInputDataException(message).printStackTrace();
	}
}
