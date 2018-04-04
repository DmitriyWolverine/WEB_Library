package by.htp.login.controller.util;

public class JspPagesPool {
	private JspPagesPool() {}
	
	public static final String MAIN_PAGE           		  = "/index.jsp";
	public static final String SIMPLE_USER_PAGE      	  = "/userPage.jsp";
	public static final String ADMIN_PAGE 	  	  		  = "/adminPage.jsp";
	
	public static final String PAGE_ERROR          		  = "/incorrectLoginOrPasswordError.jsp";
	public static final String PAGE_REGISTRATION  		  = "/registration.jsp";
	public static final String PAGE_USER_EXISTS    		  = "/userExists.jsp";
	public static final String PAGE_FIN_REG 	  		  = "/successfulRegistration.jsp";
	public static final String PAGE_REG_FAILED 			  = "/registrationFailure.jsp";
	public static final String BOOKS_LIST_PAGE    		  = "/booksList.jsp";

	public static final String BOOK_ADDITION_PAGE 		  = "/bookAddition.jsp";
	public static final String BOOKS_LIST_ADMIN_PAGE	  = "/adminBooksList.jsp";
	public static final String BOOK_EDIT_PAGE      		  = "/editPage.jsp";
	public static final String EROOR_INIT_FIELDS_PAGE     = "/formsNotFilledError.jsp";
	public static final String EROOR_IMPOSSIBLE_OPERATION_USER     ="/imposibleBookOperationUser.jsp";
	public static final String EROOR_IMPOSSIBLE_OPERATION_ADMIN     ="/imposibleBookOperationAdmin.jsp";

}