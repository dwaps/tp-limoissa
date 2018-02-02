package fr.dwaps.web.servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dwaps.web.util.NavigationTabs;

@WebServlet(
		name="FrontServlet",
		urlPatterns={"/home","/books","/contact"})
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String HOME_JSP = "HomeJSP";
	private static final String BOOKS_JSP = "BooksJSP";
	private static final String CONTACT_JSP = "ContactJSP";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String ctxPath = config.getServletContext().getContextPath();
		
		for (NavigationTabs tab : NavigationTabs.values()) {
			tab.setUrlWithCtxPath(ctxPath);
		}
		
		super.init(config);
	}
	
	private String getActionName(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return uri.substring(uri.lastIndexOf("/")+1);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = getActionName(request);
		
		// Nav tabs
		for (NavigationTabs tab : NavigationTabs.values()) {
			tab.setActive(false);
			if (tab.getUrl().equals(request.getRequestURI())) {
				tab.setActive(true);
			}
		}
		request.setAttribute("tabs", NavigationTabs.values());
		
		// Routing
		String jspName = HOME_JSP;
		request.setAttribute("title", "Page d'accueil");
		
		switch (actionName) {
			case "books":
				jspName = BOOKS_JSP;
				request.setAttribute("title", "Liste des livres");
				break;
			case "contact":
				jspName = CONTACT_JSP;
				request.setAttribute("title", "Contactez-nous !");
				break;
		}
		
		getServletContext()
			.getNamedDispatcher(jspName)
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}