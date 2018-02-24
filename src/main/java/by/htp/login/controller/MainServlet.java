package by.htp.login.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.login.controller.actions.BaseAction;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init");
	}
	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		String action = request.getParameter("action");
		BaseAction currentAction = ActionManager.defineServerAction(action);
		try {
			currentAction.doAction(request, response);
		}
		catch(ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
