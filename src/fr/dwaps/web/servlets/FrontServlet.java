package fr.dwaps.web.servlets;

import static fr.dwaps.web.util.Constants.BOOKS_TAB_URL;
import static fr.dwaps.web.util.Constants.CONTACT_TAB_URL;
import static fr.dwaps.web.util.Constants.FRONT_SERVLET_NAME;
import static fr.dwaps.web.util.Constants.HOME_TAB_URL;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dwaps.web.util.ActionManager;

@WebServlet(
	name=FRONT_SERVLET_NAME,
	urlPatterns={
		HOME_TAB_URL,
		BOOKS_TAB_URL,
		CONTACT_TAB_URL })
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspName = ActionManager
			.getAction(request)
			.executeAction(request);
		
		getServletContext()
			.getNamedDispatcher(jspName)
			.forward(request, response);
	}
}











