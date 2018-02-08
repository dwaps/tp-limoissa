package fr.dwaps.web.servlets;

import static fr.dwaps.web.util.Constants.ADMIN_BOOKS_CREATE_URL;
import static fr.dwaps.web.util.Constants.ADMIN_BOOKS_DELETE_URL;
import static fr.dwaps.web.util.Constants.ADMIN_BOOKS_EDIT_URL;
import static fr.dwaps.web.util.Constants.ADMIN_BOOKS_GET_URL;
import static fr.dwaps.web.util.Constants.ADMIN_BOOKS_LIST_URL;
import static fr.dwaps.web.util.Constants.BACK_SERVLET_NAME;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dwaps.web.util.ActionManager;

@WebServlet(
	name=BACK_SERVLET_NAME,
	urlPatterns={
		ADMIN_BOOKS_LIST_URL,
		ADMIN_BOOKS_CREATE_URL,
		ADMIN_BOOKS_GET_URL,
		ADMIN_BOOKS_EDIT_URL,
		ADMIN_BOOKS_DELETE_URL})
public class BackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String getActionName(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return uri.substring(uri.lastIndexOf("/")+1);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = getActionName(request);
		String jspName = ActionManager.getAction(actionName).executeAction(request);
		
		getServletContext()
			.getNamedDispatcher(jspName)
			.forward(request, response);
		
		request.getSession().removeAttribute("info");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = getActionName(request);
		ActionManager.getAction(actionName).executeAction(request);
		String url = request.getContextPath() + (String) request.getAttribute("redirectUrl");
		response.sendRedirect(url);
	}

}
