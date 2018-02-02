package fr.dwaps.web.util;

import java.util.HashMap;
import java.util.Map;

import fr.dwaps.business.BooksAction;
import fr.dwaps.business.ContactAction;
import fr.dwaps.business.HomeAction;

public final class ActionManager {
	private static Map<String, AbstractAction> actions = new HashMap<>();
	
	private static final String ACTION_HOME = Constants.HOME_TAB_ACTION;
	private static final String ACTION_BOOKS = Constants.BOOKS_TAB_ACTION;
	private static final String ACTION_CONTACT = Constants.CONTACT_TAB_ACTION;
	
	private ActionManager() {}
	
	static {
		actions.put(ACTION_HOME, new HomeAction());
		actions.put(ACTION_BOOKS, new BooksAction());
		actions.put(ACTION_CONTACT, new ContactAction());
	}
	
	public static AbstractAction getAction(String action) {
		return actions.get(action);
	}
}
