package fr.dwaps.web.util;

public final class Constants {
	// Servlets
	public static final String FRONT_SERVLET_NAME = "FrontServlet";
	
	// Nav tabs labels / actions name
	public static final String HOME_TAB_LABEL = "Accueil";
	public static final String HOME_TAB_ACTION = "home";
	public static final String BOOKS_TAB_LABEL = "Liste des livres";
	public static final String BOOKS_TAB_ACTION = "books";
	public static final String CONTACT_TAB_LABEL = "Contact";
	public static final String CONTACT_TAB_ACTION = "contact";
	
	// Nav tabs url
	public static final String HOME_TAB_URL = "/"+HOME_TAB_ACTION;
	public static final String BOOKS_TAB_URL = "/"+BOOKS_TAB_ACTION;
	public static final String CONTACT_TAB_URL = "/"+CONTACT_TAB_ACTION;
	
	// Jsp
	public static final String JSP_HOME_NAME = "HomeJSP";
	public static final String JSP_BOOKS_NAME = "BooksJSP";
	public static final String JSP_CONTACT_NAME = "ContactJSP";
	
	// Titles pages
	public static final String TITLE_HOME_PAGE = "Page d'accueil";
	public static final String TITLE_BOOKS_PAGE = "Liste des livres";
	public static final String TITLE_CONTACT_PAGE = "Contactez-nous !";
	
	private Constants() {}
}
