package fr.dwaps.web.util;

import java.util.HashMap;
import java.util.Map;

import fr.dwaps.business.BooksAction;
import fr.dwaps.business.ContactAction;
import fr.dwaps.business.CreateBookAction;
import fr.dwaps.business.DeleteBookAction;
import fr.dwaps.business.EditBookAction;
import fr.dwaps.business.GetBookAction;
import fr.dwaps.business.HomeAction;

public final class ActionManager {
	private static Map<String, AbstractAction> actions = new HashMap<>();
	
	// Frontend
	private static final String ACTION_HOME = Constants.HOME_TAB_ACTION;
	private static final String ACTION_BOOKS = Constants.BOOKS_TAB_ACTION;
	private static final String ACTION_CONTACT = Constants.CONTACT_TAB_ACTION;
	
	// Backend
	private static final String ACTION_ADMIN_LIST_BOOKS = "list";
	private static final String ACTION_ADMIN_GET_BOOK = "get";
	private static final String ACTION_ADMIN_CREATE_BOOK = "create";
	private static final String ACTION_ADMIN_EDIT_BOOK = "edit";
	private static final String ACTION_ADMIN_DELETE_BOOK = "delete";
	
	private ActionManager() {}
	
	static {
		// Frontend
		actions.put(ACTION_HOME, new HomeAction());
		actions.put(ACTION_BOOKS, new BooksAction());
		actions.put(ACTION_CONTACT, new ContactAction());
		
		// Backend
		actions.put(ACTION_ADMIN_LIST_BOOKS, new BooksAction());
		actions.put(ACTION_ADMIN_GET_BOOK, new GetBookAction());
		actions.put(ACTION_ADMIN_CREATE_BOOK, new CreateBookAction());
		actions.put(ACTION_ADMIN_EDIT_BOOK, new EditBookAction());
		actions.put(ACTION_ADMIN_DELETE_BOOK, new DeleteBookAction());
	}
	
	public static AbstractAction getAction(String action) {
		return actions.get(action);
	}
}
