package by.htp.login.service.util;

import static by.htp.login.service.util.ServiceExceptionMessages.*;

import by.htp.login.service.exceptions.*;

public class ExceptionHandler {
	private ExceptionHandler() {}
	
	public static void showEntityIsNotInitializedMessage() {
		new ServiceUnpreparedEntityEsception(ENTITY_IS_NOT_INITIALIZIED).printStackTrace();
	}
	
	public static void showParametresAreNotInitializedMessage() {
		new ServiceWrongParameterException(PARAMETRES_ARE_NOT_INITIALIZIED).printStackTrace();
	}
	public static void showWrongLoginOrPasswordMessage() {
		new ServiceWrongParameterException(SUCH_USER_DOES_NOT_EXIST).printStackTrace();
	}

}
