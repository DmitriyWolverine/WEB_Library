package by.htp.login.controller;

import by.htp.login.controller.actions.BaseAction;
import by.htp.login.controller.actions.impl.*;

public class ActionManager {
	
	private ActionManager() {
		
	}

	public static BaseAction defineServerAction(String action) {
		BaseAction act = null;
		switch(action) {
			case "log_in":{
				act = new AutorizateAction();
				break;
			}
			case "registration":{
				act = new GoToRegistrationPage();
				break;
			}
			case "registrate":{
				act = new RegistrateAction();
				break;
			}
			case "to_first_page":{
				act = new GoToFirstPage();
				break;
			}
			case "to_admin_page" : {
				act = new GoToAdminPage();
				break;
			}
			case "to_user_page" : {
				act = new GoToUserPage();
				break;
			}
			case "show_books" : {
				act = new ShowBooksAction();
				break;
			}
			case "show_books_edit" :{
				act = new ShowAdminBooksAction();
				break;
			}
			case "add_new_book" : {
				act = new GoToAddNewBookPage();
				break;
			}
			case "add_book" : {
				act = new AddBookAction();
				break;
			}
			case "delete_book" : {
				act = new DeleteBookAction();
				break;
			}
			case "add_book_select" : {
				act = new AddBookSelectAction();
				break;
			}
			case "edit_book" : {
				act = new GoToEditBookPage();
				break;
			}
			case "update_book" : {
				act = new UpdateBookAction();
				break;
			}
			default:{
				act = new DefaultAction();
			}
		}
		 return act;
	}
}
