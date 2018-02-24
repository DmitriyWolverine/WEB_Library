package by.htp.login.controller.actions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseAction {

	void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ;
}
