package by.htp.login.actions;

import static by.htp.login.actions.util.ActionsPool.*;

import java.util.HashMap;
import java.util.Map;

import by.htp.login.actions.impl.*;

public class ActionManager {
	
	private static final ActionManager manager = new ActionManager();
	
	private Map<String, BaseAction> actions;
	
	public ActionManager() {
		actions = new HashMap<>();
		actions.put(LOG_IN, new Autorization());
		actions.put(TO_REGISTRATION_PAGE, new GoToRegistrationPage());
		actions.put(REGISTRATE, new Registration());
		actions.put(TO_MAIN_PAGE, new GoToFirstPage());
		actions.put(TO_ADMIN_PAGE, new GoToAdminPage());
		actions.put(TO_USER_PAGE, new GoToUserPage());
		actions.put(SHOW_BOOKS, new ShowBooksAction());
		actions.put(SHOW_BOOKS_ADVANCED, new ShowAdminBooksAction());
		actions.put(TO_ADDITION_BOOK_PAGE, new GoToAddNewBookPage());
		actions.put(ADD_BOOK_BY_FORMS, new AddBookAction());
		actions.put(DELETE_BOOK, new DeleteBookAction());
		actions.put(ADD_BOOK_BY_CHOOSE, new AddBookSelectAction());
		actions.put(TO_MODIFICATION_BOOK_PAGE, new GoToEditBookPage());
		actions.put(UPDATE_BOOK, new UpdateBookAction());
		actions.put(FIND_BOOKS,new FindBooks());
		actions.put(TAKE_BOOK, new TakeBookAction());
		actions.put(TURN_BACK_BOOK, new TurnBackBookAction());
		actions.put(NO_SUCH_COMMAND, new DefaultAction());
	}

	public static ActionManager getManager() {
		return manager;
	}
	
	public BaseAction defineServerAction(String action) {
		BaseAction act = null;
		if(action != null) {
			act = actions.get(action);
		}
		else {
			act = new DefaultAction();
		}
		return act;
	}
}