package by.htp.login.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.login.actions.ActionManager;
import by.htp.login.actions.BaseAction;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public MainServlet() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		System.out.println("doPost");
		String action = request.getParameter("action");
		BaseAction currentAction = ActionManager.getManager().defineServerAction(action);
		try {
			String actionResult = currentAction.doAction(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher(actionResult);
			dispatcher.forward(request, response);
		}
		catch(ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}