package fr.dwaps.web.util;

public final class Constants {
	// Servlets names
	public static final String FRONT_SERVLET_NAME = "FrontServlet";
	public static final String BACK_SERVLET_NAME = "BackServlet";
	
	// Nav tabs labels / actions name
	public static final String HOME_TAB_LABEL = "Accueil";
	public static final String BOOKS_TAB_LABEL = "Liste des livres";
	public static final String CONTACT_TAB_LABEL = "Contact";
	public static final String ADMIN_BOOKS_LIST_LABEL = BOOKS_TAB_LABEL;
	public static final String ADMIN_BOOKS_CREATE_LABEL = "Ajouter un livre";
	public static final String ADMIN_BOOKS_EDIT_LABEL = "Editer d'un livre";
	
	// Frontend action names
	public static final String HOME_TAB_ACTION = "home";
	public static final String BOOKS_TAB_ACTION = "books";
	public static final String CONTACT_TAB_ACTION = "contact";
	
	// Backend action names
	public static final String ACTION_ADMIN_LIST_BOOKS = "list";
	public static final String ACTION_ADMIN_CREATE_BOOK = "create";
	public static final String ACTION_ADMIN_GET_BOOK = "get";
	public static final String ACTION_ADMIN_EDIT_BOOK = "edit";
	public static final String ACTION_ADMIN_DELETE_BOOK = "delete";
	
	// Nav tabs urls
	public static final String HOME_TAB_URL = "/"+HOME_TAB_ACTION;
	public static final String BOOKS_TAB_URL = "/"+BOOKS_TAB_ACTION;
	public static final String CONTACT_TAB_URL = "/"+CONTACT_TAB_ACTION;
	
	// Backend Urls
	public static final String ADMIN_BOOKS_BASEURL = "/admin/books/";
	public static final String ADMIN_BOOKS_LIST_URL = ADMIN_BOOKS_BASEURL+ACTION_ADMIN_LIST_BOOKS;
	public static final String ADMIN_BOOKS_CREATE_URL = ADMIN_BOOKS_BASEURL+ACTION_ADMIN_CREATE_BOOK;
	public static final String ADMIN_BOOKS_GET_URL = ADMIN_BOOKS_BASEURL+ACTION_ADMIN_GET_BOOK;
	public static final String ADMIN_BOOKS_EDIT_URL = ADMIN_BOOKS_BASEURL+ACTION_ADMIN_EDIT_BOOK;
	public static final String ADMIN_BOOKS_DELETE_URL = ADMIN_BOOKS_BASEURL+ACTION_ADMIN_DELETE_BOOK;
	
	// Jsp names
	public static final String JSP_HOME_NAME = "HomeJSP";
	public static final String JSP_BOOKS_NAME = "BooksJSP";
	public static final String JSP_BOOK_NAME = "BookJSP";
	public static final String JSP_BOOK_FORM_NAME = "BookFormJSP";
	public static final String JSP_CONTACT_NAME = "ContactJSP";
	
	// Titles pages
	public static final String TITLE_HOME_PAGE = "Page d'accueil";
	public static final String TITLE_BOOKS_PAGE = "Liste des livres";
	public static final String TITLE_BOOK_PAGE = "Détail d'un livre";
	public static final String TITLE_BOOK_ADD_PAGE = "Création d'un livre";
	public static final String TITLE_BOOK_EDIT_PAGE = "Edition d'un livre";
	public static final String TITLE_CONTACT_PAGE = "Contactez-nous !";
	
	// Session : info messages
	public static final String INFO_ATTR = "info";
	public static final String INFO_BOOK_CREATED_OK = "Le livre a bien été créé";
	public static final String INFO_BOOK_CREATED_FAIL = "Le livre n'a pas pu être créé";
	public static final String INFO_BOOK_UPDATED_OK = "Le livre a bien été mis à jour";
	public static final String INFO_BOOK_UPDATED_FAIL = "Le livre n'a pas pu être mis à jour";
	
	// JAVABEANS
	// Book attributes
	public static final String BOOK_ID = "id";
	public static final String BOOK_TITLE = "title";
	public static final String BOOK_DESCRIPTION = "description";
	public static final String BOOK_AUTHOR = "author";
	public static final String BOOK_IMG = "img";
	public static final String BOOK_PRICE = "price";
	public static final String BOOK_AVAILABLE = "available";
	
	private Constants() {}
}
