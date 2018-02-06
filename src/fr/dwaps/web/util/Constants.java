package fr.dwaps.web.util;

public final class Constants {
	// Servlets
	public static final String FRONT_SERVLET_NAME = "FrontServlet";
	
	// Nav tabs labels / actions name
	public static final String HOME_TAB_LABEL = "Accueil";
	public static final String HOME_TAB_ACTION = "home";
	
	public static final String BOOKS_TAB_LABEL = "Liste des livres";
	public static final String BOOKS_TAB_ACTION = "books";
	public static final String BOOK_DETAIL_ACTION = "book";
	public static final String BOOK_EDIT_ACTION = "edit";
	public static final String BOOK_DELETE_ACTION = "delete";
	
	public static final String CONTACT_TAB_LABEL = "Contact";
	public static final String CONTACT_TAB_ACTION = "contact";
	
	// Nav tabs url
	public static final String HOME_TAB_URL = "/"+HOME_TAB_ACTION;
	public static final String BOOKS_TAB_URL = "/"+BOOKS_TAB_ACTION;
	public static final String CONTACT_TAB_URL = "/"+CONTACT_TAB_ACTION;
	
	// Url
	public static final String BOOK_DETAIL_URL = "/"+BOOK_DETAIL_ACTION;
	public static final String BOOK_EDIT_URL = "/book/"+BOOK_EDIT_ACTION;
	public static final String BOOK_DELETE_URL = "/book/"+BOOK_DELETE_ACTION;
	
	// Jsp
	public static final String JSP_HOME_NAME = "HomeJSP";
	public static final String JSP_BOOKS_NAME = "BooksJSP";
	public static final String JSP_BOOK_NAME = "BookJSP";
	public static final String JSP_BOOK_FORM_NAME = "BookFormJSP";
	public static final String JSP_CONTACT_NAME = "ContactJSP";
	
	// Titles pages
	public static final String TITLE_HOME_PAGE = "Page d'accueil";
	public static final String TITLE_BOOKS_PAGE = "Liste des livres";
	public static final String TITLE_BOOK_PAGE = "Détail d'un livre";
	public static final String TITLE_CONTACT_PAGE = "Contactez-nous !";
	
	private Constants() {}
}
