package by.htp.login.service.util;

public class ServiceExceptionMessages {
	private ServiceExceptionMessages() {}
	
	public static final String ENTITY_IS_NOT_INITIALIZIED		 = "Service exception: Entity is not initialized";
	public static final String PARAMETRES_ARE_NOT_INITIALIZIED   = "Service exception: One or more paramtres are not initialized";
	public static final String SUCH_USER_DOES_NOT_EXIST 		 = "Service exception: Such user does not exist";
	public static final String THIS_BOOK_IS_TAKEN 				 = " is already taken!";
	public static final String USER_HAS_BOOK 					 = " is not given to you, because you have another book!";
}
