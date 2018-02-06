package fr.dwaps.web.servlets;

import static fr.dwaps.web.util.Constants.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dwaps.model.dao.DAOFactory;
import fr.dwaps.web.util.ActionManager;

@WebServlet(
	name=FRONT_SERVLET_NAME,
	urlPatterns={
		HOME_TAB_URL,
		BOOKS_TAB_URL,
		BOOK_DETAIL_URL,
		BOOK_DELETE_URL,
		BOOK_EDIT_URL,
		CONTACT_TAB_URL })
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String getActionName(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return uri.substring(uri.lastIndexOf("/")+1);
	}
	
	public static void main(String[] args) {
		Connection cnx = null;
		try {
			cnx = DAOFactory.getConnection();
			
			PreparedStatement ps = cnx.prepareStatement("INSERT INTO Book (title, price) VALUES(?, ?)");
			ps.setString(1, "fghjkljh");
			ps.setDouble(2, 55.33);
			
			ps.executeUpdate();
			
		}
		catch (Exception e) {}
		finally { DAOFactory.closeConnection(cnx); }
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = getActionName(request);
		String jspName = ActionManager.getAction(actionName).executeAction(request);
		
		getServletContext()
			.getNamedDispatcher(jspName)
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}