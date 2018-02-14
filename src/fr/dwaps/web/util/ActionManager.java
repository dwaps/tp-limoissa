package fr.dwaps.web.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import fr.dwaps.business.ContactAction;
import fr.dwaps.business.CreateBookAction;
import fr.dwaps.business.DeleteBookAction;
import fr.dwaps.business.EditBookAction;
import fr.dwaps.business.HomeAction;
import fr.dwaps.business.ListBooksAction;

public final class ActionManager {
	private static Map<String, AbstractAction> actions = new HashMap<>();
	
	// Frontend
	private static final String ACTION_HOME = Constants.HOME_TAB_ACTION;
	private static final String ACTION_BOOKS = Constants.BOOKS_TAB_ACTION;
	private static final String ACTION_CONTACT = Constants.CONTACT_TAB_ACTION;
	
	// Backend
	private static final String ACTION_ADMIN_LIST_BOOKS = "list";
	private static final String ACTION_ADMIN_CREATE_BOOK = "create";
	private static final String ACTION_ADMIN_EDIT_BOOK = "edit";
	private static final String ACTION_ADMIN_DELETE_BOOK = "delete";
	
	private static final String ACTION_SIGNIN = Constants.ACTION_SIGNIN;
	private static final String ACTION_LOGIN = Constants.ACTION_LOGIN;
	private static final String ACTION_LOGOUT = Constants.ACTION_LOGOUT;
	
	private ActionManager() {}
	
	static {
		// Frontend
		actions.put(ACTION_HOME, new HomeAction());
		actions.put(ACTION_BOOKS, new ListBooksAction());
		actions.put(ACTION_CONTACT, new ContactAction());
		
		// Backend
		actions.put(ACTION_ADMIN_LIST_BOOKS, new ListBooksAction());
		actions.put(ACTION_ADMIN_CREATE_BOOK, new CreateBookAction());
		actions.put(ACTION_ADMIN_EDIT_BOOK, new EditBookAction());
		actions.put(ACTION_ADMIN_DELETE_BOOK, new DeleteBookAction());
		
//		actions.put(ACTION_SIGNIN, new SigninAction());
//		actions.put(ACTION_LOGIN, new LoginAction());
//		actions.put(ACTION_LOGOUT, new LogoutAction());
	}
	
	public static AbstractAction getAction(HttpServletRequest request) {
		String actionName = getActionName(request);
		return actions.get(actionName);
	}
	
	public static String getActionName(HttpServletRequest request) {
		String uri = request.getRequestURI();
		return uri.substring(uri.lastIndexOf("/")+1);
	}
}
