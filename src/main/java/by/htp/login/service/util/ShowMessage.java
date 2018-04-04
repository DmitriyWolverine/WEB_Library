package by.htp.login.service.util;

import static by.htp.login.service.util.ServiceExceptionMessages.*;

public class ShowMessage {
	private ShowMessage() {}
	
	public static void showBookIsTakenMessage(String str) {
		System.out.print(str + THIS_BOOK_IS_TAKEN);
	}
	
	public static void showUserHasBookMessage(String str) {
		System.out.print(str + USER_HAS_BOOK);
	}
}
