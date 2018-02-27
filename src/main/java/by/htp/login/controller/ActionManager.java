package by.htp.login.controller;

import by.htp.login.controller.actions.BaseAction;
import by.htp.login.controller.actions.impl.*;
import static by.htp.login.controller.util.ControllerActionConstants.*;

public class ActionManager {
	
	private ActionManager() {
		
	}

	public static BaseAction defineServerAction(String action) {
		BaseAction act = null;
		switch(action) {
			case LOG_IN : {
				act = new AutorizateAction();
				break;
			}
			case TO_REGISTRATION_PAGE : {
				act = new GoToRegistrationPage();
				break;
			}
			case REGISTRATE : {
				act = new RegistrateAction();
				break;
			}
			case TO_MAIN_PAGE : {
				act = new GoToFirstPage();
				break;
			}
			case TO_ADMIN_PAGE : {
				act = new GoToAdminPage();
				break;
			}
			case TO_USER_PAGE : {
				act = new GoToUserPage();
				break;
			}
			case SHOW_BOOKS : {
				act = new ShowBooksAction();
				break;
			}
			case SHOW_BOOKS_ADVANCED : {
				act = new ShowAdminBooksAction();
				break;
			}
			case TO_ADDITION_BOOK_PAGE : {
				act = new GoToAddNewBookPage();
				break;
			}
			case ADD_BOOK_BY_FORMS : {
				act = new AddBookAction();
				break;
			}
			case DELETE_BOOK : {
				act = new DeleteBookAction();
				break;
			}
			case ADD_BOOK_BY_CHOOSE : {
				act = new AddBookSelectAction();
				break;
			}
			case TO_MODIFICATION_BOOK_PAGE : {
				act = new GoToEditBookPage();
				break;
			}
			case UPDATE_BOOK : {
				act = new UpdateBookAction();
				break;
			}
			default : {
				act = new DefaultAction();
			}
		}
		 return act;
	}
}
